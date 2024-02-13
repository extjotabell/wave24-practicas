package com.jpa.integrador.exception;

public class DBConnectionException extends RuntimeException {
    public DBConnectionException(String message) {
        super(message);
    }
}
