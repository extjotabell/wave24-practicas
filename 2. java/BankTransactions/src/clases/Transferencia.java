package clases;

import interfaces.Transaccion;

public class Transferencia implements Transaccion {
    @Override
    public Boolean transaccionOk() {
        System.out.println("Realizándose transferencia");
        return true;
    }
    @Override
    public Boolean transaccionNoOk() {
        System.out.println("Error en la transferencia");
        return false;
    }
}
