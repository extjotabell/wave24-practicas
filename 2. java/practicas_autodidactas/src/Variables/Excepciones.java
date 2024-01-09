package Variables;

import javax.swing.*;

public class Excepciones {
    public static void main(String[] args) {

        try{
            var numero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un numero"));
            System.out.println(10/numero);

        }catch(NumberFormatException e) {
            System.out.println(e);
            //e.printStackTrace();
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }

        //2 clases de excepcion
        //checket try catch(obligan a usarse en tiempo de ejecucion se puede recuperar del error )   and uncheked runtime exception (ocurenen errores del sistema  Error trwo )
        //throw lanzar excepciones personalzdas
    }
}
