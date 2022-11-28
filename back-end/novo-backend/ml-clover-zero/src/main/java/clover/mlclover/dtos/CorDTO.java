package clover.mlclover.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CorDTO {

    @NotEmpty
    private String hexadecimal;
    private String nome;
}
