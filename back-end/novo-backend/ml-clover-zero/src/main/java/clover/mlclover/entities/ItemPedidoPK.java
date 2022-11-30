package clover.mlclover.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class ItemPedidoPK implements Serializable {
    private static final long serialVersionUID = 1L;
    /*
    a classe de associação não tem um ID próprio. Quem identifica ela são os dois objetos
    associados a ela. No caso, Produto e Pedido.
    Para isso é necessário criar uma chave composta contendo o Produto e o Pedido

    Algumas exigências para essa classe:
    1- Precisa implementar o Serializable
    2- Getter e Setter
    3- HashCode And Equals
    4- Não precisa de construtor

    Além disso, quando você faz uma entidade do JPA ter como atributo (id) uma outra classe, precisamos colocar
    o @Embeddable pra dizer que ela vai ser um subtipo
    */

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
}
