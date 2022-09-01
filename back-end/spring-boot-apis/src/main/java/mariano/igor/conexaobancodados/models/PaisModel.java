package mariano.igor.conexaobancodados.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Pais")
public class PaisModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 3)
    private String descricao;
    @OneToMany(mappedBy = "pais", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<EstadoModel> estados;

    public PaisModel(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        estados = new ArrayList<>();
    }
}
