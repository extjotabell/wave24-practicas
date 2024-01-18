package com.socialmeli.SocialMeli.exception;

public class UserNotFoundException extends RuntimeException
{
    public UserNotFoundException(String message) {
        super(message);
    }
}
