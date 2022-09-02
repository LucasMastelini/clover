package mariano.igor.conexaobancodados.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Tamanho")
public class TamanhoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String numeracao;
    @Column
    private int qtdTamnaho;
    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    @Valid
    private ProdutoModel produto;
}
