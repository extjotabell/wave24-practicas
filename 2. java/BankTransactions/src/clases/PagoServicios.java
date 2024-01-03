package clases;

import interfaces.Transaccion;

public class PagoServicios implements Transaccion {
    @Override
    public Boolean transaccionOk() {
        System.out.println("Realizándose pago de servicios");
        return true;
    }

    @Override
    public Boolean transaccionNoOk() {
        System.out.println("Error en el pago de servicios");
        return false;
    }

}
