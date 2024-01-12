public class Banco {
    public static void main(String[] args) {
        Transaccion t = new ConsultaSaldo();
        t.transaccionOk("Ejecutivo");
        t.transaccionOk("baSIC");
        t.transaccionOk("COBRADOR");
    }
}
