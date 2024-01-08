package Classes;

import Classes.Interfaces.Transaccion;

public class Ejecutivo extends Cliente{


    @Override
    public void realizarTransaccion(Transaccion transaccion) {

        if(transaccion instanceof Deposito || transaccion instanceof Transferencia){
            transaccion.TransaccionOk();
        }else{
            transaccion.TransaccionNoOk();
        }
    }
}
