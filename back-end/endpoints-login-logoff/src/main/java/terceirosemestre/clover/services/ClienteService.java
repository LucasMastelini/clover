package terceirosemestre.clover.services;

import com.gtbr.ViaCepClient;
import com.gtbr.domain.Cep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import terceirosemestre.clover.domain.Cidade;
import terceirosemestre.clover.domain.Cliente;
import terceirosemestre.clover.domain.Endereco;
import terceirosemestre.clover.domain.enums.TipoCliente;
import terceirosemestre.clover.dto.*;
import terceirosemestre.clover.repositories.ClienteRepository;
import terceirosemestre.clover.repositories.EnderecoRepository;
import terceirosemestre.clover.services.exceptions.DataIntegrityException;
import terceirosemestre.clover.services.exceptions.ObjectNotFoundException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repo;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));

    }

    @Transactional
    public Cliente insert(Cliente obj) {
        obj.setId(null);
        obj = repo.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());
        return obj;
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

    public Cliente fromDTO(ClienteDTO objDto){
        return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null, null);
    }

    public Cliente fromDTO(ClienteNewDto objDto){
        Cliente cli = new Cliente(null , objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()), null);
        Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
        Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(),objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
        cli.getEnderecos().add(end);
        cli.getTelefones().add(objDto.getTelefone1());
        if(objDto.getTelefone2()!=null){
            cli.getTelefones().add(objDto.getTelefone2());
        }
        if(objDto.getTelefone3()!=null){
            cli.getTelefones().add(objDto.getTelefone3());
        }
        return cli;
    }

    private void updateData(Cliente newObj, Cliente obj){
        newObj.setEmail(obj.getEmail());
        newObj.setNome(obj.getNome());
    }

    public CepDTO consultaCep(CepNewDto nroCep) {
        Cep cep = ViaCepClient.findCep(nroCep.getCep());
        CepDTO cepDto = new CepDTO(cep);
        return cepDto;
    }

    public Cliente fromSenhaDTO(ClienteSenhaDTO objDto) {
        Cliente cli = new Cliente(
                null,
                objDto.getNome(),
                objDto.getEmail(),
                null,
                null,
                objDto.getSenha());
        return cli;
    }

    @Transactional
    public Cliente cadastro(Cliente obj) {
        obj = repo.save(obj);
        return obj;
    }

    public ClienteDTO login(ClienteLoginDTO loginDTO) {
        Cliente cli = repo.findByEmail(loginDTO.getEmail());
        if(cli != null){
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            boolean isPasswordMatches = bcrypt.matches(loginDTO.getSenha(), cli.getSenha());

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
        if(cli != null && cli.isLogado()){
            cli.setLogado(false);
            update(cli);
            return true;
        }
        return false;
    }
}
