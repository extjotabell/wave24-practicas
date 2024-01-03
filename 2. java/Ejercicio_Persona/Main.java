package Ejercicio_Persona;

public class Main {
    public static void main(String[] args) {

        Persona p1 = new Persona("12345678", "Dani", 16);
        Persona p2 = new Persona();
        Persona p3 = new Persona("98765432", "Mel", 26, 50.1,1.53);

        int imc = p3.calcularIMC();
        String message = p3.esMayorDeEdad() ? "Es mayor de edad" : "No es mayor de edad";
        System.out.println(p3);
        System.out.println(message);
        System.out.print("Nivel de peso es: " );

        switch (imc) {
            case -1:
                System.out.println("Bajo Peso");
                break;
            case 0:
                System.out.println("Peso Saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
        }
    }
}
