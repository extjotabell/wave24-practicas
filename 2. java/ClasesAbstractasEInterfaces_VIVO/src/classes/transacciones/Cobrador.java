package classes.transacciones;

import classes.transacciones.interfaces.ConsultaSaldo;
import classes.transacciones.interfaces.Retiro;


public class Cobrador implements Retiro, ConsultaSaldo {

    @Override
    public void TransaccionOk() {
        System.out.println("Transaccion exitosa para Cliente cobrador");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("Fallida exitosa para Cliente cobrador");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("su saldo es de 12345652");
    }

    @Override
    public void realizarRetiro(int valor) {
        System.out.println("Se intenta retirar "+valor+" de su cuenta");
    }
}
