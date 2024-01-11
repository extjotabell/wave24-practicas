package com.example.blog.exceptions.customExceptions;

import com.example.blog.utils.UserAction;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends CustomApiException {

    private final static int CODE = 404;
    private final HttpStatus httpStatus = HttpStatus.NOT_FOUND;
    private final String objeto;

    public NotFoundException(String message, UserAction action, Class<?> clazz) {
        super(message, action);
        this.objeto = clazz.getSimpleName();
    }

}
