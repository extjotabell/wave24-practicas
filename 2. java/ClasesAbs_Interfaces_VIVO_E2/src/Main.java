import clases.Curriculum;
import clases.Informe;
import clases.Persona;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona("Juan", "Perez", 30, "Masculino");

        Curriculum curriculum = new Curriculum(persona, List.of("Java", "Python", "C++"));

        curriculum.imprimir();

        Informe informe = new Informe(persona, persona, "Este es el texto del informe", 10);

        informe.imprimir();



    }
}