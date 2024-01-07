// Clase principal que representa el escenario
public class Main {
    public static void main(String[] args) {
        // Crear instancias de cada tipo de documento
        Curriculum curriculum = new Curriculum("Juan Pérez", 25, "Calle 123", new String[]{"Programación", "Inglés"});
        LibroPDF libroPDF = new LibroPDF(300, "Autor Anónimo", "Mi Libro", "Ficción");
        Informe informe = new Informe("Contenido del informe...", 10, "Dr. Investigador", "Revisor Experto");

        // Imprimir los documentos utilizando el método estático de la interfaz Imprimible
        Imprimible.imprimirDocumento(curriculum);
        Imprimible.imprimirDocumento(libroPDF);
        Imprimible.imprimirDocumento(informe);
    }
}
