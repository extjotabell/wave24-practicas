import interfaces.Consultar;
import interfaces.Retiro;

public class Crobrador implements Retiro, Consultar{
    @Override
    public void consultar() {
        try {
            System.out.println("Consultando...");
            //TODO: Consultar para cobrador
            transaccionOk();
        } catch (Exception e) {
            transaccionFail();
        }
    }

    @Override
    public void retirar() {
        try {
            System.out.println("Retirar...");
            //TODO: Retirar para cobrador
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
}
