package classes.transacciones;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Basic clienteBasico= new Basic();
        Cobrador clienteCobrador= new Cobrador();
        Ejecutivo clienteEjecutivo=new Ejecutivo();
        System.out.println("cliente basico:");
        clienteBasico.consultarSaldo();
        clienteBasico.TransaccionNoOk();
        clienteBasico.realizarRetiro(123154);
        clienteBasico.TransaccionNoOk();
        clienteBasico.realizarPagoServicio("Internet");
        clienteBasico.TransaccionOk();
        System.out.println("cliente cobrador:");
        clienteCobrador.consultarSaldo();
        clienteCobrador.TransaccionOk();
        clienteCobrador.realizarRetiro(121213);
        clienteCobrador.TransaccionNoOk();
        System.out.println("cliente ejecutivo:");
        clienteEjecutivo.depositarDinero(12131);
        clienteEjecutivo.TransaccionOk();
        clienteEjecutivo.hacerTransferencia(121321);
        clienteEjecutivo.TransaccionNoOk();
    }
}