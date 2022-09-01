package mariano.igor.conexaobancodados.controllers;

import mariano.igor.conexaobancodados.dtos.ProdutoDto;
import mariano.igor.conexaobancodados.dtos.SubcategoriaDto;
import mariano.igor.conexaobancodados.models.ProdutoModel;
import mariano.igor.conexaobancodados.models.SubcategoriaModel;
import mariano.igor.conexaobancodados.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/cadastro-produto")
    public ResponseEntity<ProdutoDto> cadastroProduto(@RequestBody @Valid ProdutoModel produtoModel){
        ProdutoDto produtoDto = produtoService.cadastroProduto(produtoModel);
        return produtoDto != null ?
                new ResponseEntity<>(produtoDto, HttpStatus.CREATED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
