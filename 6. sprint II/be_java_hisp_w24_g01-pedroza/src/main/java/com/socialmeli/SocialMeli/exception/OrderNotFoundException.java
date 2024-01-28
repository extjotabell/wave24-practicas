package com.socialmeli.SocialMeli.exception;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException() {
    }

    public OrderNotFoundException(String order) {
        super("Sorting parameter " + order + " does not exist");
    }
}
