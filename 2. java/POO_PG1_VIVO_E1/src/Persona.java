public class Persona {
    private String name;
    private int age;
    private String dni;
    private double weight;
    private double height;

    public Persona() {
    }

    public Persona(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;

    }

    public Persona(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }
    public int calculateIMC(){
        double IMC = this.weight/(Math.pow(this.height,2));

        if(IMC < 20){
            return -1;
        } else if (20 <= IMC && IMC <= 25) {
            return 0;
        } else {
            return 1;
        }
    }
    public boolean overLegalAge(){
        return this.age >=  18;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}