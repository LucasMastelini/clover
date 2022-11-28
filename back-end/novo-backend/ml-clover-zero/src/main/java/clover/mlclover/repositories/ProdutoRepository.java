package clover.mlclover.repositories;

import clover.mlclover.entities.Categoria;
import clover.mlclover.entities.Produto;
import clover.mlclover.entities.Subcategoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {


//    @Query("SELECT p from Produto p WHERE p.nome LIKE %:name% ORDER BY p.nome")
    List<Produto> findByNomeContainingIgnoreCaseOrderByNomeAsc(String nome);

    @Transactional
    Page<Produto> findDistinctByNomeContainingIgnoreCaseOrProdutoCategoriasCategoriaInOrProdutoSubcategoriasSubcategoriaIn(String nome, List<Categoria> categorias, List<Subcategoria> subcategorias, Pageable pageRequest);
}
