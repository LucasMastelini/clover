package mariano.igor.conexaobancodados.dtos;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@Getter
public class UsuarioDto {

    @NotBlank
    private String nome;
    @NotBlank
//    @Max(1)
    private String sexo;
    @NotBlank
    private String cpf;
    @NotBlank
    private String telefone;
    @NotBlank
    private String celular;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String senha;
}
