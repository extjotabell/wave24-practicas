import classes.Basic;
import classes.Cobrador;
import classes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo("Jhon", "Smith", "SMITHxxx");
        Basic basic = new Basic("Marcos", "Anzurez", "ANZxxx");
        Cobrador cobrador = new Cobrador("Richard", "Parker", "PARKERxxx");

        ejecutivo.depositar();
        ejecutivo.tranferir();
        ejecutivo.transaccionOk();

        basic.consultarSaldo();
        basic.retirarEfectivo();
        basic.pagarServicio();
        basic.transaccionOk();

        cobrador.consultarSaldo();
        cobrador.retirarEfectivo();
        cobrador.transaccionNoOk();
    }
}