package mariano.igor.conexaobancodados.repositories;

import mariano.igor.conexaobancodados.models.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContaRepository extends JpaRepository<ContaModel,Long> {
}
