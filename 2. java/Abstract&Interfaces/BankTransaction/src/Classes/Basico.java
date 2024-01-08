package Classes;

import Classes.Interfaces.Transaccion;

public class Basico extends Cliente{


    @Override
    public void realizarTransaccion(Transaccion transaccion) {

        if(transaccion instanceof ConsultarSaldo || transaccion instanceof PagoServicios || transaccion instanceof RetiroEfectivo){
            transaccion.TransaccionOk();
        }else{
            transaccion.TransaccionNoOk();
        }
    }
}
