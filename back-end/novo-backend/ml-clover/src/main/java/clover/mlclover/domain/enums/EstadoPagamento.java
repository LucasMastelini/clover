package clover.mlclover.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private  int cod;
    private String descricao;

    public static EstadoPagamento toEnum(Integer cod){
        if (cod == null){
            return null;
        }

        for(EstadoPagamento tipo : EstadoPagamento.values()){
            if( cod.equals(tipo.getCod())){
                return tipo;
            }
        }
        throw new IllegalArgumentException("ID inválido: " + cod);
    }
}
