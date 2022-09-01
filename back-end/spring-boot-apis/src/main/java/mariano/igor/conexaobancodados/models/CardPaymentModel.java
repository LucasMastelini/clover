package mariano.igor.conexaobancodados.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="tb_card_payment")
@Getter
@Setter
public class CardPaymentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String status;

    private String detail;

    @NotNull
    private String token;

    private String issuerId;

    @NotNull
    private String paymentMethodId;

    @NotNull
    private BigDecimal transactionAmount;

    @NotNull
    private Integer installments;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String productDescription;

//    @NotNull
//    private PayerDTO payer;

}
