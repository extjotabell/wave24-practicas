package classes;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private List<Localizador> localizadores;

    public Cliente() {
    }

    public Cliente(String nombreCliente) {
        this.nombre = nombreCliente;
        this.localizadores = new ArrayList<>();
    }

    public void agregarLocalizador(Localizador localizador){
        localizador.setDescuento(obtenerDescuento());
        localizadores.add(localizador);
    }

    public double obtenerDescuento(){
        return localizadores.size() > 2 ? 0.05 : 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }
}
