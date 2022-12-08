package clover.mlclover.controllers;


import clover.mlclover.dtos.*;
import clover.mlclover.entities.Cliente;
import clover.mlclover.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @RequestMapping(value = "/clientes-cadastro/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClienteParaUpdateDTO> findCliente(@PathVariable Integer id){
        ClienteParaUpdateDTO obj = service.findCliente(id);
        return obj != null ? ResponseEntity.status(200).body(obj) : ResponseEntity.status(404).build();
    }

    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClienteCompletoDTO> find(@PathVariable Integer id){

        ClienteCompletoDTO obj = service.findDTO(id);
        return ResponseEntity.status(200).body(obj);
    }

    

    @RequestMapping(value="/clientes/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDto, @PathVariable Integer id){
        Cliente obj = new Cliente(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.status(204).build();
    }

    @RequestMapping(value="/clientes/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.status(204).build();
    }

    @RequestMapping(value = "/clientes", method=RequestMethod.GET)
    public ResponseEntity<List<ClienteDTO>> findAll(){

        List<Cliente> list = service.findAll();
        List<ClienteDTO> listDto =
                list.stream()
                        .map(obj -> new ClienteDTO(obj))
                        .collect(Collectors.toList());
        return ResponseEntity.status(200).body(listDto);
    }

    @RequestMapping(value="/clientes/page", method=RequestMethod.GET)
    public ResponseEntity<Page<ClienteDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction){

        Page<Cliente> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<ClienteDTO> listDto = list.map(obj -> new ClienteDTO(obj));
        return ResponseEntity.status(200).body(listDto);
    }


    @RequestMapping(value = "/clientes/payment-info/{id}", method =RequestMethod.PUT)
    public ResponseEntity<ClienteCompletoDTO> cadastroFinalizacaoCompra(@Valid @RequestBody ClienteUpdateFinalizacaoCompraDTO objDto, @PathVariable Integer id){
        ClienteCompletoDTO cliente = service.cadastroFinalizacaoCompra(objDto, id);

        return ResponseEntity.status(201).body(cliente);

//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
//                path("/{id}").buildAndExpand(cliente.getId()).toUri();
//
//        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/clientes/cadastro", method=RequestMethod.POST)
    public ResponseEntity<Void> cadastroInicial(@Valid @RequestBody ClienteCadastroInicialDTO dto){
        Cliente obj = new Cliente(dto);
        obj = service.cadastroInicial(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    // ENDERECOS

    @RequestMapping(value = "/clientes/cep/{cep}",method = RequestMethod.POST)
    public ResponseEntity<CepDTO> consultaCep(@PathVariable String cep){

     CepDTO endereco = service.consultaCep(cep);
        return endereco != null ? ResponseEntity.status(200).body(endereco) : ResponseEntity.status(404).build();

    }

    @RequestMapping(value = "/clientes/{idCliente}/enderecos", method = RequestMethod.GET)
    public ResponseEntity<List<EnderecoDTO>> getEnderecos(@PathVariable Integer idCliente){
        List<EnderecoDTO> lista = service.getEnderecos(idCliente);

        return !lista.isEmpty() ? ResponseEntity.status(200).body(lista) : ResponseEntity.status(204).build();
    }


    @RequestMapping(value = "/clientes/{idCliente}/enderecos", method = RequestMethod.POST)
    public ResponseEntity<List<EnderecoDTO>> cadastroEndereco(@PathVariable Integer idCliente , @RequestBody EnderecoListaDTO enderecos){
        List<EnderecoDTO> lista = service.cadastroEndereco(idCliente, enderecos);

        return !lista.isEmpty() ? ResponseEntity.status(201).body(lista) : ResponseEntity.status(400).build();
    }


    @RequestMapping(value = "/clientes/{idCliente}/enderecos/{idEndereco}", method = RequestMethod.PUT)
    public ResponseEntity<List<EnderecoDTO>> updateEndereco(@PathVariable Integer idCliente,
                                                            @PathVariable Integer idEndereco,
                                                            @RequestBody EnderecoDTO endereco){
        List<EnderecoDTO> lista = service.updateEndereco(idCliente, idEndereco, endereco);
        return !lista.isEmpty() ? ResponseEntity.status(200).body(lista) : ResponseEntity.status(204).build();
    }

    @RequestMapping(value = "/clientes/{idCliente}/enderecos/{idEndereco}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEndereco(@PathVariable Integer idCliente,
                                               @PathVariable Integer idEndereco){

        boolean isDeleted = service.deleteEndereco(idCliente, idEndereco);

        return isDeleted ? ResponseEntity.status(204).build() : ResponseEntity.status(400).build();

    }

    // CARTÕES
    @RequestMapping(value = "/clientes/{idCliente}/cartoes", method = RequestMethod.POST)
    public ResponseEntity<List<CartaoGetDTO>> cadastroCartao(@Valid @RequestBody CartaoDTO dto, @PathVariable Integer idCliente){

        List<CartaoGetDTO> lista = service.cadastroCartao(dto, idCliente);

        return !lista.isEmpty() ? ResponseEntity.status(201).body(lista) : ResponseEntity.status(400).build();
    }

    @RequestMapping(value = "/clientes/{idCliente}/cartoes/{idCartao}", method = RequestMethod.PUT)
    public ResponseEntity<List<CartaoGetDTO>> updateCartao(@Valid @RequestBody CartaoDTO dto,
                                                              @PathVariable Integer idCliente,
                                                              @PathVariable Integer idCartao){
        List<CartaoGetDTO> lista = service.updateCartao(dto, idCliente, idCartao);

        return !lista.isEmpty() ? ResponseEntity.status(200).body(lista) : ResponseEntity.status(204).build();
    }

    @RequestMapping(value = "/clientes/{idCliente}/cartoes", method = RequestMethod.GET)
    public ResponseEntity<List<CartaoGetDTO>> getCartoes(@PathVariable Integer idCliente){
        List<CartaoGetDTO> lista = service.getCartoes(idCliente);
        return !lista.isEmpty() ? ResponseEntity.status(200).body(lista) : ResponseEntity.status(204).build();
    }

    @RequestMapping(value = "/clientes/{idCliente}/cartoes/{idCartao}", method = RequestMethod.DELETE)
    public ResponseEntity<List<CartaoGetDTO>> updateCartao(@PathVariable Integer idCliente,
                                                           @PathVariable Integer idCartao){
        boolean isDeleted = service.deleteCartao(idCliente, idCartao);

        return isDeleted ? ResponseEntity.status(204).build() : ResponseEntity.status(400).build();
    }







    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<ClienteDTO> login(@RequestBody ClienteLoginDTO loginDTO){
        ClienteDTO cli =  service.login(loginDTO);

        return cli != null ? ResponseEntity.status(200).body(cli) : ResponseEntity.status(403).build();
    }

    @RequestMapping(value = "/logoff", method = RequestMethod.POST)
    public ResponseEntity<Void> logoff(@RequestBody ClienteDTO logoffDTO){
        boolean validacao = service.logoff(logoffDTO);
        return validacao ? ResponseEntity.status(200).build() : ResponseEntity.status(400).build();
    }
}
