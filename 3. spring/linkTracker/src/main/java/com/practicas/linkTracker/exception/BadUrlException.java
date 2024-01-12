package com.practicas.linkTracker.exception;

public class BadUrlException extends RuntimeException {
    public BadUrlException() {
    }

    public BadUrlException(String message) {
        super(message);
    }
}
