package mariano.igor.conexaobancodados.repositories;

import mariano.igor.conexaobancodados.dtos.SubcategoriaDto;
import mariano.igor.conexaobancodados.models.SubcategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISubcategoriaRepository extends JpaRepository<SubcategoriaModel,Long> {

    List<SubcategoriaModel> findByCategoriaId(long id);
}
