package clover.mlclover.repositories;

import clover.mlclover.entities.Subcategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Integer> {

    @Transactional
    @Modifying
    void deleteByCategoriaId(Integer idCategoria);
}
