package clover.mlclover.dtos;

import clover.mlclover.services.validation.ClienteCadastroInicial;
import clover.mlclover.services.validation.Senha;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ClienteCadastroInicial
public class ClienteCadastroInicialDTO {

    // CADASTRO INICIAL DO CLIENTE

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Size(min = 5, max= 120, message = "O tamanho deve ser entre {min} e {max} caracteres.")
    private String nome;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "E-mail inválido")
    private String email;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String telefone;
    @Senha(message = "Senha não atende critérios")
    private String senha;

}
