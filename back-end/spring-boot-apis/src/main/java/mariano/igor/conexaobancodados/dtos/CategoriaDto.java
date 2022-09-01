package mariano.igor.conexaobancodados.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mariano.igor.conexaobancodados.models.SubcategoriaModel;

import java.util.ArrayList;
import java.util.List;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class CategoriaDto {
    private Long id;
    private String descricao;

}
