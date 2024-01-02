public class Main {
    public static void main(String[] args) {

        Libro libro = new Libro("100 años de soledad", "Gabriel García Marquez", 100000);
        System.out.println(libro.mostrarLibro());
        System.out.println("La cantidad de libros es: " + libro.cantidadDeEjemplares());

    }
}