package clover.mlclover.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoPostDTO {

    @NotEmpty(message = "Preenchimento obrigatório")
    @Size(min = 2, max= 80, message = "O tamanho deve ser entre {min} e {max} caracteres.")
    private String nome;

    @NotNull(message = "Preenchimento obrigatório")
    @Min(5)
    @Max(999)
    private Double preco;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(max = 255)
    private String subtitulo;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(max = 10000)
    private String descricao;

    private List<CategoriaDTO> categorias = new ArrayList<>();
    private List<SubcategoriaDTO> subcategorias = new ArrayList<>();
    private List<CorDTO> cores = new ArrayList<>();
    private List<TamanhoDTO> tamanhos = new ArrayList<>();



}
