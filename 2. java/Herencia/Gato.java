public class Gato extends Animal {

    String nombre; 

    //herencia 
    public Gato(String especie, String nombre) {
        super(especie);
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //polimorfismo 
    @Override
    public void mostrarEspecie() {
       super.mostrarEspecie(); //SUPERCLASE 
       System.out.println("Soy una gato " + this.nombre);
    }
    
    @Override
    public void hacerSonido() {
        System.out.println("El gato hace MIAU");
    }

    

}