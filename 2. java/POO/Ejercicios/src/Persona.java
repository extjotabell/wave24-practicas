public class Persona {

    String nombre, dni = "";
    int edad = 0;
    double peso,altura = 0;

    public Persona(String nombre, String dni, int edad, double peso, double altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, int edad, String dni ) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona() {
    }


    //En la clase Persona implementaremos los siguientes métodos: cacularIMC(),
    // la fórmula para calcularlo es: peso/(altura^2) - (peso expresado en kg y altura en mts),
    // si este cálculo devuelve un valor menor que 20, la función debe retornar -1,
    // si devuelve un número entre 20 y 25 inclusive para los dos valores,
    // el método debe retornar un 0, por último, si devuelve un número mayor que 25 debe retornar un 1.
    // Una vez creado el método anterior, agreguemos el método esMayorDeEdad()
    // el cual debe retornar una valor booleano, teniendo en cuenta que
    // la mayoría de edad será considerada en este caso, a partir de los 18 años.
    // Finalmente agregar un método toString() que va a devolver toda la información de la persona.
    //¡Recuerda! Puedes ayudarte de los métodos de la clase java.lang.Math para calcular la potencia.


    public int calcularIMC(){
        double resultado = peso/(altura * altura);
        if(resultado < 20){
            return -1;
        }
        else{
            if(resultado <= 25){
            return 0;}
            else{
                return 1;
            }
        }
    }

    public boolean esMayorDeEdad(){
        if(edad >= 18)
        {return true;}
        else{return false;}
    }

    public String toString(){
        String resultado = "";
        resultado = "nombre:" + nombre + " dni:" + dni + " edad:" + edad + " peso:" + peso + " altura:" + altura;
        return resultado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
}
