public class Persona {
    private int numParticipante;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numEmergencia;
    private String grupoSanguineo;


    public Persona(int numParticipante, String dni, String nombre, String apellido, int edad, String celular, String numEmergencia, String grupoSanguineo) {
        this.numParticipante = numParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numEmergencia = numEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getNumParticipante() {
        return numParticipante;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
