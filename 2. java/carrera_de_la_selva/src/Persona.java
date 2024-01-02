public class Persona {
    int id = 0;
    int edad = 0;
    String rut, nombre, apellido, numCelular, numEmergencia, tipoSangre, tipoCircuito = "";

    public Persona(int id, String rut, String nombre, String apellido, int edad, String numCelular, String numEmergencia, String tipoSangre, String tipoCircuito) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.numCelular = numCelular;
        this.numEmergencia = numEmergencia;
        this.tipoSangre = tipoSangre;
        this.tipoCircuito = tipoCircuito;
    }

    public Persona() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }

    public String getNumEmergencia() {
        return numEmergencia;
    }

    public void setNumEmergencia(String numEmergencia) {
        this.numEmergencia = numEmergencia;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getTipoCircuito() {
        return tipoCircuito;
    }

    public void setTipoCircuito(String tipoCircuito) {
        this.tipoCircuito = tipoCircuito;
    }
}
