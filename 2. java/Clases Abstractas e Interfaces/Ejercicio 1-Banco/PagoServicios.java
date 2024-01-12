public class PagoServicios implements Transaccion{
    @Override
    public void transaccionOk(String cliente) {
        if (cliente.toLowerCase().equals("basic") ) {
            System.out.println("Realizando pago servicios");
        }else {
            System.out.println("No esta autorizado a realizar esta transaccion");
        }
    }
}
