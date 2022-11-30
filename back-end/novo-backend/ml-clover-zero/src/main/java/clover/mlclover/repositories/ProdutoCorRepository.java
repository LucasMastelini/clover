package clover.mlclover.repositories;

import clover.mlclover.entities.Produto;
import clover.mlclover.entities.ProdutoCor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProdutoCorRepository extends JpaRepository<ProdutoCor, Integer> {

    @Transactional
    @Modifying
    void deleteByProdutoId(Integer idProduto);
    void deleteByCor(String hexadecimal);

    ProdutoCor findByProdutoIdAndCorHexadecimal(Integer idProduto, String hexadecimal);

}
