package classes;

import classes.interfaces.Transaccion;

public class ConsultaSaldo implements Transaccion {

    @Override
    public Boolean transaccionOk() {
        System.out.println("Se esta ejecutando una consula de saldo");
        return true;
    }

    @Override
    public Boolean transaccionNoOk() {
        System.out.println("La consulta de saldo fallo");
        return false;
    }

}
