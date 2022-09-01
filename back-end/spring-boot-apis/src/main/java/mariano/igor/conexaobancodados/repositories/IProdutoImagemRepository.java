package mariano.igor.conexaobancodados.repositories;

import mariano.igor.conexaobancodados.models.ProdutoImagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoImagemRepository extends JpaRepository<ProdutoImagemModel,Long> {
}
