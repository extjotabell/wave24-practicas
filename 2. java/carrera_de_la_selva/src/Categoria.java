public class Categoria {
    int precio = 0;
    int precioMenor = 0;
    String nombre = "";
    String descripcion = "";
    boolean aceptaMenores = true;

    public Categoria(String nombre, String descripcion, int precio, int precioMenor, boolean aceptaMenores) {
        this.precio = precio;
        this.precioMenor = precioMenor;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.aceptaMenores = aceptaMenores;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecioMenor() {
        return precioMenor;
    }

    public void setPrecioMenor(int precioMenor) {
        this.precioMenor = precioMenor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isAceptaMenores() {
        return aceptaMenores;
    }

    public void setAceptaMenores(boolean aceptaMenores) {
        this.aceptaMenores = aceptaMenores;
    }
}
