package mariano.igor.conexaobancodados.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mariano.igor.conexaobancodados.models.CategoriaModel;
import mariano.igor.conexaobancodados.models.ProdutoModel;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoriaDto {
    private Long id;
    private String descricao;

}
