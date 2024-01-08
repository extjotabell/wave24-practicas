package Classes;

import Classes.Interfaces.Transaccion;

public class Transferencia implements Transaccion {
    @Override
    public Boolean TransaccionOk() {
        System.out.println("Se ejecutó una transferencia");
        return true;
    }

    @Override
    public Boolean TransaccionNoOk() {
        System.out.println("La transferencia falló");
        return true;
    }
}
