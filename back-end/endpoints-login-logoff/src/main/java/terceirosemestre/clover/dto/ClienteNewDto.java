package terceirosemestre.clover.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import terceirosemestre.clover.services.validation.ClienteInsert;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ClienteInsert
public class ClienteNewDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Size(min = 5, max= 120, message = "O tamanho deve ser entre {min} e {max} caracteres.")
    private String nome;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "E-mail inválido")
    private String email;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String cpfOuCnpj;
    private Integer tipo;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String logradouro;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String numero;
    private String complemento;
    private String bairro;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String cep;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String telefone1;
    private String telefone2;
    private String telefone3;

    private Integer cidadeId;

}
