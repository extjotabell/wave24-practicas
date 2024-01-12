package com.practicas.linkTracker.exception;

public class CrudException extends RuntimeException {
    public CrudException() {
    }

    public CrudException(String message) {
        super(message);
    }
}
