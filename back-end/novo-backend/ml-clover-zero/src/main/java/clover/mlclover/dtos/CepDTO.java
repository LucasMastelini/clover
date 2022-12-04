package clover.mlclover.dtos;

import clover.mlclover.entities.LocalidadeCep;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CepDTO {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String tipoLogradouro;
    private String latitude;
    private String longitute;

    public CepDTO(LocalidadeCep obj){
        this.cep = obj.getCep();
        this.logradouro = obj.getLogradouro();
        this.complemento = obj.getComplemento();
        this.bairro = obj.getBairro();
        this.cidade = obj.getCidade();
        this.uf = obj.getUf();
        this.tipoLogradouro = obj.getTipoLogradouro();
        this.latitude = obj.getLatitude();
        this.longitute = obj.getLongitude();
    }

}
