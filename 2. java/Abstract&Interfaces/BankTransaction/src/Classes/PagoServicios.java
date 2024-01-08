package Classes;

import Classes.Interfaces.Transaccion;

public class PagoServicios implements Transaccion {

    @Override
    public Boolean TransaccionOk() {
        System.out.println("Se ejecutó un pago de servicios");
        return true;
    }

    @Override
    public Boolean TransaccionNoOk() {
        System.out.println("El pago de servicios falló");
        return true;
    }
}
