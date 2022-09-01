package mariano.igor.conexaobancodados.repositories;

import mariano.igor.conexaobancodados.models.CarrinhoComprasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarrinhoComprasRepository extends JpaRepository<CarrinhoComprasModel,Long> {
}
