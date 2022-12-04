package clover.mlclover.repositories;

import clover.mlclover.entities.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CartaoRepository  extends JpaRepository<Cartao, Integer> {

    List<Cartao> findAllByClienteId(Integer clienteId);

    Cartao findByIdAndClienteId(Integer idCartao, Integer idCliente);

    @Transactional
    @Modifying
    void deleteByIdAndClienteId(Integer idCartao, Integer idCliente);

}
