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
@Table(name = "Endereco")
public class EnderecoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rua;
    private String numero;
    private String complemento;
    private String referencia;
    private String bairro;
    private String cep;
    @ManyToOne
    @JoinColumn(name = "id_cidade", nullable = false)
    @Valid
    private CidadeModel cidade;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @Valid
    private UsuarioModel usuario;
}
