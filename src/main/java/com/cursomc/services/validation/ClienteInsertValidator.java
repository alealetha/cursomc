package com.cursomc.services.validation;

import com.cursomc.domain.enums.TipoCliente;
import com.cursomc.dto.ClienteNewDTO;
import com.cursomc.resources.exception.FieldMessage;
import com.cursomc.services.validation.utils.BR;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
    @Override
    public void initialize(ClienteInsert ann) {
    }

    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && (!BR.isValidCPF(objDto.getCpfOuCnpj()))) {
            list.add(new FieldMessage("cpfOuCnpj", "CPF Invalido"));
        }

        if (objDto.getTipo().equals(TipoCliente.PESSOAJURIFICA.getCod()) && (!BR.isValidCNPJ(objDto.getCpfOuCnpj()))) {
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ Invalido"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }

        return list.isEmpty();
    }
}