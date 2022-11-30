package clover.mlclover.repositories;

import clover.mlclover.entities.LocalidadeCep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadeCepRepository extends JpaRepository<LocalidadeCep, String> {
}
