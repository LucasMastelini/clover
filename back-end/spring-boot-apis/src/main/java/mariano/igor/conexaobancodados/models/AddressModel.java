package mariano.igor.conexaobancodados.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="tb_search_address")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double lat;
    private Double lng;
    private String addressFormated;
}
