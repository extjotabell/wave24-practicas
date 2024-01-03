//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Persona persona1 = new Persona();
    Persona persona2 = new Persona("Laura Gordillo", 24, "123456789");
    Persona persona3 = new Persona("Juan Perez", 23, "098654321", 48.5, 1.63);

    //Error solo usar Nombre y Edad Persona persona4 = new Persona("David Lopez", 22);
    System.out.println(persona3.toStringPersona());
    switch (persona3.calcularIMC()){
        case -1:
            System.out.println("Bajo de peso");
            break;
        case 0:
            System.out.println("Peso saludable");
            break;
        case 1:
            System.out.println("Sobrepeso");
            break;
    }
    if(persona3.esMayorDeEdad()){
        System.out.println("Es mayor de edad");
    }else {
        System.out.println("Es menor de edad");
    }
    }
}