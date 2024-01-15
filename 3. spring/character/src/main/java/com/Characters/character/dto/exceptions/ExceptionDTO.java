package com.Characters.character.dto.exceptions;

import com.Characters.character.util.enums.CrudOperation;
import lombok.Getter;

public record ExceptionDTO(CrudOperation operation, Integer code, String message) {

}
