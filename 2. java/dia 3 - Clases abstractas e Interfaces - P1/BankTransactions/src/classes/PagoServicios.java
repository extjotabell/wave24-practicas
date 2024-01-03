package classes;

import classes.interfaces.Transaccion;

public class PagoServicios implements Transaccion {

    @Override
    public Boolean transaccionOk() {
        System.out.println("Se esta ejecutando un pago de servicios");
        return true;
    }

    @Override
    public Boolean transaccionNoOk() {
        System.out.println("El pago de servicios fallo");
        return false;
    }

}
