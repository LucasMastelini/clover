package clover.mlclover.dtos;


import clover.mlclover.entities.Categoria;
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
public class CategoriaDTO {

    @NotEmpty
    private Integer id;

    @Size(min = 2, max= 80, message = "O tamanho deve ser entre {min} e {max} caracteres.")
    private String nome;

    public CategoriaDTO(Categoria categoria){
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

}
