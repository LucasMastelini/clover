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
@AllArgsConstructor
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
    private List<CarrinhoComprasModel> carrinhos = new ArrayList<>();
    @OneToMany(mappedBy = "produto", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<EspecificacaoProdutoModel> especificacoes= new ArrayList<>();
    @OneToMany(mappedBy = "produto", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<ProdutoImagemModel> imagens = new ArrayList<>();
    @OneToMany(mappedBy = "produto", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<CorModel> cores = new ArrayList<>();
    @OneToMany(mappedBy = "produto", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<TamanhoModel> tamanhos = new ArrayList<>();
    @ManyToMany
    @JsonBackReference
    @JoinTable(
            name = "produto_subcategoria",
            joinColumns = @JoinColumn(name = "id_produto"),
            inverseJoinColumns = @JoinColumn(name = "id_subcategoria")
    )
    private List<SubcategoriaModel> subcategorias = new ArrayList<>();


}
