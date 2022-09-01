package mariano.igor.conexaobancodados.repositories;

import mariano.igor.conexaobancodados.models.PaisModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaisModelRepository extends JpaRepository<PaisModel,Long> {
}
