package clover.mlclover.repositories;

import clover.mlclover.entities.Produto;
import clover.mlclover.entities.ProdutoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProdutoCategoriaRepository extends JpaRepository<ProdutoCategoria, Integer> {

    @Transactional
    @Modifying
    void deleteByProdutoId(Integer idProduto);

    @Transactional
    @Modifying
    void deleteByCategoriaId(Integer idCategoria);

}
