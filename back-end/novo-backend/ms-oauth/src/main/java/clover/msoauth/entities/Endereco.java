package clover.msoauth.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cep")
    private LocalidadeCep localidadeCep;
    private String numero;
    private String complemento;
    private String destinatario;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
