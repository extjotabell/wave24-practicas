public class Persona {

    String name;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona(){}

    public Persona(String name, int edad, String dni, double peso, double altura) {
        this.name = name;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String name, int edad, String dni) {
        this.name = name;
        this.edad = edad;
        this.dni = dni;
    }

    public int calcularIMC() {
        int resultado;
        double imc = this.peso/Math.pow(this.altura, 2);
        if(imc < 20) {
            resultado = -1;
        } else if (imc >= 20 && imc <= 25) {
            resultado = 0;
        } else {
            resultado = 1;
        }
        return resultado;
    }

    public boolean esMayorDeEdad(){
        if (this.edad < 18) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
