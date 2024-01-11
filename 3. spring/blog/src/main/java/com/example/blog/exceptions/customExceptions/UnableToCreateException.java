package com.example.blog.exceptions.customExceptions;

import com.example.blog.utils.UserAction;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UnableToCreateException extends CustomApiException {

    private final static int CODE = 406;
    private final HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;
    private final String objeto;

    private final String causa;


    public UnableToCreateException(String message, UserAction action, Class<?> clazz, String cause) {
        super(message, action);
        this.objeto = clazz.getSimpleName();
        this.causa = cause;
    }
}
