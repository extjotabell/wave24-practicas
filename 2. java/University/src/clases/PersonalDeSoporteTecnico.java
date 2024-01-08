package clases;

import interfaces.EstudianteTecnico;

public class PersonalDeSoporteTecnico extends MiembroDelPersonal implements EstudianteTecnico {
    private String habilidadesTecnicas;
    private String herramientas;

    public PersonalDeSoporteTecnico(String nombre, String apellido, int edad, String id, String celular, String cargo, double salario,String habilidadesTecnicas,String herramientas) {
        super(nombre, apellido, edad, id, celular, cargo, salario);
        this.habilidadesTecnicas = habilidadesTecnicas;
        this.herramientas = herramientas;
    }

    public String getHabilidadesTecnicas() {
        return habilidadesTecnicas;
    }

    public void setHabilidadesTecnicas(String habilidadesTecnicas) {
        this.habilidadesTecnicas = habilidadesTecnicas;
    }

    public String getHerramientas() {
        return herramientas;
    }

    public void setHerramientas(String herramientas) {
        this.herramientas = herramientas;
    }

    @Override
    public void brindarSoporteTecnico() {
        System.out.println("Estoy brindando soporte tecnico");
    }

    @Override
    public void colaborar() {
        System.out.println("Estoy colaborando");
    }
}
