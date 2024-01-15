package com.Link.link.exceptions;

import com.Link.link.util.enums.CrudOperation;
import lombok.Getter;

@Getter
public class NotFoundLinkException extends RuntimeException{
    CrudOperation crudOperation;

    public NotFoundLinkException(CrudOperation crudOperation, String message) {
        super(message);
        this.crudOperation = crudOperation;
    }
}
