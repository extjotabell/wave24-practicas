import classes.Person;

public class Main {
    public static void main(String[] args) {
        Person personNull = new Person();
        Person personSimple = new Person("Gatito", 14, "123456789-k");
        Person personFull = new Person("Gatito", 14, "123456789-k", 6, 0.5);
    }
}
