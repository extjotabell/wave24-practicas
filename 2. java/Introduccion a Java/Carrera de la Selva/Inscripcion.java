public class Inscripcion {
    private int numero;
    private String categoria;

    private Persona participante;
    private double montoAbonar;

    public Inscripcion(int numero, String categoria, Persona participante) {
        this.numero = numero;
        this.categoria = categoria;
        this.participante = participante;
    }

    public double calcularMontoAbonar(){
        if (categoria=="chico"){
            montoAbonar = (participante.getEdad()<18)?1300:1500;
        } else if (categoria=="medio") {
            montoAbonar = (participante.getEdad()<18)?2000:2300;
        } else if (categoria=="avanzado") {
            montoAbonar = (participante.getEdad()<18)?-1:2800;
        }else {
            montoAbonar=0;
        }
        return montoAbonar;
    }

    public String getParticipanteName() {
        return participante.getNombre()+" "+participante.getApellido();

}
