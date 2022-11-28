package clover.mlclover.dtos;

import clover.mlclover.entities.Endereco;
import clover.mlclover.services.validation.ClienteCadastroFC;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ClienteCadastroFC
public class ClienteUpdateFinalizacaoCompraDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String cpfOuCnpj;
    private Integer tipo;
    private String genero;
    @NotEmpty(message = "Preenchimento obrigatório")
    private Date dataNascimento;
    private List<Endereco> enderecos = new ArrayList<>();



}
