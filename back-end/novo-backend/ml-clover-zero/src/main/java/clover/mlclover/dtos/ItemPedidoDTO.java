package clover.mlclover.dtos;

import clover.mlclover.entities.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {

    private ProdutoDTO produto;
    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemPedidoDTO(ItemPedido obj){
        this.produto = new ProdutoDTO(obj.getProduto());
        this.desconto = obj.getDesconto();
        this.quantidade = obj.getQuantidade();
        this.preco = obj.getPreco();
    }

    public double getSubTotal(){
        return (preco - desconto) * quantidade;
    }
}
