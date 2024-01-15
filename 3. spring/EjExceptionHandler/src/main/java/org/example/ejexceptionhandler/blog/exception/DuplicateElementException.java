package org.example.ejexceptionhandler.blog.exception;

public class DuplicateElementException extends RuntimeException {
    public DuplicateElementException(String elElementoConId, Long id, String s) {
    }

    @Override
    public DuplicateElementException(){
        super()
    }
}
