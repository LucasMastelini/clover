package clover.mlclover.dtos;

import clover.mlclover.entities.Endereco;
import clover.mlclover.entities.LocalidadeCep;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;

@Table
@Getter
@Setter
@NoArgsConstructor
public class EnderecoDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private LocalidadeCep localidadeCep;
    private String numero;
    private String complemento;
    private String destinatario;

    public EnderecoDTO(Endereco obj){
        this.id = obj.getId();
        this.localidadeCep = obj.getLocalidadeCep();
        this.numero = obj.getNumero();
        this.complemento = obj.getComplemento();
        this.destinatario = obj.getDestinatario();
    }
}
