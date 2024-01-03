import interfaces.Consultar;
import interfaces.PagoServicios;
import interfaces.Retiro;

public class Basic implements Consultar, PagoServicios, Retiro{
    @Override
    public void consultar() {
        try {
            System.out.println("Consultando...");
            //TODO: Consultar para basic
            transaccionOk();
        } catch (Exception e) {
            transaccionFail();
        }
    }

    @Override
    public void pagarServicio() {
        try {
            System.out.println("Pagando servicio...");
            //TODO: Pagar servicio para basic
            transaccionOk();
        } catch (Exception e) {
            transaccionFail();
        }
    }

    @Override
    public void retirar() {
        try {
            System.out.println("Retirando...");
            //TODO: Retirar para basic
            transaccionOk();
        } catch (Exception e) {
            transaccionFail();
        }
    }

    @Override
    public Boolean transaccionOk() {
        System.out.println("Transacción exitosa");
        //TODO: Acciones de transaccion existosa
        return true;
    }

    @Override
    public Boolean transaccionFail() {
        System.out.println("Transacción fallida");
        //TODO: Acciones de transaccion fallida
        return false;
    }
}
