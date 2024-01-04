package agenciadeviajes;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {
    private List<Cliente> elementos;

    public RepositorioCliente(List<Cliente> elementos) {
        this.elementos = elementos;
    }

    public RepositorioCliente() {
        this.elementos = new ArrayList<>();
    }

    public List<Cliente> getElementos() {
        return elementos;
    }

    public void agregar(Cliente elemento) {
        this.elementos.add(elemento);
    }
}
