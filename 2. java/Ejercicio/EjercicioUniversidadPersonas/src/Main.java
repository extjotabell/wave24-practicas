import classes.Profesores;

public class Main {
    public static void main(String[] args) {

        // Crear un objeto de la clase Profesores
        Profesores profesor = new Profesores("John", "Doe", "123456789", 30);
        System.out.println(profesor.tareas());
    }
}