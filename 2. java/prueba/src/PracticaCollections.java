public class PracticaCollections {

    public static void main(String[] args) {

        Categoria categoriaChica = new CategoriaChica();
        Categoria categoriaMedia = new CategoriaMedia();
        Categoria categoriaAvanzada = new CategoriaAvanzada();

        Participante facu = new Participante("41710054", "Facundo", "Mamani", 15);
        Participante facu2 = new Participante("41710054", "Facundo", "Mamani", 24);

        Inscripcion inscripcion1 = new Inscripcion(1, categoriaMedia, facu);
        Inscripcion inscripcion2 = new Inscripcion(2, categoriaAvanzada, facu2);

    }

}
