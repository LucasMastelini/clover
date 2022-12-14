package clover.mlclover.repositories;

import clover.mlclover.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    List<Endereco> findByClienteId(Integer id);

    @Transactional
    @Modifying
    void deleteByIdAndClienteId(Integer idEndereco, Integer idCliente);

    Endereco findByIdAndClienteId(Integer idEndereco, Integer idCliente);
}
