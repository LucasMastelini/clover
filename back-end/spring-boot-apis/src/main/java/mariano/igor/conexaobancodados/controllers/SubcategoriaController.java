package mariano.igor.conexaobancodados.controllers;

import mariano.igor.conexaobancodados.dtos.CategoriaDto;
import mariano.igor.conexaobancodados.dtos.SubcategoriaDto;
import mariano.igor.conexaobancodados.models.CategoriaModel;
import mariano.igor.conexaobancodados.models.SubcategoriaModel;
import mariano.igor.conexaobancodados.services.SubcategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SubcategoriaController {

    @Autowired
    SubcategoriaService subcategoriaService;


    @PostMapping("/cadastro-subcategoria")
    public ResponseEntity<SubcategoriaDto> cadastroSubcategoria(@RequestBody @Valid SubcategoriaModel subcategoriaModel){
        SubcategoriaDto subcategoriaDto = subcategoriaService.cadastroSubcategoria(subcategoriaModel);
        return subcategoriaDto != null ?
                new ResponseEntity<>(subcategoriaDto, HttpStatus.CREATED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}/subcategorias")
    public ResponseEntity<List<SubcategoriaDto>> getListaSubcategoriasPorCategoria(@PathVariable long id){
        List<SubcategoriaDto> lista = subcategoriaService.getListaSubcategoriasPorCategoria(id);
        return lista.isEmpty() ? new ResponseEntity<>(null, HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PutMapping("subcategoria/{id}")
    public ResponseEntity<SubcategoriaDto> atualizarSubcategoria(@PathVariable long id, @RequestBody SubcategoriaModel subcategoriaModel){
        SubcategoriaDto subcategoria = subcategoriaService.atualizarSubcategoria(id, subcategoriaModel);
        return subcategoria != null ?
                new ResponseEntity<>(subcategoria, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("subcategoria/{id}")
    public ResponseEntity<String> deletarSubcategoria(@PathVariable long id){
        boolean isDeleted = subcategoriaService.deletarSubcategoria(id);
        return isDeleted ?
                new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK)
                : new ResponseEntity<>("Não foi possível deletar", HttpStatus.BAD_REQUEST);
    }

}
