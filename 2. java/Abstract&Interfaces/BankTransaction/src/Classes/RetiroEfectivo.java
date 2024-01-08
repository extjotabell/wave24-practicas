package Classes;

import Classes.Interfaces.Transaccion;

public class RetiroEfectivo implements Transaccion {

    @Override
    public Boolean TransaccionOk() {
        System.out.println("Se ejecutó un retiro de efectivo");
        return true;
    }

    @Override
    public Boolean TransaccionNoOk() {
        System.out.println("El retiro de efectivo falló");
        return true;
    }
}
