package mariano.igor.conexaobancodados.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Cor")
public class CorModel {
    @Id
    private String codigoCor;
    private String nome;
}
