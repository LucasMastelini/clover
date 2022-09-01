package mariano.igor.conexaobancodados.dtos;

import javax.validation.constraints.NotNull;

public class PayerDto {
    @NotNull
    private String email;

    @NotNull
    private PayerIdentificationDto identification;

    public PayerDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PayerIdentificationDto getIdentification() {
        return identification;
    }

    public void setIdentification(PayerIdentificationDto identification) {
        this.identification = identification;
    }
}
