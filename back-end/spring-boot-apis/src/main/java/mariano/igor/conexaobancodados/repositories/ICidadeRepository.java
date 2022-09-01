package mariano.igor.conexaobancodados.repositories;


import mariano.igor.conexaobancodados.models.CidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICidadeRepository extends JpaRepository<CidadeModel,Long> {
}
