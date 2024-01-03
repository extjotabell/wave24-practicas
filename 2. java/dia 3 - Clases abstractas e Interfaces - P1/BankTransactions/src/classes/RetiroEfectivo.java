package classes;

import classes.interfaces.Transaccion;

public class RetiroEfectivo implements Transaccion {

    @Override
    public Boolean transaccionOk() {
        System.out.println("Se esta ejecutando un retiro de efectivo");
        return true;
    }

    @Override
    public Boolean transaccionNoOk() {
        System.out.println("El retiro de efectivo fallo");
        return false;
    }

}
