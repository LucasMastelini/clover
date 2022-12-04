package clover.mlclover.dtos;

import clover.mlclover.entities.Cartao;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartaoGetDTO {

    private Integer id;
    private String titular;
    private String ultimosQuatroDigitos;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/yy", locale = "pt-BR", timezone = "UTC")
    private Date dataVencimento;

    public CartaoGetDTO(Cartao obj){
        this.id = obj.getId();;
        this.titular = obj.getTitular();
        this.ultimosQuatroDigitos = obj.getUltimosQuatroDigitos();
        this.dataVencimento = obj.getDataVencimento();
    }
}
