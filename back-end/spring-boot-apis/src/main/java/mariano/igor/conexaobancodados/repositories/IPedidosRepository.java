package mariano.igor.conexaobancodados.repositories;

import mariano.igor.conexaobancodados.models.PedidosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidosRepository extends JpaRepository<PedidosModel,Long> {
}
