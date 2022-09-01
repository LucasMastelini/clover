package mariano.igor.conexaobancodados.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "Produto")
public class ProdutoModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String sku;
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private Double valor;
    @ManyToMany
    @JoinTable(
            name = "item_pedido",
            joinColumns = @JoinColumn(name = "id_produto"),
            inverseJoinColumns = @JoinColumn(name = "id_carrinho_compras")
    )
    private List<CarrinhoComprasModel> carrinhos;
    @OneToMany(mappedBy = "produto", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<EspecificacaoProdutoModel> especificacoes;
    @OneToMany(mappedBy = "produto", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<ProdutoImagemModel> imagens;
    @ManyToMany
    @JsonBackReference
    @JoinTable(
            name = "produto_subcategoria",
            joinColumns = @JoinColumn(name = "id_produto"),
            inverseJoinColumns = @JoinColumn(name = "id_subcategoria")
    )
    private List<SubcategoriaModel> subcategorias;

    public ProdutoModel(String sku, String nome, String descricao, Double valor) {
        this.sku = sku;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        carrinhos = new ArrayList<>();
        especificacoes = new ArrayList<>();
        imagens = new ArrayList<>();
        subcategorias = new ArrayList<>();
    }
}
