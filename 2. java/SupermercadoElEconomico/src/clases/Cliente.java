package clases;

public class Cliente {

    int dni;
    String nombreCliente;
    String apellidoCliente;

    public Cliente(int dni, String nombreCliente, String apellidoCliente) {
        this.dni = dni;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "\ndni='" + dni + '\'' +
                ", \nnombreCliente='" + nombreCliente + '\'' +
                ", \napellidoCliente='" + apellidoCliente + '\'' +
                '}' + "\n----------------------------";
    }
}
