package clover.mlclover.config;


import clover.mlclover.services.EmailService;
import clover.mlclover.services.MockEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("test")
public class TestConfig {


    @Bean
    public EmailService emailService(){
        return new MockEmailService();
    }
}
