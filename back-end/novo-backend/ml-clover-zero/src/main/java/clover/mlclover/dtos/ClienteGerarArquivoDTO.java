package clover.mlclover.dtos;

import clover.mlclover.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
@Entity
public class ClienteGerarArquivoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpfOuCnpj;
    private String email;
    private String nome;
    private Integer tipo;

    public ClienteGerarArquivoDTO(Cliente cli){
        id = cli.getId();
        cpfOuCnpj = cli.getCpfOuCnpj();
        email = cli.getEmail();
        nome = cli.getNome();
        tipo = cli.getTipo().getCod();
    }
}
