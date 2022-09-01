package mariano.igor.conexaobancodados.services;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import mariano.igor.conexaobancodados.dtos.CardPaymentDto;
import mariano.igor.conexaobancodados.dtos.PaymentResponseDto;
import mariano.igor.conexaobancodados.exception.MercadoPagoException;
import mariano.igor.conexaobancodados.models.CardPaymentModel;
import mariano.igor.conexaobancodados.repositories.ICardPaymentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CardPaymentService {
  @Value("${mercado_pago_sample_access_token}")
  private String mercadoPagoAccessToken;
  @Autowired
  ICardPaymentRepository cardPaymentRepository;

  public PaymentResponseDto processPayment(CardPaymentDto cardPaymentDTO) {
    try {
      MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);

      PaymentClient paymentClient = new PaymentClient();

      PaymentCreateRequest paymentCreateRequest =
          PaymentCreateRequest.builder()
              .transactionAmount(cardPaymentDTO.getTransactionAmount())
              .token(cardPaymentDTO.getToken())
              .description(cardPaymentDTO.getProductDescription())
              .installments(cardPaymentDTO.getInstallments())
              .paymentMethodId(cardPaymentDTO.getPaymentMethodId())
              .payer(
                  PaymentPayerRequest.builder()
                      .email(cardPaymentDTO.getPayer().getEmail())
                      .identification(
                          IdentificationRequest.builder()
                              .type(cardPaymentDTO.getPayer().getIdentification().getType())
                              .number(cardPaymentDTO.getPayer().getIdentification().getNumber())
                              .build())
                      .build())
              .build();

      Payment createdPayment = paymentClient.create(paymentCreateRequest);

      if(createdPayment.getStatus().equalsIgnoreCase("approved")){
        CardPaymentModel cardPaymentModel = new CardPaymentModel();
        BeanUtils.copyProperties(cardPaymentDTO, cardPaymentModel);
        cardPaymentModel.setId(createdPayment.getId());
        cardPaymentModel.setStatus(createdPayment.getStatus());
        cardPaymentModel.setDetail(createdPayment.getStatusDetail());
        cardPaymentRepository.save(cardPaymentModel);
      }

      return new PaymentResponseDto(
          createdPayment.getId(),
          String.valueOf(createdPayment.getStatus()),
          createdPayment.getStatusDetail());
    } catch (MPApiException apiException) {
      System.out.println(apiException.getApiResponse().getContent());
      throw new MercadoPagoException(apiException.getApiResponse().getContent());
    } catch (MPException exception) {
      System.out.println(exception.getMessage());
      throw new MercadoPagoException(exception.getMessage());
    }
  }
}
