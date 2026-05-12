package org.psvmsa.utils;

import org.psvmsa.dto.CurrencyRequestDto;
import org.psvmsa.entity.Currency;

public final class Mapper {

    public static Currency convertToEntity(CurrencyRequestDto dto) {
        return new Currency(null, dto.name(), dto.code(), dto.sign());
    }
}
