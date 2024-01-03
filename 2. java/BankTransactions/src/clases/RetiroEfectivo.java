package clases;

import interfaces.Transaccion;

public class RetiroEfectivo implements Transaccion {
    @Override
    public Boolean transaccionOk() {
        System.out.println("Realizándose retiro de efectivo");
        return true;
    }

    @Override
    public Boolean transaccionNoOk() {
        System.out.println("Error en el retiro de efectivo");
        return false;
    }
}
