package clases;

import interfaces.Transaccion;

public class Basico extends Cliente{
    @Override
    boolean operacionPermitida(Transaccion transaccion) {
        // Basic puede realizar consultas de saldo, pagos de servicios y retiro de efectivo
        return transaccion instanceof ConsultaSaldo || transaccion instanceof PagoServicios || transaccion instanceof RetiroEfectivo;
    }
}
