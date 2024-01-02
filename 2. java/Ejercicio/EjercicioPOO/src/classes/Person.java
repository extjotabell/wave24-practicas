package classes;

public class Person {

    public String name;
    int age;
    String dni;
    double weight;

    double height;

    public Person() {
    }

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public int calculateIMC() {
        double imc = this.weight / (this.height * this.height);
        if (imc < 20) {
            return -1;
        }
        else if (imc >= 20 && imc <= 25){
                return 0;
        }
        else{
                return 1;
        }
    }

    public boolean isAdult(){
        return this.age >= 18;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dni='" + dni + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}


