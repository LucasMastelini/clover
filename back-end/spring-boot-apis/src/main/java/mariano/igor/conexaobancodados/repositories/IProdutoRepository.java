package mariano.igor.conexaobancodados.repositories;

import mariano.igor.conexaobancodados.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoRepository extends JpaRepository<ProdutoModel,Long> {
}
