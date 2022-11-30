package clover.mlclover.services;

import clover.mlclover.entities.PagamentoComBoleto;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class BoletoService {

    public void preencherPagamentoComBoleto(PagamentoComBoleto pagamento, Date instanteDoPedido){
        Calendar cal = Calendar.getInstance();
        cal.setTime(instanteDoPedido);
        cal.add(Calendar.DAY_OF_MONTH, 3);
        pagamento.setDataVencimento(cal.getTime());
    }
}
