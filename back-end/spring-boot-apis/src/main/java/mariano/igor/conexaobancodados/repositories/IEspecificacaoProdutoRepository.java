package mariano.igor.conexaobancodados.repositories;

import mariano.igor.conexaobancodados.models.EspecificacaoProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEspecificacaoProdutoRepository extends JpaRepository<EspecificacaoProdutoModel,Long> {
}
