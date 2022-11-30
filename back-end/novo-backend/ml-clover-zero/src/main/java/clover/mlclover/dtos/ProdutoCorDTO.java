package clover.mlclover.dtos;

import clover.mlclover.entities.ProdutoCor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoCorDTO {

    private Integer id;
    private Integer idProduto;
    private String hexadecimal;
    private List<String> imagens = new ArrayList<>();

    public ProdutoCorDTO(ProdutoCor obj){
        this.id = obj.getId();
        this.idProduto = obj.getProduto().getId();
        this.hexadecimal = obj.getCor().getHexadecimal();
        this.imagens = obj.getImagens().stream().collect(Collectors.toList());
    }
}
