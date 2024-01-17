package org.socialmeli.be_java_hisp_w24_g04.exception;

public class InvalidTimeException extends RuntimeException{
    public InvalidTimeException() {
    }
    public InvalidTimeException(String message) {
        super(message);
    }
}
