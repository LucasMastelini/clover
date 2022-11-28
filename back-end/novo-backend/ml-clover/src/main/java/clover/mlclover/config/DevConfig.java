package clover.mlclover.config;

import clover.mlclover.services.DBService;
import clover.mlclover.services.EmailService;
import clover.mlclover.services.SmtpEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import java.text.ParseException;

@Configuration
@Profile("dev")
public class DevConfig {

    @Value(("${spring.jpa.hibernate.ddl-auto}"))
    private String strategy;
    @Autowired
    private DBService dbService;

    @Bean
    public boolean instantiateDatabase() throws ParseException {

        if(!"create".equals(strategy)){
            return false;
        }

        dbService.instantiateTestDatabase();
        return true;
    }

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }
}
