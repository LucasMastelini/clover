package clover.mlclover.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SIZE {

    P(1, "P"),
    M(2, "M"),
    G(3, "G"),
    GG(4, "GG"),
    XG(5, "XG"),
    XGG(6, "XGG");

    private  int cod;
    private String tamanho;

    public static SIZE toEnum(Integer cod){
        if (cod == null){
            return null;
        }

        for(SIZE tipo : SIZE.values()){
            if( cod.equals(tipo.getCod())){
                return tipo;
            }
        }
        throw new IllegalArgumentException("ID inválido: " + cod);
    }
}
