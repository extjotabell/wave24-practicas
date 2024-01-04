package ejerciciodos.classes;

import java.util.Arrays;
import java.util.List;

public class Curriculum extends Documento {
    private String persona;
    private String[] habilidades;

    public Curriculum(String persona, String[] habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona='" + persona + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }

    @Override
    public void mostrarContenido() {
        System.out.println(persona + " " + Arrays.toString(habilidades));
    }
}
