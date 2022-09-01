package mariano.igor.conexaobancodados.controllers;

import mariano.igor.conexaobancodados.dtos.UsuarioDto;
import mariano.igor.conexaobancodados.models.UsuarioModel;
import mariano.igor.conexaobancodados.services.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/cadastro-usuario")
    public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody @Valid UsuarioDto usuarioDto){

        usuarioService.cadastrarUsuario(usuarioDto);
        return new ResponseEntity<>(usuarioDto, HttpStatus.CREATED);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioModel>> getListaUsuarios(){
        return new ResponseEntity<>(usuarioService.getListaUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<UsuarioModel> getPorId(@PathVariable long id){
        Optional<UsuarioModel> usuario = usuarioService.getPorId(id);
        if(usuario.isPresent()){
            return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
