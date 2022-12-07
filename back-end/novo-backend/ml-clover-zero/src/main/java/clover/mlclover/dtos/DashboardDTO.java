package clover.mlclover.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashboardDTO {

    // gráfico de pizza
    private PercentualFaturamentoPorRegiaoDTO percentualFaturamentoPorRegiao;
    // gráfico de linhas
    private TaxaConversaoDTO taxaConversao;
    // gráfico de barras
    private TicketMedioDTO ticketMedio;
}
