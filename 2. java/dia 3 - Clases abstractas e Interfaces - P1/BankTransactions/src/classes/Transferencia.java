package classes;

import classes.interfaces.Transaccion;

public class Transferencia implements Transaccion {

    @Override
    public Boolean transaccionOk() {
        System.out.println("Se esta ejecutando una transferencia");
        return true;
    }

    @Override
    public Boolean transaccionNoOk() {
        System.out.println("La transferencia fallo");
        return false;
    }

}
