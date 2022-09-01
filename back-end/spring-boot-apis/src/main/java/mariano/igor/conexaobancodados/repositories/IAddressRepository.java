package mariano.igor.conexaobancodados.repositories;


import mariano.igor.conexaobancodados.models.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<AddressModel, Long> {
}
