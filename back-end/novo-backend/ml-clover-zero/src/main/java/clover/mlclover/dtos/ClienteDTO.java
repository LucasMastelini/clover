package clover.mlclover.dtos;

import clover.mlclover.entities.Cliente;
import clover.mlclover.entities.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Integer id;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Size(min = 5, max= 120, message = "O tamanho deve ser entre {min} e {max} caracteres.")
    private String nome;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "E-mail inválido")
    private String email;
    private boolean isLogado;

    private List<Integer> perfis = new ArrayList<>();

    private boolean isLogado;

    public ClienteDTO(Cliente obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        // Se o perfil == 1 => ADMIN
        // Se o perfil == 2 => CLIENTE
        this.perfis = obj.getPerfis().stream().map(x -> x.getCod()).collect(Collectors.toList());
        this.isLogado = obj.isLogado();
    }
}
