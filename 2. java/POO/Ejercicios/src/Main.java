//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.


        Persona persona1 = new Persona();
        Persona persona2 = new Persona("jose", 24, "30000000");
        Persona persona3 = new Persona("juan", "4000000", 30, 90, 1.90 );

        //Desde la clase Main vamos a calcular el IMC de la última persona que creamos
        // (la que creamos correctamente mediante el constructor que recibe todos los atributos
        // como parámetro).
        // También vamos a averiguar si es mayor de edad o no; ten en cuenta que en ambos casos,
        // dependiendo de los resultados retornados por los métodos, debes imprimir
        // un mensaje acorde para el usuario. Finalmente queremos mostrar todos los datos de esa persona
        // imprimiendo dicha información por consola. El formato en que vas a mostrar los datos y los
        // mensajes quedan a tu criterio, pero debe ser legible y descriptivo para quien ve la salida
        // del programa.

        System.out.println(persona3.toString());

        int imc = persona3.calcularIMC();
        switch (imc) {
            case -1:
                System.out.println(persona3.nombre + " tiene Bajo Peso");
                break;
            case 0:
                System.out.println( persona3.nombre + " tiene peso saludable");
                break;

            case 1:
                System.out.println(persona3.nombre + " tiene sobrepeso");
                break;

        }
        if(persona3.esMayorDeEdad()){
            System.out.println("es mayor de edad");
        }
        else{
            System.out.println("es menor de edad");
        }

    }

}