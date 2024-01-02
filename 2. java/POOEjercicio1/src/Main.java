import clases.Persona;

public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Pablo", 34, "33247654");
        Persona persona3 = new Persona("Maria", 17, "40382968", 50, 1.55);

        int imc3 = persona3.calcularIMC(persona3.getPeso(), persona3.getAltura());
        if (imc3 == -1){
            System.out.println(persona3.getNombre() +" tiene bajo peso.");
        } else if (imc3 == 0) {
            System.out.println(persona3.getNombre() + " tiene un peso saludable.");
        }else {
            System.out.println(persona3.getNombre() + " tiene sobrepeso.");
        }

        boolean esMayor3 = persona3.esMayorDeEdad(persona3.getEdad());
        if(esMayor3 == true){
            System.out.println(persona3.getNombre() + " es mayor de edad.");
        }else {
            System.out.println(persona3.getNombre() + " es menor de edad.");
        }

        System.out.println(persona3.toString());
    }
}