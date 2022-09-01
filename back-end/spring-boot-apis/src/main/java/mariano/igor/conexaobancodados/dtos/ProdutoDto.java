package mariano.igor.conexaobancodados.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mariano.igor.conexaobancodados.models.EspecificacaoProdutoModel;
import mariano.igor.conexaobancodados.models.ProdutoImagemModel;
import mariano.igor.conexaobancodados.models.SubcategoriaModel;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoDto {
    private String sku;
    private String nome;
    private String descricao;
    private Double valor;
    private List<EspecificacaoProdutoModel> especificacoes = new ArrayList<>();
    private List<ProdutoImagemModel> imagens = new ArrayList<>();
    private List<SubcategoriaModel> subcategorias = new ArrayList<>();



}
