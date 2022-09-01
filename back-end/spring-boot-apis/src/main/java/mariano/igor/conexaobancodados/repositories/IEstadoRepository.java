package mariano.igor.conexaobancodados.repositories;

import mariano.igor.conexaobancodados.models.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoRepository extends JpaRepository<EstadoModel,Long> {
}
