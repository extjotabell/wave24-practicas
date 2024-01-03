package classes;

import classes.interfaces.Transaction;

public class Basic extends Client {
    public Basic() {
    }

    @Override
    public void doTransaction(Transaction transaction) {
        if (transaction instanceof CheckBalances || transaction instanceof CahsWithdrawal || transaction instanceof PaymentServices){
            transaction.transactionOk();
        } else {
            transaction.transactionNotOk();
        }
    }
}
