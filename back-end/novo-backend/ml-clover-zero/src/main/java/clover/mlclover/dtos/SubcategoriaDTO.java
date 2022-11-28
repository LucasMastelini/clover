package clover.mlclover.dtos;

import clover.mlclover.entities.Subcategoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubcategoriaDTO {

    private Integer id;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Size(min = 2, max= 80, message = "O tamanho deve ser entre {min} e {max} caracteres.")
    private String nome;

    public SubcategoriaDTO(Subcategoria obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
    }
}
