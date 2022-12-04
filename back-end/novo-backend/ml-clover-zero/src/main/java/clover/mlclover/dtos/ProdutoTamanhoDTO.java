package clover.mlclover.dtos;

import clover.mlclover.entities.ProdutoTamanho;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoTamanhoDTO {

    private String tamanho;



    public ProdutoTamanhoDTO(ProdutoTamanho obj){
        this.tamanho = obj.getTamanho().getTamanho();
    }
}
