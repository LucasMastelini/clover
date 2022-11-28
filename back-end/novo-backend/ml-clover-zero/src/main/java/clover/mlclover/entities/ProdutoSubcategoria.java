package clover.mlclover.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProdutoSubcategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Subcategoria subcategoria;

    public ProdutoSubcategoria(Produto produto, Subcategoria subcategoria){
        this.produto = produto;
        this.subcategoria  = subcategoria;
    }
}
