import ejerciciouno.classes.*;

public class Main {
    public static void main(String[] args){
        Basico basico = new Basico();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();

        basico.realizarTransaction(new Transferencia());
        cobrador.realizarTransaction(new RetiroEnEfectivo());
        ejecutivo.realizarTransaction(new Transferencia());
    }
}
