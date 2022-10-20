package terceirosemestre.clover.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import terceirosemestre.clover.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
