package com.socialmeli.SocialMeli.exception;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException() {
    }

    public OrderNotFoundException(String order) {
        super("Orden invalido: " + order);
    }
}
