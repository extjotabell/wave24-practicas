package classes;

import java.util.List;

public class Curriculum extends Documento{
    private String nombrePersona;
    private String apellidoPersona;
    private List<String> habilidadesPersona;

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

    public Curriculum(String nombrePersona, String apellidoPersona, List<String> habilidadesPersona) {
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.habilidadesPersona = habilidadesPersona;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombrePersona='" + nombrePersona + '\'' +
                ", apellidoPersona='" + apellidoPersona + '\'' +
                ", habilidadesPersona=" + habilidadesPersona +
                '}';
    }
}
