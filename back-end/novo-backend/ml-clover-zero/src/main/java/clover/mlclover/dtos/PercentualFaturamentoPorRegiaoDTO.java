package clover.mlclover.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PercentualFaturamentoPorRegiaoDTO {

    private List<PercentualFaturamentoDTO> lista = new ArrayList<>();

}
