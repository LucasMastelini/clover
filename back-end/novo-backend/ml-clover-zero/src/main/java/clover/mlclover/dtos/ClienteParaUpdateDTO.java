package clover.mlclover.dtos;

import clover.mlclover.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteParaUpdateDTO {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;

    public ClienteParaUpdateDTO(Cliente obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.telefone = obj.getTelefone();
    }
}
