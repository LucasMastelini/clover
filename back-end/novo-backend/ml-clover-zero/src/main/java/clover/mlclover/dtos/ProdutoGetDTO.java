package clover.mlclover.dtos;

import clover.mlclover.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoGetDTO {
    private Integer id;
    private String nome;
    private Double preco;

    private String subtitulo;

    private String descricao;

    public ProdutoGetDTO(Produto obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.preco = obj.getPreco();
        this.subtitulo = obj.getSubtitulo();
        this.descricao = obj.getDescricao();
    }

    public static Page<ProdutoGetDTO> conversor(Page<Produto> produtos){
        return produtos.map(ProdutoGetDTO::new);
    }
}
