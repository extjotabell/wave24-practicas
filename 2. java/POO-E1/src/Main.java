import clases.Persona;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Laura",23,"12345678");
        Persona persona3 = new Persona("Doris",27,"194082568",57,1.64);

        double imc = persona3.calcularIMC();

        if (persona3.esMayorDeEdad()){
            System.out.println(persona3.nombre + " es mayor de edad.");
        }
        else {
            System.out.println(persona3.nombre + " es menor de edad.");
        }

        if (persona3.calcularIMC() == -1){
            System.out.println("El IMC de " + persona3.nombre + " es "+ persona3.calcularIMC() + ". Tiene bajo peso.");
        }
        else if (persona3.calcularIMC() == 0){
            System.out.println("El IMC de " + persona3.nombre + " es "+ persona3.calcularIMC() + ". Tiene peso saludable.");
        }
        else {
            System.out.println("El IMC de " + persona3.nombre + " es "+ persona3.calcularIMC() + ". Tiene sobre peso.");
        }
    }
}

