package mariano.igor.conexaobancodados.repositories;

import mariano.igor.conexaobancodados.models.CardPaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICardPaymentRepository extends JpaRepository<CardPaymentModel, Long> {
}
