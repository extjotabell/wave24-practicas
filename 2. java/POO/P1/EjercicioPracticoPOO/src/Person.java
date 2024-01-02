public class Person {

    //Atributos
    String nombre;
    int edad;
    String dni;
    double peso, altura;
    boolean esMayor;

    int resultadoIMC;

    //Constructores

    public Person(){

    }
    public Person(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    public Person(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    //Metodos
    public void mostrarDatos(){
        System.out.println(nombre+" "+edad+" "+dni+" "+peso+" "+altura);

        System.out.println("el IMC retorna: "+ calcularIMC());
        System.out.println("¿Es mayor de edad?: "+ esMayorDeEdad());
        System.out.println("Toda la info: "+ toString());

    }

    public int calcularIMC(){

        double resultado = (peso / Math.pow(altura, 2));

        if (resultado <20 ){
            return -1;
        } else if (resultado >= 20 && resultado <=25) {
            return 0;
        }else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){

        if (edad < 18){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }

    public void Ejercicio6(){

        resultadoIMC = calcularIMC();
        if (resultadoIMC == -1 ){
            System.out.println("El IMC de "+nombre+" es: Bajo peso.");
        } else if (resultadoIMC >= 20 && resultadoIMC <=25) {
            System.out.println("El IMC de "+nombre+" es: Peso saludable.");
        }else {
            System.out.println("El IMC de "+nombre+" es: Sobrepeso");
        }

        System.out.print("¿Es mayor de edad?: ");
        if (esMayorDeEdad()){
            System.out.println("Sí.");
        }else {
            System.out.println("No.");
        }

        System.out.println("Todos los datos: "+toString());
    }
}
