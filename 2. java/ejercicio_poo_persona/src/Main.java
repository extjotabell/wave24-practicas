public class Main {
    public static void main(String[] args) {
        Persona personaVacia = new Persona();
        Persona victoria = new Persona("Victoria", 26, "12345678");
        Persona mickey = new Persona("Mickey Mouse", 100, "1", 3, 0.4f);
        //System.out.println(personaVacia.nombre + "\n" + victoria.nombre + "\n" + mickey.nombre);
        System.out.println("Esta persona tiene " + mickey.mostrarIMC() + ".");
        System.out.println(mickey.esMayorDeEdad()? "Esta persona es mayor de edad." : "Esta persona no es mayor de edad.");
        System.out.println(mickey.toString());
    }
}
