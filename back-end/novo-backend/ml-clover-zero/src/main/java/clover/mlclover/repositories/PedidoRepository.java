package clover.mlclover.repositories;

import clover.mlclover.entities.Cliente;
import clover.mlclover.entities.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.awt.print.Pageable;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

//    Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);
}
