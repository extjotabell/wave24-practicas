import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona(1, "1234568","Laura", "Gordillo", 24, "3111111111", "3222222222", "O+");
        Persona persona2 = new Persona(2, "1234560","Juan", "Perez", 17, "3111511111", "3222522222", "O+");
        Persona persona3 = new Persona(3, "1233568","David", "Ramirez", 14, "211111111", "2222222222", "A+");
        Persona persona4 = new Persona(4, "1234538","Pepita", "Diaz", 10, "5111111111", "5222272222", "A-");
        Persona persona5 = new Persona(5, "1234368","Luis", "Comun", 34, "6111111111", "622222222", "O-");
        Persona persona6 = new Persona(6, "1233568","Jean", "Cardo", 60, "7111111111", "722222222", "AB");

        ArrayList<Inscripcion> inscripciones=new ArrayList<Inscripcion>();
        inscripciones.add(new Inscripcion(1, "chico", persona1));
        inscripciones.add(new Inscripcion(2, "chico", persona2));
        inscripciones.add(new Inscripcion(3, "medio", persona3));
        inscripciones.add(new Inscripcion(4, "medio", persona4));
        inscripciones.add(new Inscripcion(5, "avanzado", persona5));
        inscripciones.add(new Inscripcion(6, "avanzado", persona6));



        for (int i = 0; i < 6; i++) {
            System.out.println("Monto a abonar para  "+inscripciones.get(i).getParticipanteName()+": "+inscripciones.get(i).calcularMontoAbonar());
        }




    }
}
