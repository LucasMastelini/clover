package clover.mlclover.dtos;

import clover.mlclover.dtos.enums.Acao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarrinhoDTO {

    private List<Stack<ProdutoDTO>> listaDePilhasDeProdutos = new ArrayList<>();
    private ItemCarrinhoDTO item;

}
