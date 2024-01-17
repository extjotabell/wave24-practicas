package org.example.ejercicio.exception;

public class DataIntegrityViolationException extends RuntimeException{

    public DataIntegrityViolationException() {

    }

    public DataIntegrityViolationException(String message) {
        super(message);
    }
}
