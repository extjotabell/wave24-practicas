package com.demospring.demo.exceptions;

public class ListaVaciaException extends RuntimeException {

    public ListaVaciaException() {
    }

    public ListaVaciaException(String message, String tipoLista) {
        super(message+tipoLista);
    }


}
