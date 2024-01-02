import clases.Persona;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan",18,"1A2B3C");
        Persona persona3 = new Persona("Jhon", 16, "4D5E6F",65,1.78);

        System.out.println(persona3);;

        if (persona3.caluclarIMC() == -1){
            System.out.println("bajo peso");
        }else if(persona3.caluclarIMC() == 0){
            System.out.println("peso sauldable");
        }else {
            System.out.println("sobrepeso");
        }

        if (persona3.esMayorEdad()){
            System.out.println("es mayor de edad ");
        }else {
            System.out.println("es menor de edad");
        };
    }
}
