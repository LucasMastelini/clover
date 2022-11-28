package clover.mlclover.dtos;

import clover.mlclover.entities.Categoria;
import clover.mlclover.entities.Subcategoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaGetDTO {

    @NotEmpty
    private Integer id;

    @Size(min = 2, max= 80, message = "O tamanho deve ser entre {min} e {max} caracteres.")
    private String nome;

    private List<SubcategoriaDTO> subcategorias = new ArrayList<>();

    public CategoriaGetDTO(Categoria obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        List<SubcategoriaDTO> lista = new ArrayList<>();
        for(Subcategoria s : obj.getSubcategorias()){
            lista.add(new SubcategoriaDTO(s));
        }
        this.subcategorias = lista;
    }
}
