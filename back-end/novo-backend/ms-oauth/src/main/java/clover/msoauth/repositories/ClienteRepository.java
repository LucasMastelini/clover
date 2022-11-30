package clover.msoauth.repositories;

import clover.msoauth.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Transactional
    Cliente findByEmail(String email);
}
