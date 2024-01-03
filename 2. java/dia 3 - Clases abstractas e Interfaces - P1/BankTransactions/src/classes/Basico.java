package classes;

import classes.interfaces.Transaccion;

public class Basico extends Cliente{

    @Override
    public void realizarTransaccion(Transaccion transaccion) {

        if(transaccion instanceof ConsultaSaldo || transaccion instanceof RetiroEfectivo || transaccion instanceof PagoServicios){
            transaccion.transaccionOk();
        }else{
            transaccion.transaccionNoOk();
        }

    }
}
