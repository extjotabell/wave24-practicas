package classes;

public class Person {
    String name;
    int age;
    String dni;
    long weight;
    long height;

    public Person() {}

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public int calculateBMI() {
        try {
            double bmi = this.weight / Math.pow(2, this.height);

            if (bmi < 20) return -1;
            else if (bmi < 25) return 0;
            
            return 1;
        } catch (ArithmeticException e) {
            System.out.println("Your height cannot be zero!");

            return -2;  
        }
    }

    public boolean hasFullAge() {
        return this.age >= 18;
    }

    @Override
    public String toString() {
        return "Name: " 
            + this.name 
            + "\nAge: " 
            + this.age 
            + "\nDNI: " 
            + this.dni;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public void setHeight(long height) {
        this.height = height;
    }
}
