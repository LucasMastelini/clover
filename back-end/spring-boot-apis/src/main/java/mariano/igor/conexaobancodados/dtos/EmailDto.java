package mariano.igor.conexaobancodados.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailDto {
// @NotBlack -> O campo não pode ser nulo
// @Email -> Verifica se o e-mail é válido
    @NotBlank
    private String ownerRef;
    @NotBlank
    @Email
    private String emailFrom;
    @NotBlank
    @Email
    private String emailTo;
    @NotBlank
    private String subject;
    @NotBlank
    private String text;

}
