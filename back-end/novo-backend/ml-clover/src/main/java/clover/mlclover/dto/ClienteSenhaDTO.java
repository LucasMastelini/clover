package clover.mlclover.dto;

import clover.mlclover.services.validation.ClienteCadastro;
import clover.mlclover.services.validation.Senha;
import com.fasterxml.jackson.annotation.JsonProperty;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
@ClienteCadastro
public class ClienteSenhaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Size(min = 5, max= 120, message = "O tamanho deve ser entre {min} e {max} caracteres.")
    private String nome;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "E-mail inválido")
    private String email;
    @NotEmpty(message = "Preenchimento obrigatório")
    private String celular;
    @Senha(message = "Senha não atende critérios")
    private String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ClienteSenhaDTO(Integer id, String nome, String email, String celular, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.senha = senha;
    }

    public ClienteSenhaDTO() {
    }
}
