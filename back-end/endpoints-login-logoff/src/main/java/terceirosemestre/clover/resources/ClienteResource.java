package terceirosemestre.clover.resources;


import com.gtbr.ViaCepClient;
import com.gtbr.domain.Cep;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import terceirosemestre.clover.domain.Cliente;
import terceirosemestre.clover.dto.*;
import terceirosemestre.clover.services.ClienteService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> find(@PathVariable Integer id){

        Cliente obj = service.find(id);
        return ResponseEntity.status(200).body(obj);
    }


    @RequestMapping(value="/clientes/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDto, @PathVariable Integer id){
        Cliente obj = service.fromDTO(objDto);
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

    @RequestMapping(value = "/clientes", method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDto objDto){
        Cliente obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/clientes/cadastro", method=RequestMethod.POST)
    public ResponseEntity<Void> cadastro(@Valid @RequestBody ClienteSenhaDTO clienteSenhaDTO){
        Cliente obj = service.fromSenhaDTO(clienteSenhaDTO);
        obj = service.cadastro(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/clientes/cep",method = RequestMethod.GET)
    public ResponseEntity<CepDTO> consultaCep(@RequestBody CepNewDto nroCep){

     CepDTO cep = service.consultaCep(nroCep);
        return cep != null ? ResponseEntity.status(200).body(cep) : ResponseEntity.status(404).build();

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
