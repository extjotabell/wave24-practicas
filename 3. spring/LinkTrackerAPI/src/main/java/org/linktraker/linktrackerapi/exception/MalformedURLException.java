package org.linktraker.linktrackerapi.exception;

public class MalformedURLException extends RuntimeException {
    public MalformedURLException() {
    }
    public MalformedURLException(String message) {
        super(message);
    }
}
