package clover.mlclover.dtos;

import clover.mlclover.dtos.enums.Acao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemCarrinhoDTO {

    private ProdutoDTO produto;
    private Acao acao;

    public void getToEnum(Integer num){
        this.acao = Acao.toEnum(num);
    }
}
