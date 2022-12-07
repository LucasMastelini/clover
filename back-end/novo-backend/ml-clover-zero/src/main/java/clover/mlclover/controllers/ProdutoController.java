package clover.mlclover.controllers;

import clover.mlclover.controllers.utils.URL;
import clover.mlclover.dtos.CategoriaGetDTO;
import clover.mlclover.dtos.ProdutoGetDTO;
import clover.mlclover.entities.Produto;
import clover.mlclover.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping
    public ResponseEntity<List<CategoriaGetDTO>> listaCategoriasAndSubcategorias(){
        List<CategoriaGetDTO> lista = service.listaCategoriasAndSubcategorias();

        return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/produtos/{search}")
    public ResponseEntity<List<ProdutoGetDTO>> listaProdutosSearch(@PathVariable String search){
        List<ProdutoGetDTO> lista = service.listaProdutosSearch(search);
        return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lista);
    }


    @GetMapping("/produtos")
    public Page<ProdutoGetDTO> listaProdutos(
            @RequestParam(value="nome", defaultValue="") String produto,
            @RequestParam(value="pagina", defaultValue="0") int pagina,
            @RequestParam(value="categorias", defaultValue="") String categorias,
            @RequestParam(value="subcategorias", defaultValue="") String subcategorias,
            @RequestParam(value="linhasPorPagina", defaultValue="8") int linhasPorPagina,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direcao
    ){
        String produtoDecodificado = URL.decodeParam(produto);

        List<Integer> idsCategoria = new ArrayList<>();
        List<Integer> idsSubcategoria = new ArrayList<>();

        if(categorias.length() > 0){
            idsCategoria = URL.decodeIntList(categorias);
        }
        if(subcategorias.length() > 0){
            idsSubcategoria = URL.decodeIntList(subcategorias);
        }



        return service.listaProdutosPaginados(produto, idsCategoria, idsSubcategoria, pagina, linhasPorPagina, orderBy, direcao);
    }


    @GetMapping("/produtos/novidades")
    public ResponseEntity<List<ProdutoGetDTO>> getUltimasNovidades(){
        List<ProdutoGetDTO> lista = service.getUltimasNovidades();
        return !lista.isEmpty() ? ResponseEntity.status(200).body(lista) : ResponseEntity.status(204).build();
    }



}
