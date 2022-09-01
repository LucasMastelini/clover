package mariano.igor.conexaobancodados.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import mariano.igor.conexaobancodados.enums.StatusEmail;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="tb_email")
@Getter
@Setter
public class EmailModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long email;
    // ID do Usuário pra quem está sendo enviado o e-mail (Posteriormente fazer uma lista de quantos e-mails foram
    // enviados para determinado usuário
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    // Aumenta a capacidade da coluna no BD para armazenar String > 255 caracteres
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;
}
