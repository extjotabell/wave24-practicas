package ejercicio1.cliente;

import ejercicio1.transaccion.Transaccion;

public abstract class Cliente {

    public void ejecutarTransaccion(Transaccion transaccion) {
        transaccion.ejecutarTransaccion();
    }
}
