package clases;

import interfaces.Transaccion;

public class Cobrador extends Cliente{
    @Override
    boolean operacionPermitida(Transaccion transaccion) {
        return transaccion instanceof RetiroEfectivo || transaccion instanceof ConsultaSaldo;
    }
}

