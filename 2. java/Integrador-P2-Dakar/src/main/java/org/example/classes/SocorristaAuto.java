package org.example.classes;

public class SocorristaAuto extends Socorrista<Auto>{
    @Override
    void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo auto patente: "+vehiculo.getPatente());
    }

}
