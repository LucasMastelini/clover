package terceirosemestre.clover.services.validation;

import org.springframework.beans.factory.annotation.Autowired;
import terceirosemestre.clover.domain.Cliente;
import terceirosemestre.clover.domain.enums.TipoCliente;
import terceirosemestre.clover.dto.ClienteNewDto;
import terceirosemestre.clover.dto.ClienteSenhaDTO;
import terceirosemestre.clover.repositories.ClienteRepository;
import terceirosemestre.clover.resources.exception.FieldMessage;
import terceirosemestre.clover.services.validation.utils.BR;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SenhaValidator implements ConstraintValidator<Senha, String> {

    @Autowired
    private ClienteRepository repo;
    @Override
    public void initialize(Senha ann){
    }
    @Override
    public boolean isValid(String senha, ConstraintValidatorContext context){
        List<FieldMessage> list = new ArrayList<>();


        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the password is empty
        // return false
        if (senha == null) {
            list.add(new FieldMessage("senha", "Preenchimento obrigatório"));
        }

        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(senha);

        if(!m.matches()){
            list.add(new FieldMessage("senha", "Senha não cumpre os requisitos"));
        }

        return list.isEmpty();
    }
}
