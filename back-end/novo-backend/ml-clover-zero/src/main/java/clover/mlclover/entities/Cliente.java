package clover.mlclover.entities;

import clover.mlclover.dtos.ClienteCadastroInicialDTO;
import clover.mlclover.dtos.ClienteDTO;
import clover.mlclover.dtos.ClienteUpdateFinalizacaoCompraDTO;
import clover.mlclover.dtos.EnderecoDTO;
import clover.mlclover.entities.enums.Perfil;
import clover.mlclover.entities.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

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
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private Date dataNascimento;

    @JsonIgnore // os pedidos de cliente não serão serializados
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    private Set<Integer> perfis = new HashSet<>();

    @OneToMany(mappedBy = "cliente")
    private List<Cartao> cartoes = new ArrayList<>();

    public Cliente(Integer id, String nome, String email, String senha, String telefone, String cpfOuCnpj, TipoCliente tipo, String genero, Date dataNascimento, List<Endereco> enderecos, List<Cartao> cartoes) {
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
        this.cartoes = cartoes;
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
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(ClienteUpdateFinalizacaoCompraDTO dto){
        this.id = dto.getId();
        this.genero = dto.getGenero();
        this.cpfOuCnpj = dto.getCpfOuCnpj();
        this.dataNascimento = dto.getDataNascimento();
        this.tipo = TipoCliente.toEnum(dto.getTipo()).getCod();

        List<Endereco> enderecos = new ArrayList<>();
        for(EnderecoDTO e : dto.getEnderecos()){
            Endereco endereco = new Endereco();
            endereco.setCliente(this);
            endereco.setComplemento(e.getComplemento());
            endereco.setLocalidadeCep(e.getLocalidadeCep());
            endereco.setNumero(e.getNumero());
            endereco.setDestinatario(e.getDestinatario());
            enderecos.add(endereco);
        }
        this.enderecos = enderecos;

    }

    public Set<Perfil> getPerfis(){
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil){
        perfis.add(perfil.getCod());
    }

    public TipoCliente getTipo() {
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCod();
    }
}
