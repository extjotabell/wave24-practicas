package classes;

import classes.interfaces.Transaction;

public class Executive extends Client {
    @Override
    public void doTransaction(Transaction transaction) {
        if (transaction instanceof Deposit || transaction instanceof Transfers){
            transaction.transactionOk();
        } else {
            transaction.transactionNotOk();
        }
    }
}
