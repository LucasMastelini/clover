package clover.mlclover.entities;

import clover.mlclover.dtos.ClienteCadastroInicialDTO;
import clover.mlclover.dtos.ClienteDTO;
import clover.mlclover.dtos.ClienteUpdateFinalizacaoCompraDTO;
import clover.mlclover.entities.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;
    private String telefone;
    private String cpfOuCnpj;
    private Integer tipo;
    private String genero;
    private Date dataNascimento;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    public Cliente(Integer id, String nome, String email, String senha, String telefone, String cpfOuCnpj, TipoCliente tipo, String genero, Date dataNascimento, List<Endereco> enderecos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = (tipo == null) ? null : tipo.getCod();
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.enderecos = enderecos;
    }

    public Cliente(ClienteDTO dto){
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.email = dto.getEmail();
    }

    public Cliente(ClienteCadastroInicialDTO dto){
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.email = dto.getEmail();
        this.senha = dto.getSenha();
        this.telefone = dto.getTelefone();
    }

    public Cliente(ClienteUpdateFinalizacaoCompraDTO dto){
        this.id = dto.getId();
        this.genero = dto.getGenero();
        this.cpfOuCnpj = dto.getCpfOuCnpj();
        this.dataNascimento = dto.getDataNascimento();
        this.tipo = TipoCliente.toEnum(dto.getTipo()).getCod();
        this.enderecos = dto.getEnderecos();
    }

    public TipoCliente getTipo() {
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }
}
