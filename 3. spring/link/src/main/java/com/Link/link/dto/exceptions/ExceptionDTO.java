package com.Link.link.dto.exceptions;

import com.Link.link.util.enums.CrudOperation;
import lombok.Getter;

public record ExceptionDTO (
        CrudOperation operation,
        String timestamp,
        Integer status,
        String error,
        String message){

}
