package org.psvmsa.servlet.request_validator;

import org.psvmsa.dto.CurrencyRequestDto;
import org.psvmsa.exception.InvalidParameterException;

public class CurrenciesRequestValidator implements RequestValidator<CurrencyRequestDto>{
    public void validate(CurrencyRequestDto entity) {
        if (entity.name() == null || entity.name().isBlank()){
            throw new InvalidParameterException("Missing parameter: name");
        }
        if (entity.code() == null || entity.code().isBlank()){
            throw new InvalidParameterException("Missing parameter: code");
        }
        if (entity.sign() == null || entity.sign().isBlank()){
            throw new InvalidParameterException("Missing parameter: sign");
        }
    }
}
