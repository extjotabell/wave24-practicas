package clases;

public class Persona {
    String nombre;
    int edad;
    String DNI;
    double peso;
    double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String DNI) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
    }

    public Persona(String nombre, int edad, String DNI, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
        this.peso = peso;
        this.altura = altura;
    }

    public int caluclarIMC(){
        double resultado = peso / (Math.pow(altura, 2));
        if (resultado < 20){
            return -1;
        } else if (resultado >= 20 && resultado <=25) {
            return 0;
        }else {
            return 1;
        }
    }

    public Boolean esMayorEdad(){
        if (edad >= 18){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", DNI='" + DNI + '\'' +
                ", peso=" + peso + "KG"+
                ", altura=" + altura +"Mts"+
                '}';
    }
}
