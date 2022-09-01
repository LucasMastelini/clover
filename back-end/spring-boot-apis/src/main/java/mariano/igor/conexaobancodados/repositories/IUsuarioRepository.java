package mariano.igor.conexaobancodados.repositories;

import mariano.igor.conexaobancodados.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel,Long> {
}
