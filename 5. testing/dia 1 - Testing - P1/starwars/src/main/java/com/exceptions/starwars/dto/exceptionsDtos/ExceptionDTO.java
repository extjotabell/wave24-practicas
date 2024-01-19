package com.exceptions.starwars.dto.exceptionsDtos;

import com.exceptions.starwars.util.enums.CrudOperation;
import lombok.ToString;

public record ExceptionDTO(
        CrudOperation operation,
        String message
) {
}
