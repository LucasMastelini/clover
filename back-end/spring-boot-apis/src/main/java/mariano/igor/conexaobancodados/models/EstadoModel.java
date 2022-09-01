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
@Table(name = "Estado")
public class EstadoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 2)
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "id_pais", nullable = false)
    @Valid
    private PaisModel pais;
    @OneToMany(mappedBy = "estado", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<CidadeModel> cidades;

    public EstadoModel(Long id, String descricao, PaisModel pais) {
        this.id = id;
        this.descricao = descricao;
        this.pais = pais;
        cidades = new ArrayList<CidadeModel>();

    }


}
