package Classes;

import Classes.Interfaces.Transaccion;

public class Cobrador extends Cliente {


    @Override
    public void realizarTransaccion(Transaccion transaccion) {

        if(transaccion instanceof RetiroEfectivo) {
            transaccion.TransaccionOk();
        }else if (transaccion instanceof PagoServicios){
            transaccion.TransaccionOk();
        }else {
            transaccion.TransaccionNoOk();
        }
    }
}
