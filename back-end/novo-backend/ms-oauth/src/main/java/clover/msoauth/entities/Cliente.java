package clover.msoauth.entities;

import clover.msoauth.entities.enums.Perfil;
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
    private Date dataNascimento;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    // atributo correspondente aos perfis do usuário a serem armazenados na base de dados
    // EAGER -> garante que os perfis serão buscados junto do cliente
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    private Set<Integer> perfis = new HashSet<>();

    public Cliente(Integer id, String nome, String email, String senha, String telefone, String cpfOuCnpj, Integer tipo, String genero, Date dataNascimento, List<Endereco> enderecos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.enderecos = enderecos;
        addPerfil(Perfil.CLIENTE);
    }

    public Set<Perfil> getPerfis(){
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil){
        perfis.add(perfil.getCod());
    }


}
