package clover.mlclover.services;

import clover.mlclover.domain.Cidade;
import clover.mlclover.domain.Cliente;
import clover.mlclover.domain.Endereco;
import clover.mlclover.domain.enums.TipoCliente;
import clover.mlclover.dto.*;
import clover.mlclover.repositories.ClienteRepository;
import clover.mlclover.repositories.EnderecoRepository;
import clover.mlclover.resources.utils.ListaObj;
import clover.mlclover.services.exceptions.DataIntegrityException;
import clover.mlclover.services.exceptions.ObjectNotFoundException;
import com.gtbr.ViaCepClient;
import com.gtbr.domain.Cep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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
           // BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            boolean isPasswordMatches = loginDTO.getSenha().matches(cli.getSenha());

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

    public List<ClienteGerarArquivoDTO> listaClientesToArquivo() {
       return repo.findAll().stream().map(x -> new ClienteGerarArquivoDTO(x)).collect(Collectors.toList());
    }

    public List<Endereco> listaEnderecoToArquivo(){
        return enderecoRepository.findAll();
    }


    public boolean gerarArquivoCsv() {
        List<ClienteGerarArquivoDTO> lista = listaClientesToArquivo();

        for(int i = 0; i < lista.size() - 1; i++){
            int menIndice = i;
            for(int j = i + 1; j < lista.size(); j++){
                if(lista.get(j).getNome().substring(0,1).toLowerCase().hashCode() < lista.get(menIndice).getNome().substring(0,1).toLowerCase().hashCode()){
                    menIndice = j;
                }
            }
            ClienteGerarArquivoDTO aux = lista.get(i);
            lista.set(i, lista.get(menIndice));
            lista.set(menIndice, aux);
        }

        List<Endereco> listaEnderecos = listaEnderecoToArquivo();

        FileWriter arq = null;
        Formatter saida = null;
        String nomeArq = "arquivo.csv";

        try {
            arq = new FileWriter(nomeArq, StandardCharsets.ISO_8859_1);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            return false;
        }

        try {
            Date data = new Date(System.currentTimeMillis());
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            saida.format("%S;%S;%S;%S;%S\n", "id", "nome", "e-mail", "cpf/cnpj", "tipo");
            int count = 0;
            for (int i = 0; i < lista.size(); i++) {
                ClienteGerarArquivoDTO p = lista.get(i);
                String tipo = p.getTipo() == 1 ? "PESSOA_FISICA" : "PESSOA_JURIDICA";

                saida.format("%d;%S;%s;%s;%S\n", p.getId(), p.getNome(), p.getEmail(), p.getCpfOuCnpj(), tipo);
                count++;
            }
            saida.format("\n%d REGISTROS\n\n\n", count);


            count = 0;
            for (Endereco e : listaEnderecos) {
                if(e.getComplemento() == null){
                    e.setComplemento("N/A");
                }
                saida.format("%d;%S;%S;%S;%S;%S;%S;%S;%S\n", e.getId(), e.getBairro(), e.getCep(), e.getComplemento(), e.getLogradouro(), e.getNumero(), e.getCliente().getNome(), e.getCidade().getNome(), e.getCidade().getEstado().getNome());
                count++;
            }
            saida.format("\n%d REGISTROS\n\n\n", count);
            return true;

        } catch (FormatterClosedException erro) {
            return false;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                return false;
            }
        }

    }

    public boolean gravarArquivoTxt() {
        List<ClienteGerarArquivoDTO> lista = listaClientesToArquivo();
        List<Endereco> listaEnderecos = listaEnderecoToArquivo();
        ListaObj listaObj= new ListaObj(100);
        for(Endereco e : listaEnderecos){
            listaObj.adiciona(e);
        }

        for(int i = 0; i < lista.size() - 1; i++){
            int menIndice = i;
            for(int j = i + 1; j < lista.size(); j++){
                if(lista.get(j).getNome().substring(0,1).toLowerCase().hashCode() < lista.get(menIndice).getNome().substring(0,1).toLowerCase().hashCode()){
                    menIndice = j;
                }
            }
            ClienteGerarArquivoDTO aux = lista.get(i);
            lista.set(i, lista.get(menIndice));
            lista.set(menIndice, aux);
        }

        FileWriter arq = null;
        Formatter saida = null;
        String nomeArq = "arquivo.txt";


        try {
            arq = new FileWriter(nomeArq, StandardCharsets.UTF_8);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        try {
            Date data = new Date(System.currentTimeMillis());
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String dataFormatada = formatador.format(data);

            saida.format("00V1RELATORIOCLIENTES-%s\n", dataFormatada);
            int count = 0;
            for (int i = 0; i < lista.size(); i++) {
                ClienteGerarArquivoDTO p = lista.get(i);
                String tipo = p.getTipo() == 1 ? "PESSOA_FISICA" : "PESSOA_JURIDICA";

                saida.format("02%06d%-40S%-40s%-15s%-15S\n", p.getId(), p.getNome(), p.getEmail(), p.getCpfOuCnpj(), tipo);
                count++;
            }
            saida.format("01%08d\n\n\n", count);

            saida.format("00V1RELATORIOENDERECOSCLIENTES-%s\n", dataFormatada);

            count = 0;
            for (Endereco e : listaEnderecos) {
                if(e.getComplemento() == null){
                    e.setComplemento("N/A");
                }
                saida.format("03%06d%-25S%-10s%-20S%-40S%-8S%-40S%-20S%-5S\n", e.getId(), e.getBairro(), e.getCep(), e.getComplemento(), e.getLogradouro(), e.getNumero(), e.getCliente().getNome(), e.getCidade().getNome(), e.getCidade().getEstado().getNome());
                count++;
            }
            saida.format("01%08d\n\n\n", count);
            return true;

        } catch (FormatterClosedException erro) {
            return false;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                return false;
            }
        }
    }


}
