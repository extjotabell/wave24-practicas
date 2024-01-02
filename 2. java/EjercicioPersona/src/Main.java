import classes.Person;

public class Main {
    public static void main(String[] args) {
        Person personNull = new Person();
        Person personSimple = new Person("Gatito", 14, "123456789-k");
        Person personFull = new Person("Gatito", 15, "123456789-k", 54, 1.59);

        System.out.println(personFull.toString());

        if(personFull.calculateIMC() == -1){
            System.out.println("La persona está bajo peso");
        } else if (personFull.calculateIMC() == 0) {
            System.out.println("La persona tiene peso saludable");
        }else {
            System.out.println("La persona está sobrepeso");
        }

        if(personFull.isOlder() == true){
            System.out.println("La persona es mayor de edad");
        }else{
            System.out.println("La persona es menor de edad");
        }
    }


}
