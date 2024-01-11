package com.example.blog.exceptions.customExceptions;

import com.example.blog.utils.UserAction;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomApiException extends RuntimeException{

    private final int CODE = 500;
    private final UserAction action;
    private final HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    public CustomApiException(String message, UserAction action) {
        super(message);
        this.action = action;
    }
}
