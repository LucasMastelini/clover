package clover.mlclover.controllers;

import clover.mlclover.dtos.*;
import clover.mlclover.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService service;

    // PRODUTOS

    @PostMapping("/produtos")
    public ResponseEntity<Void> cadastroProduto(@Valid @RequestBody ProdutoPostDTO obj){
        service.cadastroProduto(obj);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoDTO>> listaProdutos(){
        List<ProdutoDTO> produtos = service.listaProdutos();

        return produtos.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(produtos);
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Integer id){
        service.deleteProduto(id);
        return ResponseEntity.status(204).build();
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Void> updateProduto(@PathVariable Integer id, @RequestBody ProdutoPostDTO obj){
        service.updateProduto(id, obj);
        return ResponseEntity.status(204).build();

    }

    // CATEGORIAS

    @PostMapping("/categorias")
    public ResponseEntity<Void> cadastroCategoria(@RequestBody CategoriaPostDTO obj){
        service.cadastroCategoria(obj);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaDTO>> listaCategorias(){
        List<CategoriaDTO> categorias = service.listaCategorias();
        return categorias.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(categorias);
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Integer id){
        service.deleteCategoria(id);
        return ResponseEntity.status(204).build();
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<Void> updateCategoria(@PathVariable Integer id, @RequestBody CategoriaPostDTO obj){
        service.updateCategoria(id, obj);
        return ResponseEntity.status(204).build();
    }

    // SUBCATEGORIAS

    @PostMapping("/subcategorias")
    public ResponseEntity<Void> cadastroSubcategoria(@RequestBody SubcategoriaPostDTO obj){
        service.cadastroSubcategoria(obj);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/subcategorias")
    public ResponseEntity<List<SubcategoriaDTO>> listaSubcategorias(){
        List<SubcategoriaDTO> subcategorias = service.listaSubcategorias();
        return subcategorias.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(subcategorias);
    }


    // ARQUIVOS

    @GetMapping("/gravar-arquivo-csv")
    public ResponseEntity<Void> gravarArquivoCsv() {
        return service.gerarArquivoCsv() ? ResponseEntity.status(200).build() : ResponseEntity.status(400).build();
    }

    @GetMapping("/gravar-arquivo-txt")
    public ResponseEntity<Void> gravarArquivoTxt() {
        return service.gravarArquivoTxt() ? ResponseEntity.status(200).build() : ResponseEntity.status(400).build();
    }
}