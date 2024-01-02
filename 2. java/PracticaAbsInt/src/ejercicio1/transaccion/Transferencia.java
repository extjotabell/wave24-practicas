package ejercicio1.transaccion;

public class Transferencia implements Transaccion {
    @Override
    public void transaccionOK() {

    }

    @Override
    public void transaccionNoOK() {

    }

    @Override
    public void ejecutarTransaccion() {
        System.out.println("Ejecutando Transferencia");
    }
}
