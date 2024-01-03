package classes;

import classes.interfaces.Transaction;

public class DebtCollector extends Client {
    @Override
    public void doTransaction(Transaction transaction) {

        if (transaction instanceof CheckBalances || transaction instanceof CahsWithdrawal){
            transaction.transactionOk();
        } else {
            transaction.transactionNotOk();
        }
    }
}
