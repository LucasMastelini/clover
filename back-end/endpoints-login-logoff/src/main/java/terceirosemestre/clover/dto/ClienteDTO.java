package terceirosemestre.clover.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import terceirosemestre.clover.domain.Cliente;
import terceirosemestre.clover.services.validation.ClienteUpdate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ClienteUpdate
public class ClienteDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Size(min = 5, max= 120, message = "O tamanho deve ser entre {min} e {max} caracteres.")
    private String nome;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    public ClienteDTO(Cliente obj){
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }
}
