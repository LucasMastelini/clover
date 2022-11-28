package clover.mlclover.services.validation;

import clover.mlclover.domain.Cliente;
import clover.mlclover.domain.enums.TipoCliente;
import clover.mlclover.dto.ClienteNewDto;
import clover.mlclover.repositories.ClienteRepository;
import clover.mlclover.resources.exception.FieldMessage;
import clover.mlclover.services.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClientInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDto> {

    @Autowired
    private ClienteRepository repo;
    @Override
    public void initialize(ClienteInsert ann){
    }
    @Override
    public boolean isValid(ClienteNewDto objDto, ConstraintValidatorContext context){
        List<FieldMessage> list = new ArrayList<>();

        if(objDto.getTipo().equals(TipoCliente.PESSOA_FISICA.getCod()) &&
                !BR.isValidCPF(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
        }
        if(objDto.getTipo().equals(TipoCliente.PESSOA_JURIDICA.getCod()) &&
                !BR.isValidCNPJ(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
        }

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
