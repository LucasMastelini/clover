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

public class ClientCadastroValidator implements ConstraintValidator<ClienteCadastro, ClienteSenhaDTO> {

    @Autowired
    private ClienteRepository repo;
    @Override
    public void initialize(ClienteCadastro ann){
    }
    @Override
    public boolean isValid(ClienteSenhaDTO objDto, ConstraintValidatorContext context){
        List<FieldMessage> list = new ArrayList<>();

        Cliente aux = repo.findByEmail(objDto.getEmail());
        if(aux != null){
            list.add(new FieldMessage("email", "Email já existente"));
        }

        // testes aqui, inserindo erros na lista
        for(FieldMessage e : list){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
