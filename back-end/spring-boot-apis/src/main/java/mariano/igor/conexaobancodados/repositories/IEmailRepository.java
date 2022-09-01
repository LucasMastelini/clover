package mariano.igor.conexaobancodados.repositories;

import mariano.igor.conexaobancodados.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmailRepository extends JpaRepository<EmailModel, Long> {


}
