package practica1;

public class Main {
    public static void main(String[] args) {

        Persona personaVacia = new Persona();
        Persona personaEdadDni = new Persona("Juan", 20, "12345678A");
        Persona personaCompleta = new Persona("Juan", 20, "12345678A", 70, 1.80);

        boolean esMayorDeEdad = personaCompleta.esMayorDeEdad();
        int imc = personaCompleta.calcularIMC();

        if (esMayorDeEdad) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("No es mayor de edad");
        }

        switch (imc) {
            case -1:
                System.out.println("Está por debajo de su peso ideal");
                break;
            case 0:
                System.out.println("Está en su peso ideal");
                break;
            case 1:
                System.out.println("Está por encima de su peso ideal");
                break;
            default:
                System.out.println("No se ha podido calcular el IMC");
                break;
        }

        System.out.println(personaCompleta);

    }
}