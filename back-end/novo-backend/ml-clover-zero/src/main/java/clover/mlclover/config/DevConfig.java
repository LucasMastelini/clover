package clover.mlclover.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("dev")
public class DevConfig {

//
//    @Bean
//    public EmailService emailService(){
//        return new MockEmailService();
//    }
}
