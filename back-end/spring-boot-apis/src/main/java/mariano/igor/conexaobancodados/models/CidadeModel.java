package mariano.igor.conexaobancodados.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Cidade")
public class CidadeModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50)
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    @Valid
    private EstadoModel estado;
    @OneToMany(mappedBy = "cidade", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<EnderecoModel> enderecos;

    public CidadeModel(Long id, String descricao, EstadoModel estado) {
        this.id = id;
        this.descricao = descricao;
        this.estado = estado;
        enderecos = new ArrayList<>();
    }
}
