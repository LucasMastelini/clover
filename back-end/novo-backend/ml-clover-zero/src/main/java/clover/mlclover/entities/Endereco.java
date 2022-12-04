package clover.mlclover.entities;

import clover.mlclover.dtos.EnderecoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cep")
    private LocalidadeCep localidadeCep;
    private String numero;
    private String complemento;
    private String destinatario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Endereco(EnderecoDTO obj){
        this.localidadeCep = obj.getLocalidadeCep();
        this.numero = obj.getNumero();
        this.complemento = obj.getComplemento();
        this.destinatario = obj.getDestinatario();
    }
}
