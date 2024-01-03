package clases;

import interfaces.Transaccion;

public class Deposito implements Transaccion {
    @Override
    public Boolean transaccionOk() {
    System.out.println("Realizándose depósito");
        return true;
    }

    @Override
    public Boolean transaccionNoOk() {
        System.out.println("Error en el depósito");
        return false;
    }
}
