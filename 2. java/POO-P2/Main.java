public class Main {
    public static void main(String[] args) {
        Person personWithoutParams = new Person();
        Person personWithTwoParams = new Person("Marcos", 26, "ABCD123");
        Person personWithAllParams = new Person("Marcos", 26, "ABCD123", 91.7, 1.83);

        int imc = personWithAllParams.calculateIMC();
        String message = personWithAllParams.isOlder() ? "Es mayor de edad" : "No es mayor de edad";
        System.out.println(personWithAllParams.toString());
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