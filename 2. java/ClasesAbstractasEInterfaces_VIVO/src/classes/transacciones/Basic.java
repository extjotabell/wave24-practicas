package classes.transacciones;

import classes.transacciones.interfaces.ConsultaSaldo;
import classes.transacciones.interfaces.PagoServicio;
import classes.transacciones.interfaces.Retiro;

public class Basic implements ConsultaSaldo, PagoServicio, Retiro {

    @Override
    public void TransaccionOk() {
        System.out.println("Transaccion exitosa para Cliente basic");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("Fallida exitosa para Cliente basic");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("su saldo es de 12345652");
    }

    @Override
    public void realizarPagoServicio(String servicio) {
        System.out.println("Pago de servicio: " +servicio+" iniciado.");

    }

    @Override
    public void realizarRetiro(int valor) {
        System.out.println("Se intenta retirar "+valor+" de su cuenta");
    }
}
