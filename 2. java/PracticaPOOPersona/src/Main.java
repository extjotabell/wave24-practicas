import classes.Persona;

public class Main {

    public static void main(String args[] ) {
        //Creacion de personas.
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Santiago", 22, "5860806");
        Persona persona3 = new Persona("Alejandro", 16, "38896632", 75, 1.87);

        //No es posible pasar solamente nombre y edad porque no hay constructor.

        int imc = persona3.calcularIMC();
        Boolean mayorEdad = persona3.esMayorDeEdad();

        //Salida del programa
        System.out.println(persona3.toString());

        if(imc == -1){System.out.println("El IMC de la persona indica que esta en bajo peso ");}
        else if(imc == 0){System.out.println("El IMC de la persona indica que esta en peso normal" );}
        else {System.out.println("El IMC de la persona indica que esta en sobrepeso ");}

        if(mayorEdad){System.out.println("La persona es mayor de edad");}
        else {System.out.println("La persona es menor de edad");}

    }
}
