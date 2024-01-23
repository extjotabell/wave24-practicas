package org.starwars.ejerciciostarwars.exception;

import lombok.Getter;
import org.starwars.ejerciciostarwars.util.enums.CrudOperation;
@Getter
public class EmptyListException extends RuntimeException{
    CrudOperation crudOperation;

    public EmptyListException(CrudOperation crudOperation, String message) {
        super(message);
        this.crudOperation = crudOperation;
    }
}
