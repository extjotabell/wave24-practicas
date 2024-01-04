package ejerciciouno.classes;

import ejerciciouno.classes.interfaces.Transaction;

public class Basico extends Client {

    @Override
    public boolean realizarTransaction(Transaction transaction) {
        if(!(transaction instanceof ConsultaSaldo) && !(transaction instanceof PagoServicios) && !(transaction instanceof RetiroEnEfectivo)){
            return transaction.transactionNoOk();
        }

        return transaction.transactionOk();
    }
}
