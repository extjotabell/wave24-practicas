public class Categoria {

  private String Nombre;
  private  int distancia;
  private String descripcion;
  private int precioMenores;
  private int precioMayores;

    public Categoria(String nombre, int distancia, String descripcion, int precioMenores, int precioMayores) {
        Nombre = nombre;
        this.distancia = distancia;
        this.descripcion = descripcion;
        this.precioMenores = precioMenores;
        this.precioMayores = precioMayores;
    }

    public Categoria() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecioMenores() {
        return precioMenores;
    }

    public void setPrecioMenores(int precioMenores) {
        this.precioMenores = precioMenores;
    }

    public int getPrecioMayores() {
        return precioMayores;
    }

    public void setPrecioMayores(int precioMayores) {
        this.precioMayores = precioMayores;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "Nombre='" + Nombre + '\'' +
                ", distancia=" + distancia +
                ", descripcion='" + descripcion + '\'' +
                ", precioMenores=" + precioMenores +
                ", precioMayores=" + precioMayores +
                '}';
    }


}
