public class ConsultaSaldo implements Transaccion{
    @Override
    public void transaccionOk(String cliente) {
        if (cliente.toLowerCase().equals("cobrador") || cliente.toLowerCase().equals("basic") ) {
            System.out.println("Realizando consulta de saldo");
        }else {
            System.out.println("No esta autorizado a realizar esta transaccion");
        }
    }
}
