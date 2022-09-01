package mariano.igor.conexaobancodados.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pedidos")
public class PedidosModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double valorTotal;
    private Double valorFrete;
    private Date dataPedido;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @Valid
    private UsuarioModel usuario;
    @ManyToOne
    @JoinColumn(name = "id_tipo_pagamento", nullable = false)
    @Valid
    private TipoPagamentoModel tipoPagamento;
    @OneToMany(mappedBy = "pedidos", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<CarrinhoComprasModel> carrinhos = new ArrayList<>();
    @OneToMany(mappedBy = "pedidos", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<StatusPedidoModel> statusPedidos = new ArrayList<>();
}
