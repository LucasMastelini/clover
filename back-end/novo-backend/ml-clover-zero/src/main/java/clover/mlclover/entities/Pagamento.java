package clover.mlclover.entities;

import clover.mlclover.entities.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type") // a minha classe pagamento terá um campo adicional que se chama @type
@Inheritance(strategy = InheritanceType.JOINED) //mapeamento de herança
public abstract class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private Integer estado;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId // garante que o ID do pagamento seja o mesmo do ID do pedido
    private Pedido pedido;

    public Pagamento(Integer id, EstadoPagamento estadoPagamento, Pedido pedido){
        this.id = id;
        this.estado = estadoPagamento.getCod();
        this.pedido = pedido;
    }

    public EstadoPagamento getEstado(){
        return EstadoPagamento.toEnum(estado);
    }

    public void setEstado(EstadoPagamento estado){
        this.estado = estado.getCod();
    }




}
