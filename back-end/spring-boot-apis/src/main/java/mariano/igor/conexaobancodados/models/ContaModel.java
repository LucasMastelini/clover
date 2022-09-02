package mariano.igor.conexaobancodados.models;

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
@Table(name = "Conta")
public class ContaModel implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 15)
    private String tipoConta;
    @Column(length = 15)
    private String agencia;
    @Column(length = 10)
    private String conta;
    @Column(length = 60)
    private String responsavel;
    @OneToMany(mappedBy = "conta", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<TipoPagamentoModel> tiposPagamento = new ArrayList<>();

}
