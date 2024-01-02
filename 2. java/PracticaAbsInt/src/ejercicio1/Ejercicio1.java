package ejercicio1;

import ejercicio1.cliente.Cliente;
import ejercicio1.cliente.Ejecutivo;
import ejercicio1.transaccion.Deposito;
import ejercicio1.transaccion.Transaccion;

public class Ejercicio1 {

    public static void main(String[] args) {
        Cliente cliente = new Ejecutivo();
        Transaccion deposito = new Deposito();
        cliente.ejecutarTransaccion(deposito);

    }

}
