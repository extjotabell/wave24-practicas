// Definición de la interfaz Imprimible
public interface Imprimible {
    // Método estático para imprimir cualquier tipo de documento
    static void imprimirDocumento(Documento documento) {
        System.out.println(documento.obtenerContenidoParaImpresion());
    }
}

// Clase principal que representa un documento
abstract class Documento {
    // Atributo común a todos los documentos
    protected String contenido;

    // Constructor
    public Documento(String contenido) {
        this.contenido = contenido;
    }

    // Método abstracto para obtener el contenido específico de cada tipo de documento
    public abstract String obtenerContenidoParaImpresion();
}

// Clase Curriculum que hereda de Documento
class Curriculum extends Documento {
    // Atributos adicionales específicos de Curriculum
    private String nombre;
    private int edad;
    private String direccion;
    private String[] habilidades;

    // Constructor
    public Curriculum(String nombre, int edad, String direccion, String[] habilidades) {
        super("");
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.habilidades = habilidades;
    }

    // Método para obtener el contenido específico de Curriculum
    @Override
    public String obtenerContenidoParaImpresion() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Curriculum:\n");
        resultado.append("Nombre: ").append(nombre).append("\n");
        resultado.append("Edad: ").append(edad).append("\n");
        resultado.append("Dirección: ").append(direccion).append("\n");
        resultado.append("Habilidades: ").append(String.join(", ", habilidades)).append("\n");
        return resultado.toString();
    }
}

// Clase LibroPDF que hereda de Documento
class LibroPDF extends Documento {
    // Atributos adicionales específicos de LibroPDF
    private int cantidadDePaginas;
    private String autor;
    private String titulo;
    private String genero;

    // Constructor
    public LibroPDF(int cantidadDePaginas, String autor, String titulo, String genero) {
        super("");
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    // Método para obtener el contenido específico de LibroPDF
    @Override
    public String obtenerContenidoParaImpresion() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Libro en PDF:\n");
        resultado.append("Título: ").append(titulo).append("\n");
        resultado.append("Autor: ").append(autor).append("\n");
        resultado.append("Género: ").append(genero).append("\n");
        resultado.append("Cantidad de páginas: ").append(cantidadDePaginas).append("\n");
        return resultado.toString();
    }
}

// Clase Informe que hereda de Documento
class Informe extends Documento {
    // Atributos adicionales específicos de Informe
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    // Constructor
    public Informe(String contenido, int cantidadDePaginas, String autor, String revisor) {
        super(contenido);
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    // Método para obtener el contenido específico de Informe
    @Override
    public String obtenerContenidoParaImpresion() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Informe:\n");
        resultado.append("Autor: ").append(autor).append("\n");
        resultado.append("Revisor: ").append(revisor).append("\n");
        resultado.append("Cantidad de páginas: ").append(cantidadDePaginas).append("\n");
        resultado.append("Contenido:\n").append(contenido).append("\n");
        return resultado.toString();
    }
}
