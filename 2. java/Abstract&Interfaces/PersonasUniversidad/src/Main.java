import classes.Estudiante;
import classes.EstudianteTecnico;
import classes.PersonalDeMantenimiento;
import classes.Profesor;

public class Main {
    public static void main(String[] args) {

        Profesor profesor1 = new Profesor("Juan", "Perez", 31, 1234);
        System.out.println(profesor1.toString());
        System.out.println(profesor1.actividad());

        System.out.println("");
        Estudiante estudiante1 = new EstudianteTecnico("Carlos", "Rodriguez", 21, 100098 );
        System.out.println(estudiante1.toString());
        System.out.println(estudiante1.actividad());

        System.out.println("");
        PersonalDeMantenimiento mantenimiento1 = new PersonalDeMantenimiento("Jose", "Hernandez", 42, 961020, 1750.43);
        System.out.println(mantenimiento1.toString());
        System.out.println(mantenimiento1.actividad());


    }
}