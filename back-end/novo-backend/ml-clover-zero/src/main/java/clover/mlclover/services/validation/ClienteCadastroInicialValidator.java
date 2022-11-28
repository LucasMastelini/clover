package clover.mlclover.services.validation;

import clover.mlclover.controllers.exception.FieldMessage;
import clover.mlclover.dtos.ClienteCadastroInicialDTO;
import clover.mlclover.entities.Cliente;
import clover.mlclover.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteCadastroInicialValidator implements ConstraintValidator<ClienteCadastroInicial, ClienteCadastroInicialDTO> {

    @Autowired
    private ClienteRepository repo;
    @Override
    public void initialize(ClienteCadastroInicial ann){
    }
    @Override
    public boolean isValid(ClienteCadastroInicialDTO objDto, ConstraintValidatorContext context){
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
