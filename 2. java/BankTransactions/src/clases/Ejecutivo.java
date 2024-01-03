package clases;

import interfaces.Transaccion;

public class Ejecutivo extends Cliente{
    @Override
    boolean operacionPermitida(Transaccion transaccion) {

        return transaccion instanceof Deposito || transaccion instanceof Transferencia;
    }

}
