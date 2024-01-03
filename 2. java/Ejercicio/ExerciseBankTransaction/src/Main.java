import classes.*;

public class Main {
    public static void main(String[] args) {

        Basic basic = new Basic();
        DebtCollector debtCollector = new DebtCollector();
        Executive executive = new Executive();

        CheckBalances checkBalances = new CheckBalances();
        Deposit deposit = new Deposit();
        PaymentServices paymentServices = new PaymentServices();
        CahsWithdrawal cahsWithdrawal = new CahsWithdrawal();
        Transfers transfers = new Transfers();

        basic.doTransaction(checkBalances);
        basic.doTransaction(transfers);

        debtCollector.doTransaction(checkBalances);
        debtCollector.doTransaction(transfers);

        executive.doTransaction(checkBalances);
        executive.doTransaction(transfers);

    }
}