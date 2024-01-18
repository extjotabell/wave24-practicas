package org.socialmeli.be_java_hisp_w24_g04.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super();
    }
    public NotFoundException(String message) {
        super(message);
    }
}
