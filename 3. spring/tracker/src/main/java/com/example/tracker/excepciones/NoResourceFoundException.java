package com.example.tracker.excepciones;

public class NoResourceFoundException extends RuntimeException {

    public NoResourceFoundException(String message) {
        super(message);
    }
}
