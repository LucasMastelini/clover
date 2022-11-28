package clover.mlclover.services;

import clover.mlclover.dtos.CategoriaGetDTO;
import clover.mlclover.dtos.ProdutoGetDTO;
import clover.mlclover.entities.Categoria;
import clover.mlclover.entities.Produto;
import clover.mlclover.entities.Subcategoria;
import clover.mlclover.repositories.CategoriaRepository;
import clover.mlclover.repositories.ProdutoRepository;
import clover.mlclover.repositories.SubcategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    SubcategoriaRepository subcategoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public List<CategoriaGetDTO> listaCategoriasAndSubcategorias() {
       List<Categoria> categorias = categoriaRepository.findAll();
       List<CategoriaGetDTO> lista = new ArrayList<>();
       for(Categoria c : categorias){
           lista.add(new CategoriaGetDTO(c));
       }
       return lista;
    }

    public List<ProdutoGetDTO> listaProdutosSearch(String search) {
        List<Produto> produtos = produtoRepository.findByNomeContainingIgnoreCaseOrderByNomeAsc(search);
        if(produtos.isEmpty()){
            produtos = produtoRepository.findAll();
        }
        List<ProdutoGetDTO> lista = new ArrayList<>();
        for(Produto p : produtos){
            lista.add(new ProdutoGetDTO(p));
        }
        return lista;

    }

    public Page listaProdutosPaginados(String produto, List<Integer> idsCategoria, List<Integer> idsSubcategoria, int pagina, int linhasPorPagina, String orderBy, String direcao) {
        Pageable paginacao = PageRequest.of(pagina, linhasPorPagina, Sort.Direction.valueOf(direcao), orderBy);
        List<Categoria> categorias = categoriaRepository.findAllById(idsCategoria);
        List<Subcategoria> subcategorias = subcategoriaRepository.findAllById(idsSubcategoria);
        if(produto.length() == 0){
            produto = "zzz";
        }



        Page<Produto> produtos = produtoRepository.findDistinctByNomeContainingIgnoreCaseOrProdutoCategoriasCategoriaInOrProdutoSubcategoriasSubcategoriaIn(produto, categorias, subcategorias, paginacao);
        return ProdutoGetDTO.conversor(produtos);
    }
}
