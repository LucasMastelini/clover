package clover.mlclover.dtos;

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
public class CategoriaPostDTO {
    @NotEmpty(message = "Preenchimento obrigatório")
    @Size(min = 2, max= 80, message = "O tamanho deve ser entre {min} e {max} caracteres.")
    private String nome;

    private List<SubcategoriaDTO> subcategorias = new ArrayList<>();
    private List<ProdutoDTO> produtos = new ArrayList<>();
}
