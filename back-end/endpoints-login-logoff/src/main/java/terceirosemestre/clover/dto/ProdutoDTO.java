package terceirosemestre.clover.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import terceirosemestre.clover.domain.Produto;

import java.io.Serializable;
@NoArgsConstructor
@Getter
@Setter
public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private Double preco;

    public ProdutoDTO(Produto obj){
        id = obj.getId();
        nome = obj.getNome();
        preco = obj.getPreco();
    }
}
