package clover.mlclover.services;

import clover.mlclover.dtos.*;
import clover.mlclover.entities.Cartao;
import clover.mlclover.entities.Cliente;
import clover.mlclover.entities.Endereco;
import clover.mlclover.entities.LocalidadeCep;
import clover.mlclover.entities.enums.Perfil;
import clover.mlclover.entities.enums.TipoCliente;
import clover.mlclover.repositories.CartaoRepository;
import clover.mlclover.repositories.ClienteRepository;
import clover.mlclover.repositories.EnderecoRepository;
import clover.mlclover.repositories.LocalidadeCepRepository;
//import clover.mlclover.security.UserSS;
//import clover.mlclover.services.exceptions.AuthorizationException;
import clover.mlclover.services.exceptions.DataIntegrityException;
import clover.mlclover.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//import com.gtbr.ViaCepClient;
//import com.gtbr.domain.Cep;

import org.apache.commons.codec.binary.Base64;


import javax.transaction.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repo;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private LocalidadeCepRepository cepRepository;

    @Autowired
    CartaoRepository cartaoRepository;

//    @Autowired
//    BCryptPasswordEncoder encoder;


    /**
     * Codifica string na base 64 (Encoder)
     */
    public static String codificaBase64Encoder(String msg) {
        return new Base64().encodeToString(msg.getBytes());
    }

    /**
     * Decodifica string na base 64 (Decoder)
     */
    public static String decodificaBase64Decoder(String msg) {
        return new String(new Base64().decode(msg));
    }


    public Cliente find(Integer id){

//        UserSS user = UserService.authenticated();
//        if(user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())){
//            throw new AuthorizationException("Acesso negado");
//        }
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));

    }

    public ClienteCompletoDTO findDTO(Integer id){

        if(!isLogado(id)){
            throw new RuntimeException("Acesso negado. Login necessário");
        }

//        UserSS user = UserService.authenticated();
//        if(user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())){
//            throw new AuthorizationException("Acesso negado");
//        }
        Cliente obj = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
        return new ClienteCompletoDTO(obj);

    }

    @Transactional
    public Cliente cadastroInicial(Cliente obj) {
        obj.setSenha(codificaBase64Encoder(obj.getSenha()));
        obj = repo.save(obj);
        return obj;
    }
    @Transactional
    public ClienteCompletoDTO cadastroFinalizacaoCompra(ClienteUpdateFinalizacaoCompraDTO objDto, Integer id) {
        if(!isLogado(id)){
            throw new RuntimeException("Acesso negado. Login necessário");
        }

        Cliente cliente = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
       cliente.setTipo(TipoCliente.toEnum(objDto.getTipo()));
       cliente.setCpfOuCnpj(objDto.getCpfOuCnpj());
       cliente.setGenero(objDto.getGenero());
       cliente.setDataNascimento(objDto.getDataNascimento());
       cliente.setEnderecos(objDto.getEnderecos().stream().map(x -> new Endereco(x)).collect(Collectors.toList()));

       Cliente cli = repo.save(cliente);

       ClienteCompletoDTO clienteCompleto = new ClienteCompletoDTO();


       clienteCompleto.setId(cliente.getId());
       clienteCompleto.setNome(cli.getNome());
       clienteCompleto.setEmail(cli.getEmail());
       clienteCompleto.setTelefone(cli.getTelefone());
       clienteCompleto.setCpfOuCnpj(cli.getCpfOuCnpj());
       clienteCompleto.setTipo(cli.getTipo());
       clienteCompleto.setGenero(cli.getGenero());
       clienteCompleto.setDataNascimento(cli.getDataNascimento());
       clienteCompleto.setPerfis(cli.getPerfis().stream().map(x -> x.getCod()).collect(Collectors.toSet()));
       clienteCompleto.setCartoes(cli.getCartoes().stream().map(x -> new CartaoGetDTO(x)).collect(Collectors.toList()));

       List<Endereco> enderecos = new ArrayList<>();

       for(EnderecoDTO e : objDto.getEnderecos()){
           Endereco endereco = new Endereco();

           endereco.setCliente(cli);
           endereco.setComplemento(e.getComplemento());
           endereco.setLocalidadeCep(e.getLocalidadeCep());
           endereco.setNumero(e.getNumero());
           endereco.setDestinatario(e.getDestinatario());
           enderecos.add(endereco);
       }

       List<Endereco> listaEnderecos = enderecoRepository.saveAll(enderecos);
       clienteCompleto.setEnderecos(listaEnderecos);

       return clienteCompleto;
    }

    public Cliente update(Cliente obj) {

        Cliente newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        if(!isLogado(id)){
            throw new RuntimeException("Acesso negado. Login necessário");
        }
        find(id);
        try{
            repo.deleteById(id);
        } catch(DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionadas");
        }
    }
    public List<Cliente> findAll() {
        return repo.findAll();
    }

    public Page<Cliente> findPage(
            Integer page,
            Integer linesPerPage,
            String orderBy,
            String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        return repo.findAll(pageRequest);
    }

    private void updateData(Cliente newObj, Cliente obj){
        newObj.setEmail(obj.getEmail());
        newObj.setNome(obj.getNome());
    }

    public CepDTO consultaCep(String cep) {

        // Cep endereco = ViaCepClient.findCep(cep);
        LocalidadeCep localidade = cepRepository.findById(cep).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! CEP: " + cep + ", Tipo: " + LocalidadeCep.class.getName()));

        return new CepDTO(localidade);
    }

    public List<EnderecoDTO> cadastroEndereco(Integer idCliente, EnderecoListaDTO enderecos) {
        if(!isLogado(idCliente)){
            throw new RuntimeException("Acesso negado. Login necessário");
        }

        Cliente cliente = repo.findById(idCliente).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + idCliente + ", Tipo: " + Cliente.class.getName()));

        List<Endereco> lista = new ArrayList<>();

        for(EnderecoDTO e : enderecos.getEnderecos()){
            Endereco endereco = new Endereco();

            endereco.setCliente(cliente);
            endereco.setComplemento(e.getComplemento());
            endereco.setLocalidadeCep(e.getLocalidadeCep());
            endereco.setNumero(e.getNumero());
            endereco.setDestinatario(e.getDestinatario());
            lista.add(endereco);
        }

        enderecoRepository.saveAll(lista);

        List<Endereco> listaEnderecos = enderecoRepository.findByClienteId(idCliente);
        List<EnderecoDTO> listaEnderecosDTO = new ArrayList<>();
        for(Endereco e : listaEnderecos){
            listaEnderecosDTO.add(new EnderecoDTO(e));
        }
        return listaEnderecosDTO;
    }

    public List<EnderecoDTO> updateEndereco(Integer idCliente, Integer idEndereco, EnderecoDTO endereco) {

        if(!isLogado(idCliente)){
            throw new RuntimeException("Acesso negado. Login necessário");
        }

        Endereco e = enderecoRepository.findByIdAndClienteId(idEndereco, idCliente);

        if(e == null){
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + idEndereco+ ", Tipo: " + Endereco.class.getName());
        }

        e.setComplemento(endereco.getComplemento());
        e.setDestinatario(endereco.getDestinatario());
        e.setNumero(endereco.getNumero());
        e.setLocalidadeCep(endereco.getLocalidadeCep());

        enderecoRepository.save(e);

        return getEnderecos(idCliente);

    }

    public List<EnderecoDTO> getEnderecos(Integer idCliente) {
        if(!isLogado(idCliente)){
            throw new RuntimeException("Acesso negado. Login necessário");
        }
        return enderecoRepository.findByClienteId(idCliente).stream().map(x -> new EnderecoDTO(x)).collect(Collectors.toList());
    }

    public boolean deleteEndereco(Integer idCliente, Integer idEndereco) {
        if(!isLogado(idCliente)){
            throw new RuntimeException("Acesso negado. Login necessário");
        }

        enderecoRepository.deleteByIdAndClienteId(idEndereco, idCliente);

        Endereco e = enderecoRepository.findById(idEndereco).orElse(null);

        return e == null;

    }

    // CARTÕES

    public List<CartaoGetDTO> cadastroCartao(CartaoDTO dto, Integer idCliente) {
        if(!isLogado(idCliente)){
            throw new RuntimeException("Acesso negado. Login necessário");
        }

        Cliente cliente = repo.findById(idCliente).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + idCliente + ", Tipo: " + Cliente.class.getName()));
        Cartao cartao = new Cartao();
        cartao.setCliente(cliente);
        cartao.setCvv(codificaBase64Encoder(dto.getCvv()));
        cartao.setNumero(codificaBase64Encoder(dto.getNumero()));
        cartao.setTitular(dto.getTitular());
        cartao.setDataVencimento(dto.getDataVencimento());
        cartao.setUltimosQuatroDigitos(dto.getNumero().substring(12));

        cartaoRepository.save(cartao);

        return cartaoRepository.findAllByClienteId(idCliente).stream().map(x -> new CartaoGetDTO(x)).collect(Collectors.toList());

    }

    public List<CartaoGetDTO> updateCartao(CartaoDTO dto, Integer idCliente, Integer idCartao) {
        if(!isLogado(idCliente)){
            throw new RuntimeException("Acesso negado. Login necessário");
        }

        Cartao cartao = cartaoRepository.findByIdAndClienteId(idCartao, idCliente);
        cartao.setNumero(codificaBase64Encoder(dto.getNumero()));
        cartao.setCvv(codificaBase64Encoder(dto.getCvv()));
        cartao.setTitular(dto.getTitular());
        cartao.setUltimosQuatroDigitos(dto.getNumero().substring(12));
        cartao.setDataVencimento(dto.getDataVencimento());

        cartaoRepository.save(cartao);
        return cartaoRepository.findAllByClienteId(idCliente).stream().map(x -> new CartaoGetDTO(x)).collect(Collectors.toList());

    }

    public List<CartaoGetDTO> getCartoes(Integer idCliente) {
        if(!isLogado(idCliente)){
            throw new RuntimeException("Acesso negado. Login necessário");
        }

        return cartaoRepository.findAllByClienteId(idCliente).stream().map(x -> new CartaoGetDTO(x)).collect(Collectors.toList());
    }

    public boolean deleteCartao(Integer idCliente, Integer idCartao) {
        if(!isLogado(idCliente)){
            throw new RuntimeException("Acesso negado. Login necessário");
        }

        enderecoRepository.deleteByIdAndClienteId(idCartao, idCliente);

        Cartao c = cartaoRepository.findById(idCartao).orElse(null);

        return c == null;
    }



    public ClienteDTO login(ClienteLoginDTO loginDTO) {
        Cliente cli = repo.findByEmail(loginDTO.getEmail());

        if(cli != null){
           // BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            boolean isPasswordMatches = loginDTO.getSenha().matches(decodificaBase64Decoder(cli.getSenha()));

            if(isPasswordMatches){
                cli.setLogado(true);
                update(cli);
                return new ClienteDTO(cli);
            }
        }
        return null;
    }

    public boolean logoff(ClienteDTO logoffDTO) {

        Cliente cli = repo.findByEmail(logoffDTO.getEmail());
        cli.setLogado(false);
        update(cli);
        return true;

    }


    private boolean isLogado(Integer id){
        Cliente cli = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));

        return cli.isLogado();

    }

    public ClienteParaUpdateDTO findCliente(Integer id) {
        return repo.findById(id).map(x -> new ClienteParaUpdateDTO(x)).orElse(null);
    }
}
