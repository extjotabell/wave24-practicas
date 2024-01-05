package classes.documentos;

import classes.documentos.interfaces.Imprimible;

public class Curriculum extends Documento{
    private Person persona;
    private String habilidades;

    public Curriculum(Person persona, String habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }



    public Person getPersona() {
        return persona;
    }

    public void setPersona(Person persona) {
        this.persona = persona;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimirme() {
        imprimirPerDocument();
        System.out.println(
                "persona=" + persona +
                ", habilidades='" + habilidades + '\'' );
    }
    @Override
    public String toString() {
        return "Curriculum{" +
                "persona=" + persona +
                ", habilidades='" + habilidades + '\'' +
                '}';
    }
}
