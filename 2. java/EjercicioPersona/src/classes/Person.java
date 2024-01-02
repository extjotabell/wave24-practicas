package classes;

public class Person {

    // Attributes
    String name;
    int age;
    String dni;
    int weight;
    double height;

    //Constructors
    public Person() {
    }

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, int age, String dni, int weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public int calculateIMC(){
        double imc = weight/(Math.pow(height,2));
        if(imc < 20){
            return -1;
        }
        else if (imc >= 20 && imc <= 25){
            return 0;
        } else  {
            return 1;
        }

    }

    public boolean isOlder(){
        if(age >= 18){
            return true;
        }else {
            return false;
        }
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
