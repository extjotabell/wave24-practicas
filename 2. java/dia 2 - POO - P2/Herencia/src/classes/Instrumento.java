package classes;

public class Instrumento {
    String tipo;

    public Instrumento(String tipo) {
        this.tipo = tipo;
    }

    public void tocar(){
        System.out.println("Tocar un instrumento");
    }
}
