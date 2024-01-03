package classes;

import classes.interfaces.Transaccion;

public class Deposito implements Transaccion {

    @Override
    public Boolean transaccionOk() {
        System.out.println("Se esta ejecutando un deposito");
        return true;
    }

    @Override
    public Boolean transaccionNoOk() {
        System.out.println("El deposito fallo");
        return false;
    }

}
