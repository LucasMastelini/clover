package clover.mlclover.services;

import clover.mlclover.dtos.*;
import clover.mlclover.entities.Cliente;
import clover.mlclover.entities.LocalidadeCep;
import clover.mlclover.entities.enums.TipoCliente;
import clover.mlclover.repositories.ClienteRepository;
import clover.mlclover.repositories.EnderecoRepository;
import clover.mlclover.repositories.LocalidadeCepRepository;
import clover.mlclover.services.exceptions.DataIntegrityException;
import clover.mlclover.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

//import com.gtbr.ViaCepClient;
//import com.gtbr.domain.Cep;

import javax.transaction.Transactional;

import java.util.*;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repo;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private LocalidadeCepRepository cepRepository;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));

    }

    @Transactional
    public Cliente cadastroInicial(Cliente obj) {
        obj = repo.save(obj);
        return obj;
    }
    @Transactional
    public Cliente cadastroFinalizacaoCompra(ClienteUpdateFinalizacaoCompraDTO objDto, Integer id) {
       Cliente cliente = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + objDto.getId() + ", Tipo: " + Cliente.class.getName()));

       cliente.setTipo(TipoCliente.toEnum(objDto.getTipo()));
       cliente.setCpfOuCnpj(objDto.getCpfOuCnpj());
       cliente.setGenero(objDto.getGenero());
       cliente.setDataNascimento(objDto.getDataNascimento());
       cliente.setEnderecos(objDto.getEnderecos());
       enderecoRepository.saveAll(objDto.getEnderecos());

       return repo.save(cliente);
    }

    public Cliente update(Cliente obj) {
        Cliente newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
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

    public CepDTO consultaCep(CepConsultaDTO consulta) {
        // Cep endereco = ViaCepClient.findCep(cep);
        LocalidadeCep localidade = cepRepository.findById(consulta.getCep()).orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! CEP: " + consulta + ", Tipo: " + LocalidadeCep.class.getName()));

        return new CepDTO(localidade);
    }

//
//    public ClienteDTO login(ClienteLoginDTO loginDTO) {
//        Cliente cli = repo.findByEmail(loginDTO.getEmail());
//        if(cli != null){
//           // BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
//            boolean isPasswordMatches = loginDTO.getSenha().matches(cli.getSenha());
//
//            if(isPasswordMatches){
//                cli.setLogado(true);
//                update(cli);
//                return new ClienteDTO(cli);
//            }
//        }
//        return null;
//    }
//
//    public boolean logoff(ClienteDTO logoffDTO) {
//        Cliente cli = repo.findByEmail(logoffDTO.getEmail());
//        if(cli != null && cli.isLogado()){
//            cli.setLogado(false);
//            update(cli);
//            return true;
//        }
//        return false;
//    }

}
