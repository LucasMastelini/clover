package clover.mlclover.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.MimeMessage;

public class SmtpEmailService extends AbstractEmailService{

    @Autowired
    MailSender mailSender;

    @Autowired
    JavaMailSender javaMailSender;

    private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

    @Override
    public void sendEmail(SimpleMailMessage msg) {
        LOG.info("Enviando e-mail");
        mailSender.send(msg);
        LOG.info("E-mail enviado");

    }

    @Override
    public void sendHtmlEmail(SimpleMailMessage msg) {

    }

    @Override
    public void sendHtmlEmail(MimeMessage msg) {
        LOG.info("Enviando e-mail");
        javaMailSender.send(msg);
        LOG.info("E-mail enviado");
    }
}
