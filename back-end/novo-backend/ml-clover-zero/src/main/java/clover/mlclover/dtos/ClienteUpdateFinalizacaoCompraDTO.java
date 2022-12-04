package clover.mlclover.dtos;

import clover.mlclover.entities.Cliente;
import clover.mlclover.entities.Endereco;
import clover.mlclover.services.validation.ClienteCadastroFC;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private Date dataNascimento;
    private List<EnderecoDTO> enderecos = new ArrayList<>();

    public ClienteUpdateFinalizacaoCompraDTO(Cliente obj){
        this.id = obj.getId();;
        this.cpfOuCnpj = obj.getCpfOuCnpj();
        this.tipo = obj.getTipo().getCod();
        this.genero = obj.getGenero();
        this.dataNascimento = obj.getDataNascimento();
        List<EnderecoDTO> lista = new ArrayList<>();
        for(Endereco e : obj.getEnderecos()){
            lista.add(new EnderecoDTO(e));
        }
        this.enderecos = lista;
    }




}
