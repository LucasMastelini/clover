package clover.msoauth.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class LocalidadeCep {

    // base CEP's
    @Id
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String tipoLogradouro;
    @JsonIgnore
    private String idUsuarioIns;
    @JsonIgnore
    private String dtUsuarioIns;
    @JsonIgnore
    private String stAtivo;
    private String latitude;
    private String longitude;


}
