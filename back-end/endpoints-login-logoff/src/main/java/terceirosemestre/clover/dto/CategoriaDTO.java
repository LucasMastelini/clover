package terceirosemestre.clover.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import terceirosemestre.clover.domain.Categoria;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Size(min = 5, max= 80, message = "O tamanho deve ser entre {min} e {max} caracteres.")
    private String nome;

    public CategoriaDTO(Categoria categoria){
        id = categoria.getId();
        nome = categoria.getNome();
    }
}
