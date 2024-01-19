package com.exceptions.starwars.exception;

import com.exceptions.starwars.util.enums.CrudOperation;
import lombok.Getter;

@Getter
public class EmptyParameterException extends RuntimeException{

    private CrudOperation crudOperation;

    public EmptyParameterException() {
    }

    public EmptyParameterException(CrudOperation crudOperation, String message) {
        super(message);
        this.crudOperation = crudOperation;
    }
}
