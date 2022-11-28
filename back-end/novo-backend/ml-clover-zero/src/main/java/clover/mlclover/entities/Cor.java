package clover.mlclover.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String hexadecimal;
    private String nome;

    @OneToMany(mappedBy = "cor")
    private List<ProdutoCor> produtoCores = new ArrayList<>();




}
