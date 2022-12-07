package clover.mlclover.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PercentualFaturamentoDTO {

    private String regiao;
    private Double percentualFaturamento;
}
