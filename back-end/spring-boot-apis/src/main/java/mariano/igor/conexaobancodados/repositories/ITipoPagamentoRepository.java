package mariano.igor.conexaobancodados.repositories;

import mariano.igor.conexaobancodados.models.TipoPagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoPagamentoRepository extends JpaRepository<TipoPagamentoModel,Long> {
}
