package clover.mlclover.repositories;

import clover.mlclover.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    //Deixar mais rápido e diminui o locking no gerenciamento de transações do Banco de Dados
    @Transactional
    Cliente findByEmail(String email);
}
