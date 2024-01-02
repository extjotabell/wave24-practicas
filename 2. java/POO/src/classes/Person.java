package classes;


public class Person {
    String name;
    long age;
    String dni;
    double weight;
    double height;


    public Person(){}

    public Person(String name, long age, String dni){
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, long age, String dni, double weight, double height){
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.height = height;
        this.weight = weight;
    }

    public int calcularIMC(){
        double imc = this.weight / (Math.pow(this.height, 2));
        if(imc < 20){
            return -1;
        }
        if(imc > 25){
            return 1;
        }
        return 0;
    }

    public boolean esMayorDeEdad(){
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
                ", IMC=" + this.calcularIMC() +
                ", Es Mayor De Edad = " + this.esMayorDeEdad() +
                '}';
    }
}
