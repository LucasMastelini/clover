package mariano.igor.conexaobancodados.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CardPaymentDto {
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
    @JsonProperty("description")
    private String productDescription;

    @NotNull
    private PayerDto payer;

    public CardPaymentDto() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public PayerDto getPayer() {
        return payer;
    }

    public void setPayer(PayerDto payer) {
        this.payer = payer;
    }
}
