package Variables;

import javax.swing.*;
import java.util.Locale;

public class Variables {
    public static void main(String[] args) {

        String saludar = "Hola ander";
        System.out.println(saludar.toUpperCase());

        //tipos de datos  primitivos Int, reoresentan un valor , escalables byte
        int n = 12;
        Integer numero = 10;//trabajar se llaman envoltorios

        var nombre = "Anderson Pedroza "; //asume valor priitivo
        byte numByte = 127;
        System.out.println(numByte);


        float realFloat = 0.00000000015f;
        System.out.println(realFloat);
        System.out.println(Float.BYTES);
        System.out.println(Float.SIZE);

        char letra = 'l';
        System.out.println(letra);

        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad"));
        JOptionPane.showMessageDialog(null, "tu edad es "+ edad);

    }
}
