import classes.PracticaExcepciones;

public class MainP1 {
    public static void main(String[] args){

        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();

        try{
            double division = practicaExcepciones.b / practicaExcepciones.a;
        }catch(ArithmeticException exception){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally{
            System.out.println("Programa finalizado.");
        }
    }
}
