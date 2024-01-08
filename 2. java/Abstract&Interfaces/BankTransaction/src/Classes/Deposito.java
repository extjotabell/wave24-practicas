package Classes;

import Classes.Interfaces.Transaccion;

public class Deposito implements Transaccion {

    @Override
    public Boolean TransaccionOk() {
        System.out.println("Se ejecutó un deposito");
        return true;
    }

    @Override
    public Boolean TransaccionNoOk() {
        System.out.println("El deposito falló");
        return true;
    }

}
