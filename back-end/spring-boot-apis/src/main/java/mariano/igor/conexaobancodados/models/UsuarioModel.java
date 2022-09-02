package mariano.igor.conexaobancodados.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Usuario")

public class UsuarioModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 60)
    private String nome;
    @Column(length = 1)
    private String sexo;
    @Column(length = 11)
    private String cpf;
    @Column(length = 15)
    private String telefone;
    @Column(length = 15)
    private String celular;
    @Column(length = 100)
    private String email;
    @Column(length = 20)
    private String senha;
    @Column(length = 8)
    private Double token;
    @OneToMany(mappedBy = "usuario", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<EnderecoModel> enderecos = new ArrayList<>();
    @OneToMany(mappedBy = "usuario", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<PedidosModel> pedidos = new ArrayList<>();
}
