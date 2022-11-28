package clover.mlclover.repositories;

import clover.mlclover.entities.Cor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorRepository extends JpaRepository<Cor, String> {
}
