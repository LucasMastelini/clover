package clover.mlclover.repositories;

import clover.mlclover.entities.Produto;
import clover.mlclover.entities.ProdutoTamanho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProdutoTamanhoRepository extends JpaRepository<ProdutoTamanho, Integer> {
    @Transactional
    @Modifying
    void deleteByProdutoId(Integer idProduto);

    void deleteByTamanho(String tamanho);

}
