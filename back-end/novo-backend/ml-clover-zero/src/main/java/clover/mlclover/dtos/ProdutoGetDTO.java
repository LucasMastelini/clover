package clover.mlclover.dtos;

import clover.mlclover.entities.Produto;
import clover.mlclover.entities.ProdutoCor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

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

    private List<ProdutoCorDTO> produtoCores = new ArrayList<>();

    public ProdutoGetDTO(Produto obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.preco = obj.getPreco();
        this.subtitulo = obj.getSubtitulo();
        this.descricao = obj.getDescricao();
        List<ProdutoCorDTO> lista = new ArrayList<>();
        for(ProdutoCor pc : obj.getProdutoCores()){
            lista.add(new ProdutoCorDTO(pc));
        }
        this.produtoCores = lista;
    }

    public static Page<ProdutoGetDTO> conversor(Page<Produto> produtos){
        return produtos.map(ProdutoGetDTO::new);
    }
}
