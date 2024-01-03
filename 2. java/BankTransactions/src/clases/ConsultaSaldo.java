package clases;

import interfaces.Transaccion;

public class ConsultaSaldo implements Transaccion {
    @Override
    public Boolean transaccionOk() {

        System.out.println("Realizándose consulta de saldo");
        return true;
    }

    @Override
    public Boolean transaccionNoOk() {

        System.out.println("Error en la consulta de saldo");
        return false;
    }

}
