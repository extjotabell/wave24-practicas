import classes.Basic;
import classes.Cobrador;
import classes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        Ejecutivo ejecutivo = new Ejecutivo();
        Cobrador cobrador = new Cobrador();

        basic.consultarSaldo();
        ejecutivo.depositar();
        cobrador.retirarEfectivo();

        ejecutivo.transaccionOk();
    }
}
