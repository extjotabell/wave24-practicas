package com.Link.link.exceptions;

import com.Link.link.util.enums.CrudOperation;
import lombok.Getter;

@Getter
public class InvalidUrlException extends RuntimeException
{
    CrudOperation crudOperation;
    public InvalidUrlException(CrudOperation crudOperation, String message) {
        super(message);
        this.crudOperation = crudOperation;
    }
}
