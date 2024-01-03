package clases;

import interfaces.Documento;

import java.util.List;

public class Curriculum implements Documento {

    private Persona persona;

    private List<String> habilidades;

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public Curriculum() {
    }

    @Override
    public void imprimir() {
        System.out.println(persona.toString() + " " + habilidades.toString());
    }

    public void agregarHabilidad(String habilidad){
        this.habilidades.add(habilidad);
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
