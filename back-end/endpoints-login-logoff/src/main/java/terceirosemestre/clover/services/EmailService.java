package terceirosemestre.clover.services;

import org.springframework.mail.SimpleMailMessage;
import terceirosemestre.clover.domain.Pedido;

import javax.mail.internet.MimeMessage;


public interface EmailService {

    void sendOrderConfirmationMail(Pedido obj);

    void sendEmail(SimpleMailMessage msg);

    void sendOrderConfirmationHtmlEmail(Pedido obj);

    void sendHtmlEmail(MimeMessage msg);
}
