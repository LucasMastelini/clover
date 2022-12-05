package clover.mlclover.dtos.enums;

import clover.mlclover.entities.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Acao {


    PUSH(1, "PUSH"),
    POP(2, "POP");

    private int cod;
    private String descricao;

    public static Acao toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(Acao x : Acao.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }

}
