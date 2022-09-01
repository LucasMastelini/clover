package mariano.igor.conexaobancodados.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ProdutoImagem")
public class ProdutoImagemModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 80)
    private String imagem;
    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    @Valid
    private ProdutoModel produto;
}
