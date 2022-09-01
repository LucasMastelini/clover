package mariano.igor.conexaobancodados.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "StatusPedido")
public class StatusPedidoModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 100)
    private String situacao;
    private Date dataAtualizacao;
    @ManyToOne
    @JoinColumn(name = "id_pedidos", nullable = false)
    @Valid
    private PedidosModel pedidos;


}
