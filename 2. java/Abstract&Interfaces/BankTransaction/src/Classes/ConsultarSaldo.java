package Classes;

import Classes.Interfaces.Transaccion;

public class ConsultarSaldo implements Transaccion {

    @Override
    public Boolean TransaccionOk() {
        System.out.println("Se ejecutó una consulta de saldo");
        return true;
    }

    @Override
    public Boolean TransaccionNoOk() {
        System.out.println("La consulta de saldo falló");
        return true;
    }
}
