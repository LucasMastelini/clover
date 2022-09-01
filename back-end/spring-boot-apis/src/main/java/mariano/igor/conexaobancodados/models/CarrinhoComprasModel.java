package mariano.igor.conexaobancodados.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CarrinhoCompras")
public class CarrinhoComprasModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double valor;
    private Integer quantidade;
    @ManyToMany(mappedBy = "carrinhos")
    private List<ProdutoModel> produtos;
    @Valid
    @ManyToOne
    @JoinColumn(name = "id_pedidos", nullable = false)
    private PedidosModel pedidos;


}
