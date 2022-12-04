package clover.mlclover.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titular;
    private String numero;
    private String ultimosQuatroDigitos;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/yy", locale = "pt-BR", timezone = "UTC")
    private Date dataVencimento;
    private String cvv;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

//    @JsonIgnore
//    @OneToOne
//    @JoinColumn(name = "pagamento_id")
//    private PagamentoComCartao pagamentoComCartao;
}
