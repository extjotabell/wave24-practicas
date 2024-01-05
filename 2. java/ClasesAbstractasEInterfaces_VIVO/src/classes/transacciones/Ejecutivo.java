package classes.transacciones;

import classes.transacciones.interfaces.Deposito;
import classes.transacciones.interfaces.Transferencia;

public class Ejecutivo implements Transferencia, Deposito {

    @Override
    public void TransaccionOk() {
        System.out.println("Transaccion exitosa para Cliente Ejecutivo");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("Fallida exitosa para Cliente Ejecutivo");
    }

    @Override
    public void depositarDinero(int dinero) {
        System.out.println("Se depositaran el siguiente dinero: "+dinero);
    }

    @Override
    public void hacerTransferencia(int valor) {
        System.out.println("se transferira "+valor);
    }
}
