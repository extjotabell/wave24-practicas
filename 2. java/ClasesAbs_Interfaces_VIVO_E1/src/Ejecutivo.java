import interfaces.Deposito;
import interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void depositar() {
        try {
            System.out.println("Depositando...");
            //TODO: Implementar lógica de deposito
            transaccionOk();
        } catch (Exception e) {
            transaccionFail();
        }
    }

    @Override
    public Boolean transaccionOk() {
        return null;
    }

    @Override
    public Boolean transaccionFail() {
        return null;
    }

    @Override
    public void transferir() {
        try {
            System.out.println("Transferiendo...");
            //TODO: Implementar lógica de transferencia
            transaccionOk();
        } catch (Exception e) {
            transaccionFail();
        }

    }
}
