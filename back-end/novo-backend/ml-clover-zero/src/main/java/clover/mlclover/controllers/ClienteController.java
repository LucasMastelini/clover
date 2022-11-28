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

    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> find(@PathVariable Integer id){

        Cliente obj = service.find(id);
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
    public ResponseEntity<Void> cadastroFinalizacaoCompra(@Valid @RequestBody ClienteUpdateFinalizacaoCompraDTO objDto, @PathVariable Integer id){
        Cliente cliente = service.cadastroFinalizacaoCompra(objDto, id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/clientes/cadastro", method=RequestMethod.POST)
    public ResponseEntity<Void> cadastroInicial(@Valid @RequestBody ClienteCadastroInicialDTO dto){
        Cliente obj = new Cliente(dto);
        obj = service.cadastroInicial(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/clientes/cep",method = RequestMethod.GET)
    public ResponseEntity<CepDTO> consultaCep(@RequestBody CepConsultaDTO consulta){

     CepDTO endereco = service.consultaCep(consulta);
        return endereco != null ? ResponseEntity.status(200).body(endereco) : ResponseEntity.status(404).build();

    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ResponseEntity<ClienteDTO> login(@RequestBody ClienteLoginDTO loginDTO){
//        ClienteDTO cli =  service.login(loginDTO);
//
//        return cli != null ? ResponseEntity.status(200).body(cli) : ResponseEntity.status(403).build();
//    }
//
//    @RequestMapping(value = "/logoff", method = RequestMethod.POST)
//    public ResponseEntity<Void> logoff(@RequestBody ClienteDTO logoffDTO){
//        boolean validacao = service.logoff(logoffDTO);
//        return validacao ? ResponseEntity.status(200).build() : ResponseEntity.status(400).build();
//    }
}
