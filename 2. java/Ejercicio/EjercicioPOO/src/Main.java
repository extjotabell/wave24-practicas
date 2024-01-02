import classes.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Person person2 = new Person("Jesús", 24, "123456789");
        Person person3 = new Person("David", 24, "123456789", 55.5, 1.76);
        System.out.println(person3.toString());
        int indicateImc = person3.calculateIMC();
        if(indicateImc == -1){
            System.out.println("Estas por debajo de tu peso");
        }
        else if(indicateImc == 0){
            System.out.println("Estas en tu peso ideal");
        }
        else{
            System.out.println("Estas por encima de tu peso");
        }
        boolean isAdult = person3.isAdult();
        if(isAdult){
            System.out.println("Eres mayor de edad");
        }
        else{
            System.out.println("Eres menor de edad");
        }

    }
}