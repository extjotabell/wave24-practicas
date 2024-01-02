package ejercicio1.cliente;

import ejercicio1.transaccion.Transaccion;

public class Basic extends Cliente{

    @Override
    public void ejecutarTransaccion(Transaccion transaccion) {
        System.out.println("Ejecutando transaccion de cliente Basic");
        super.ejecutarTransaccion(transaccion);
    }
}
