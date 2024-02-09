package org.mercadolibre.co.lasperlas.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exception extends RuntimeException{
    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e) {
        return "error";
    }
}
