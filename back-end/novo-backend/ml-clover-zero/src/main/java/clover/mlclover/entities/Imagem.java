package clover.mlclover.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Imagem {

    @Id
    private String url;

    @ManyToOne
    @JoinColumn(name = "produto_cor_id")
    private ProdutoCor produtoCor;
}
