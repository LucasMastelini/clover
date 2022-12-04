package clover.mlclover.dtos;

import clover.mlclover.entities.Cartao;
import clover.mlclover.entities.Cliente;
import clover.mlclover.entities.Endereco;
import clover.mlclover.entities.Pedido;
import clover.mlclover.entities.enums.Perfil;
import clover.mlclover.entities.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteCompletoDTO {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String cpfOuCnpj;
    private Integer tipo;
    private String genero;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private Date dataNascimento;

    private List<Endereco> enderecos = new ArrayList<>();

    private Set<Integer> perfis = new HashSet<>();

    private List<CartaoGetDTO> cartoes = new ArrayList<>();

    public ClienteCompletoDTO(Cliente obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.telefone = obj.getTelefone();
        this.cpfOuCnpj = obj.getCpfOuCnpj();
        this.tipo = obj.getTipo().getCod();
        this.genero = obj.getGenero();
        this.dataNascimento = obj.getDataNascimento();
        this.enderecos = obj.getEnderecos();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCod()).collect(Collectors.toSet());
        this.cartoes = obj.getCartoes().stream().map(x -> new CartaoGetDTO(x)).collect(Collectors.toList());;
    }

    public Set<Perfil> getPerfis(){
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }


    public TipoCliente getTipo() {
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }
}
