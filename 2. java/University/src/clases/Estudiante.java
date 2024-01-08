package clases;

public class Estudiante extends Persona{
    private String numeroEstudiante;
    private String programaAcademico;

    public Estudiante(String nombre, String apellido, int edad, String id, String celular, String numeroEstudiante, String programaAcademico) {
        super(nombre, apellido, edad, id, celular);
        this.numeroEstudiante = numeroEstudiante;
        this.programaAcademico = programaAcademico;
    }

    public String getNumeroEstudiante() {
        return numeroEstudiante;
    }

    public void setNumeroEstudiante(String numeroEstudiante) {
        this.numeroEstudiante = numeroEstudiante;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }
}
