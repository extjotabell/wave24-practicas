package org.linktraker.linktrackerapi.exception;

public class InvalidBodyParamsException extends RuntimeException {
    public InvalidBodyParamsException() {
    }
    public InvalidBodyParamsException(String message) {
        super(message);
    }
}
