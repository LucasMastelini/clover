package clover.mlclover.entities;


import clover.mlclover.dtos.ProdutoDTO;
import clover.mlclover.dtos.ProdutoPostDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double preco;

    private String subtitulo;
    @Column(columnDefinition = "TEXT")
    private String descricao;

    @OneToMany(mappedBy = "produto")
    private List<ProdutoCategoria> produtoCategorias = new ArrayList<>();

    @OneToMany(mappedBy = "produto")
    private List<ProdutoSubcategoria> produtoSubcategorias = new ArrayList<>();

    @OneToMany(mappedBy = "produto")
    private List<ProdutoTamanho> produtoTamanhos = new ArrayList<>();

    @OneToMany(mappedBy = "produto")
    private List<ProdutoCor> produtoCores = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens = new HashSet<>();

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(ProdutoPostDTO obj){
        this.nome = obj.getNome();
        this.preco = obj.getPreco();
        this.subtitulo = obj.getSubtitulo();
        this.descricao = obj.getDescricao();
    }

    public Produto(ProdutoDTO obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.preco = obj.getPreco();
    }

    public void updateProduto(ProdutoPostDTO obj){
        this.nome = obj.getNome();
        this.preco = obj.getPreco();
        this.subtitulo = obj.getSubtitulo();
        this.descricao = obj.getDescricao();
    }

    @JsonIgnore
    public List<Pedido> getPedidos(){
        List<Pedido> lista = new ArrayList<>();
        for(ItemPedido ip : itens){
            lista.add(ip.getPedido());
        }
        return lista;
    }

//    @JsonIgnore
//    public List<Pedido> getPedidos(){
//        List<Pedido> lista = new ArrayList<>();
//        for(ItemPedido x : itens){
//            lista.add(x.getPedido());
//        }
//        return lista;
//    }

}
