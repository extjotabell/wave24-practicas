package org.starwars.ejerciciostarwars.exception;

import lombok.Getter;
import org.starwars.ejerciciostarwars.util.enums.CrudOperation;

@Getter
public class EmptyParameterException extends RuntimeException{
    CrudOperation crudOperation;
    public EmptyParameterException() {
    }

    public EmptyParameterException(CrudOperation crudOperation, String message) {
        super(message);
        this.crudOperation = crudOperation;
    }
}
