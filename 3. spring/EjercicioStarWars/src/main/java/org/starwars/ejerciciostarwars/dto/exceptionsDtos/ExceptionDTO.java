package org.starwars.ejerciciostarwars.dto.exceptionsDtos;

import org.starwars.ejerciciostarwars.util.enums.CrudOperation;

public record ExceptionDTO(CrudOperation operation, Integer code, String message) {
}
