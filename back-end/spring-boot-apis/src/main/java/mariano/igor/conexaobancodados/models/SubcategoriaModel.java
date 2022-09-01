package mariano.igor.conexaobancodados.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "Subcategoria")
public class SubcategoriaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 120)
    private String descricao;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaModel categoria;

    @ManyToMany(mappedBy = "subcategorias")
    private List<ProdutoModel> produtos;

    public SubcategoriaModel(Long id, String descricao, CategoriaModel categoria) {
        this.id = id;
        this.descricao = descricao;
        produtos = new ArrayList<>();
    }
}
