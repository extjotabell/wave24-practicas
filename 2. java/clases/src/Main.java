public class Main {
    public static void main(String[] args) {

        Person person1 = new Person();


        Person person2 = new Person("Diego Pachón", 11, "453453");


        Person person3 = new Person("Natalia Sanabria", 30, "45645645", 65.0, 1.75);

        //Person person4 = new Person("Fernando Alavarez",22);


        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println("");
        int bmiResult = person3.calculateIMC();
        boolean isLegalAge = person3.isLegalAge();
        System.out.println("Información de la persona:");
        System.out.println(person3);
        System.out.println("\nResultados:");
        System.out.println("IMC: " + bmiResult);
        if (bmiResult == -1) {
            System.out.println("Nivel de peso: Bajo peso");
        } else if (bmiResult == 0) {
            System.out.println("Nivel de peso: Peso saludable");
        } else {
            System.out.println("Nivel de peso: Sobrepeso");
        }

        System.out.println("Es mayor de edad: " + isLegalAge);
    }
}