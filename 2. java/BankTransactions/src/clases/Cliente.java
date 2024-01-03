package clases;

import interfaces.Transaccion;

public class Cliente {

    public void realizarTransaccion (Transaccion transaccion) {
        System.out.println("Iniciando proceso de transacción...");

        if (operacionPermitida(transaccion)) {
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }

        System.out.println("Finalizando proceso de transacción...");
    }

    boolean operacionPermitida(Transaccion transaccion) {
        return true;
    }
}
