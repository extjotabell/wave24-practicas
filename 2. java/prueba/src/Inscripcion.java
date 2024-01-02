public class Inscripcion {

    int numero;
    Categoria categoria;
    Participante participante;
    double montoAAbonar;

    public Inscripcion(int numero, Categoria categoria, Participante participante) {
        this.numero = numero;
        this.categoria = categoria;
        this.participante = participante;
        try{
            this.montoAAbonar = categoria.obtenerMonto(participante.getEdad());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       }

}
