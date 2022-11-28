package clover.mlclover.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProdutoCor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "cor_id")
    private Cor cor;

    @OneToMany(mappedBy = "produtoCor")
    private List<Imagem> imagens = new ArrayList<>();

    public ProdutoCor(Produto produto, Cor cor){
        this.produto = produto;
        this.cor = cor;
    }
}
