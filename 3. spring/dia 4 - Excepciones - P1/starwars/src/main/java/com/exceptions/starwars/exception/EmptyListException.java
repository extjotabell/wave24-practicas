package com.exceptions.starwars.exception;

import com.exceptions.starwars.util.enums.CrudOperation;
import lombok.Getter;

@Getter
public class EmptyListException extends RuntimeException{

    private CrudOperation crudOperation;

    public EmptyListException() {
    }

    public EmptyListException(CrudOperation crudOperation, String message) {
        super(message);
        this.crudOperation = crudOperation;
    }
}
