package org.example.classes;

public class SocorristaMoto extends Socorrista<Moto>{
    @Override
    void socorrer(Moto vehiculo) {
        System.out.println("Socorriendo moto patente: "+vehiculo.getPatente());
    }
}
