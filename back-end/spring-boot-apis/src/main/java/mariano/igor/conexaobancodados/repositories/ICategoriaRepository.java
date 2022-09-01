package mariano.igor.conexaobancodados.repositories;

import mariano.igor.conexaobancodados.models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<CategoriaModel,Long> {
}
