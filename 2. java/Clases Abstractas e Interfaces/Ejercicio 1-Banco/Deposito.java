public class Deposito implements Transaccion {
    @Override
    public void transaccionOk(String cliente) {
        if (cliente.toLowerCase().equals("ejecutivo")) {
            System.out.println("Realizando deposito");
        }else {
            System.out.println("No esta autorizado a realizar esta transaccion");
        }
    }
}

