package clover.mlclover.entities;

import clover.mlclover.dtos.CategoriaPostDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Subcategoria> subcategorias = new ArrayList<>();


    @OneToMany(mappedBy = "categoria")
    private List<ProdutoCategoria> produtoCategorias = new ArrayList<>();

    public Categoria(CategoriaPostDTO obj){
        this.nome = obj.getNome();
    }

    public void updateCategoria(CategoriaPostDTO obj){
        this.nome = obj.getNome();
    }


}
