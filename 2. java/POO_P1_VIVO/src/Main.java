//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person genericPerson = new Person();
        Person semiRegisteredPerson = new Person("juan camilo zapata macias",25,"1017253800");
        Person fullyRegisteredPerson= new Person("juan camilo zapata macias",25,"1017253800",74.5,1.67);
        System.out.println(genericPerson);
        System.out.println(semiRegisteredPerson);
        System.out.println(fullyRegisteredPerson);
        System.out.println(fullyRegisteredPerson.overLegalAge()?"The person is over legal age":"The person is under legal age");
        int IMC=fullyRegisteredPerson.calculateIMC();
        System.out.println(IMC==-1?"The person is underweight":IMC==0?"The person has a healthy weight":"The person if overweight");
    }
}