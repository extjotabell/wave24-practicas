package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;

public class InvalidDuplicatedDataException extends ObtenerDiplomaException {
    public InvalidDuplicatedDataException(Long id) {
        super("Duplicated data when saving new " + id, HttpStatus.BAD_REQUEST);
    }
}
