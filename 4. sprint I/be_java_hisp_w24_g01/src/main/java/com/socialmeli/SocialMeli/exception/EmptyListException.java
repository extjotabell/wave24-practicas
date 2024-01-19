package com.socialmeli.SocialMeli.exception;

public class EmptyListException extends RuntimeException{

        public EmptyListException() {
        }

        public EmptyListException(String message) {
            super(message);
        }
}
