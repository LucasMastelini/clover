package clover.mlclover.entities;

import clover.mlclover.entities.enums.SIZE;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Tamanho implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String tamanho;

    @OneToMany(mappedBy = "tamanho")
    private List<ProdutoTamanho> produtoTamanhos = new ArrayList<>();


    public Tamanho(SIZE tamanho) {
        this.tamanho = tamanho.getTamanho();
    }
}
