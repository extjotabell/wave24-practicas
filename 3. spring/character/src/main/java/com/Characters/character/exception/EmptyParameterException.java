package com.Characters.character.exception;

import com.Characters.character.util.enums.CrudOperation;
import lombok.Getter;

@Getter
public class EmptyParameterException extends RuntimeException {
    CrudOperation crudOperation;
    public EmptyParameterException() {
    }

    public EmptyParameterException(CrudOperation crudOperation, String message) {
        super(message);
        this.crudOperation = crudOperation;
    }
}
