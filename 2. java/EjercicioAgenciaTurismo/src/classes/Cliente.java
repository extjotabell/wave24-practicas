package classes;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String dni;

    public Cliente(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    @Override
    public String toString() {
        return "Cliente: " + dni;
    }
}
