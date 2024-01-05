import classes.Persona;

public class Main {
    public static void main(String[] args) {
        Persona npc = new Persona();
        Persona juan = new Persona("Juan",22,"2134234");
        Persona sebastian = new Persona("Sebastian",30,"89787689",60,185.4);
        System.out.println(juan);
        System.out.println(sebastian);

        boolean esMayor = sebastian.esMayorDeEdad();
        String umbralEdad = esMayor ? "es mayor de edad" : "Es menor de edad";
        System.out.println(umbralEdad);
        System.out.println("Sebastian: " + sebastian.imc());
    }
}