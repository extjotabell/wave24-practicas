public class Person {
    String name;
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

    public boolean isOlder() {
        return age>18;
    }

    public int calculateIMC() {
        double imc = weight / Math.pow(height, 2);
        if ( imc<20 )
            return -1;
        else if ( imc>=20 && imc<=25)
            return 0;
        else
            return 1;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Name:" + name +
                "\nAge:" + age +
                "\nDNI:" + dni +
                "\nWeight:" + weight +
                "\nHeight:" + height;
    }
}