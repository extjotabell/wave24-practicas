package classes;

public class Guitarra extends Instrumento{

    int cantCuerdas;

    public Guitarra(int cantCuerdas, String tipo) {
        super(tipo);
        this.cantCuerdas = cantCuerdas;
    }

    public void tocar(){
        System.out.println("Tocar un/a " + tipo);
    }

}
