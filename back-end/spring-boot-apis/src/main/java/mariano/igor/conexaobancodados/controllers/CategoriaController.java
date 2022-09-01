package mariano.igor.conexaobancodados.controllers;

import mariano.igor.conexaobancodados.dtos.CategoriaDto;

import mariano.igor.conexaobancodados.dtos.UsuarioDto;
import mariano.igor.conexaobancodados.models.CategoriaModel;
import mariano.igor.conexaobancodados.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaDto>> getListaCategorias(){
        List<CategoriaDto> lista = categoriaService.getListaCategorias();
        return lista.isEmpty() ? new ResponseEntity<>(null, HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(categoriaService.getListaCategorias(), HttpStatus.OK);
    }

    @PostMapping("/cadastro-categoria")
    public ResponseEntity<CategoriaDto> cadastrarCategoria
            (@RequestBody @Valid CategoriaModel categoriaModel){
        CategoriaDto categoriaDto = categoriaService.cadastrarCategoria(categoriaModel);
        return categoriaDto != null ?
                new ResponseEntity<>(categoriaDto, HttpStatus.CREATED)
                    : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("categoria/{id}")
    public ResponseEntity<CategoriaDto> atualizarCategoria(@PathVariable long id, @RequestBody CategoriaModel categoriaModel){
        CategoriaDto categoria = categoriaService.atualizarCategoria(id, categoriaModel);
        return categoria != null ?
                new ResponseEntity<>(categoria, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("categoria/{id}")
    public ResponseEntity<String> deletarCategoria(@PathVariable long id){
       boolean isDeleted = categoriaService.deletarCategoria(id);
        return isDeleted ?
                new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK)
                : new ResponseEntity<>("Não foi possível deletar", HttpStatus.BAD_REQUEST);
    }
}
