package com.socialmeli.SocialMeli.exception;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(String order) {
        super("Sorting parameter " + order + " does not exist");
    }
}
