import clases.PersonalDeMantenimiento;
import clases.PersonalDeSoporteTecnico;
import clases.Profesor;

public class Main {
    public static void main(String[] args) {

        Profesor profesor = new Profesor("Tomas", "Gonzalez", 30, "546456645", "4564656767", "Matemáticas");
        PersonalDeMantenimiento mantenimiento = new PersonalDeMantenimiento("Edward", "Perez", 35, "34534545", "435345667", "Edificio A", "Reparaciones");
        PersonalDeSoporteTecnico soporteTecnico = new PersonalDeSoporteTecnico("Daniel", "solano", 40, "2556756", "456454767","Sopote", 300000000.00, "Comunicacion", "Conocimiento");

        System.out.println(profesor.getNombre() + " enseña " + profesor.getAsignatura());
        System.out.println(mantenimiento.getNombre() + " realiza tareas de mantenimiento en " + mantenimiento.getAreasAsignadas());
        System.out.println(soporteTecnico.getNombre() + " tiene habilidades técnicas en " + soporteTecnico.getHabilidadesTecnicas());

        soporteTecnico.brindarSoporteTecnico();
        soporteTecnico.colaborar();
    }
}