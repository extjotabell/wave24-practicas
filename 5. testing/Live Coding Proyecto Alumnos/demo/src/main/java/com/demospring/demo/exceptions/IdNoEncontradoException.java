package com.demospring.demo.exceptions;

public class IdNoEncontradoException extends RuntimeException{

    public IdNoEncontradoException() {
    }

    public IdNoEncontradoException(String message) {
        super(message);
    }
}
