package clover.mlclover.entities;

import clover.mlclover.dtos.SubcategoriaPostDTO;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Subcategoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "subcategoria")
    private List<ProdutoSubcategoria> produtoSubcategorias = new ArrayList<>();


    public Subcategoria(String nome, Categoria categoria){
        this.nome = nome;
        this.categoria = categoria;
    }



}
