package clover.mlclover.services.validation;

import clover.mlclover.controllers.exception.FieldMessage;
import clover.mlclover.dtos.ClienteUpdateFinalizacaoCompraDTO;
import clover.mlclover.entities.enums.TipoCliente;
import clover.mlclover.repositories.ClienteRepository;
import clover.mlclover.services.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteCadastroFCValidator implements ConstraintValidator<ClienteCadastroFC, ClienteUpdateFinalizacaoCompraDTO> {

    // FC -> Finalização de Compra

    @Autowired
    private ClienteRepository repo;
    @Override
    public void initialize(ClienteCadastroFC ann){
    }
    @Override
    public boolean isValid(ClienteUpdateFinalizacaoCompraDTO objDto, ConstraintValidatorContext context){
        List<FieldMessage> list = new ArrayList<>();

        if(objDto.getTipo().equals(TipoCliente.PESSOA_FISICA.getCod()) &&
                !BR.isValidCPF(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
        }
        if(objDto.getTipo().equals(TipoCliente.PESSOA_JURIDICA.getCod()) &&
                !BR.isValidCNPJ(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
        }
//
//        Cliente aux = repo.findByEmail(objDto.getEmail());
//        if(aux != null){
//            list.add(new FieldMessage("email", "Email já existente"));
//        }

        // testes aqui, inserindo erros na lista
        for(FieldMessage e : list){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
