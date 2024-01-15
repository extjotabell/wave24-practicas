package com.Characters.character.exception;

import com.Characters.character.util.enums.CrudOperation;
import lombok.Getter;

@Getter
public class EmptyListException extends RuntimeException{
    CrudOperation crudOperation;
    public EmptyListException() {
    }

    public EmptyListException(CrudOperation crudOperation, String message) {
        super(message);
        this.crudOperation = crudOperation;
    }
}
