package clover.mlclover.dtos;

import clover.mlclover.entities.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {


    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instante;
    private Pagamento pagamento;
    private ClienteDTO cliente;
    private EnderecoDTO enderecoEntrega;
    private Set<ItemPedidoDTO> itens = new HashSet<>();

    public PedidoDTO(Pedido obj){
        this.id = obj.getId();
        this.instante = obj.getInstante();
        this.pagamento = obj.getPagamento();
        this.cliente = new ClienteDTO(obj.getCliente());
        this.enderecoEntrega = new EnderecoDTO(obj.getEnderecoEntrega());
        Set<ItemPedidoDTO> lista = new HashSet<>();
        for(ItemPedido ip : obj.getItens()){
            lista.add(new ItemPedidoDTO(ip));
        }
        this.itens = lista;
    }


    public double getValorTotal(){
        double soma = 0.0;
        for(ItemPedidoDTO ip : itens){
            soma += ip.getSubTotal();
        }
        return soma;
    }


}
