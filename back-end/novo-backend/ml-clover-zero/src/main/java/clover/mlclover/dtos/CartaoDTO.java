package clover.mlclover.dtos;

import clover.mlclover.entities.Cartao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CartaoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private String titular;
    private String numero;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/yy", locale = "pt-BR", timezone = "UTC")
    private Date dataVencimento;
    private String cvv;


}
