package mariano.igor.conexaobancodados.repositories;

import mariano.igor.conexaobancodados.models.StatusPedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusPedidoRepository extends JpaRepository<StatusPedidoModel,Long> {
}
