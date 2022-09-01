package mariano.igor.conexaobancodados.repositories;

import mariano.igor.conexaobancodados.models.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnderecoRepository extends JpaRepository<EnderecoModel,Long> {
}
