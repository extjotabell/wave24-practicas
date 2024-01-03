
public class Main {
    public static void main(String[] args) {
        Persona genericPerson = new Persona();
        Persona semiRegisteredPerson = new Persona("Ignacio",21,"1234567");
        Persona fullyRegisteredPerson= new Persona("Pedro",25,"1234545",74.5,1.67);

        System.out.println(genericPerson);
        System.out.println(semiRegisteredPerson);
        System.out.println(fullyRegisteredPerson);
        System.out.println(fullyRegisteredPerson.overLegalAge()
                ? "The person is over legal age"
                : "The person is under legal age");

        int IMC = fullyRegisteredPerson.calculateIMC();

        if (IMC == -1){
            System.out.println("The person is underweight");
        } else if (IMC == 0){
            System.out.println("The person has a healthy weight");
        } else {
            System.out.println("The person if overweight");
        }
    }
}