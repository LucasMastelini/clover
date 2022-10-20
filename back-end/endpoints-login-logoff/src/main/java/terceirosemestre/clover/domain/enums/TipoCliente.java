package terceirosemestre.clover.domain.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum TipoCliente {

    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2 , "Pessoa Jurídica");

    private  int cod;
    private String descricao;

    public static TipoCliente toEnum(Integer cod){
        if (cod == null){
            return null;
        }

        for(TipoCliente tipo : TipoCliente.values()){
            if( cod.equals(tipo.getCod())){
                return tipo;
            }
        }
        throw new IllegalArgumentException("ID inválido: " + cod);
    }

}
