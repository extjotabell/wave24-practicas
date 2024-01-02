public class Main {

    public static void main(String[] args) {

        Person persona1 = new Person();
        Person persona2 = new Person("Juan", 24, "1234");
        Person persona3 = new Person("Felipe", 35, "56789", 80.6, 1.80);
        //Person persona4 = new Person("Juan", 24);

        persona1.mostrarDatos();
        System.out.println("");
        persona2.mostrarDatos();
        System.out.println("");
        persona3.mostrarDatos();
        //persona4.mostrarDatos();

        System.out.println("");
        System.out.println("-----------------------------------");
        persona3.Ejercicio6();

    }
}