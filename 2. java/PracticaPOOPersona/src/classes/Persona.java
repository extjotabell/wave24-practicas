package classes;

public class Persona {

    //Declaracion de variables
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    /*
    * Vamos a crear diferentes constructores en la clase classes.Persona, uno sin parámetros,
    * el segundo debe recibir como parámetro nombre, edad y dni;
    * por último creamos un tercero que reciba todos los atributos de la clase como parámetro.
    */

    public Persona(){

    }

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = peso/(Math.pow(altura, 2));
        if (imc<20){
            return -1;
        }
        else if(imc >=20 && imc<=25){
            return 0;
        }
        else return 1;
    }

    public Boolean esMayorDeEdad(){
        if(edad>=18) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Nombre='" + nombre + '\'' +
                ", Edad=" + edad +
                ", DNI='" + dni + '\'' +
                ", Peso=" + peso +
                ", Altura=" + altura +
                '}';
    }
}
