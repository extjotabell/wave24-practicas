package clases;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona(){

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(double peso, double altura){
        double imc;

        imc = peso / Math.pow(altura,2);

        if(imc < 20){
            return  -1;
        } else if (imc >= 20 && imc <= 25) {
            return  0;
        }else if(imc > 25){
            return 1;
        }
        return 0;
    }

    public boolean esMayorDeEdad(int edad){
        if(edad >= 18){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Persona: " +
                "\n- nombre = '" + nombre + '\'' +
                ", \n- edad = " + edad +
                ", \n- dni = '" + dni + '\'' +
                ", \n- peso = " + peso +
                ", \n- altura = " + altura ;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }
}
