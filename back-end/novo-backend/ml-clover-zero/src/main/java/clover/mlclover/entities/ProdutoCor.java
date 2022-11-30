package clover.mlclover.entities;

import clover.mlclover.entities.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProdutoCor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "cor_id")
    private Cor cor;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "IMAGENS")
    private Set<String> imagens = new HashSet<>();

    public ProdutoCor(Produto produto, Cor cor){
        this.produto = produto;
        this.cor = cor;
    }

    public Set<String> getImagens(){
        return imagens;
    }

    public void addImagem(String imagem){
        imagens.add(imagem);
    }
}
