package Variables;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vuelo {
    private String nombre;
    private String origen;
    private String destino;
    private Date fecha;
    private int pasajeros;

    public Vuelo(String nombre, String origen, String destino, Date fecha, int pasajeros) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.pasajeros = pasajeros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "nombre='" + nombre + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", fecha=" + fecha +
                ", pasajeros=" + pasajeros +
                '}';
    }

    public static void main(String[] args) throws ParseException {

        List<Vuelo> llegadas = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");

        llegadas.add(new Vuelo("AAL 933", "New York", "Santiago", df.parse("2021-08-29 05:39"), 62));
        llegadas.add(new Vuelo("LAT 755", "Sao Paulo", "Santiago", df.parse("2021-08-31 04:45"), 47));
        llegadas.add(new Vuelo("SKU 621", "Rio De Janeiro", "Santiago", df.parse("2021-08-30 16:00"), 52));
        llegadas.add(new Vuelo("DAL 147", "Atlanta", "Santiago", df.parse("2021-08-29 13:22"), 59));
        llegadas.add(new Vuelo("AVA 241", "Bogota", "Santiago", df.parse("2021-08-31 14:05"), 25));
        llegadas.add(new Vuelo("AMX 10", "Mexico City", "Santiago", df.parse("2021-08-31 05:20"), 29));
        llegadas.add(new Vuelo("IBE 6833", "Londres", "Santiago", df.parse("2021-08-30 08:45"), 55));
        llegadas.add(new Vuelo("LAT 2479", "Frankfurt", "Santiago", df.parse("2021-08-29 07:41"), 51));
        llegadas.add(new Vuelo("SKU 803", "Lima", "Santiago", df.parse("2021-08-30 10:35"), 48));
        llegadas.add(new Vuelo("LAT 533", "Los Ángeles", "Santiago", df.parse("2021-08-29 09:14"), 59));
        llegadas.add(new Vuelo("LAT 1447", "Guayaquil", "Santiago", df.parse("2021-08-31 08:33"), 31));
        llegadas.add(new Vuelo("CMP 111", "Panama City", "Santiago", df.parse("2021-08-31 15:15"), 29));
        llegadas.add(new Vuelo("LAT 705", "Madrid", "Santiago", df.parse("2021-08-30 08:14"), 47));
        llegadas.add(new Vuelo("AAL 957", "Miami", "Santiago", df.parse("2021-08-29 22:53"), 60));
        llegadas.add(new Vuelo("ARG 5091", "Buenos Aires", "Santiago", df.parse("2021-08-31 09:57"), 32));
        llegadas.add(new Vuelo("LAT 1283", "Cancún", "Santiago", df.parse("2021-08-31 04:00"), 35));
        llegadas.add(new Vuelo("LAT 579", "Barcelona", "Santiago", df.parse("2021-08-29 07:45"), 61));
        llegadas.add(new Vuelo("AAL 945", "Dallas-Fort Worth", "Santiago", df.parse("2021-08-30 07:12"), 58));
        llegadas.add(new Vuelo("LAT 501", "París", "Santiago", df.parse("2021-08-29 18:29"), 49));
        llegadas.add(new Vuelo("LAT 405", "Montevideo", "Santiago", df.parse("2021-08-30 15:45"), 39));

        //ordenar vuelos
        llegadas.sort((v1,v2)-> v2.getFecha().compareTo(v1.getFecha()));
        llegadas.forEach(System.out::println);

        System.out.println("el ultimo vuelo en llegar es: "+ llegadas.get(0));
        llegadas.sort((v1, v2)-> Integer.valueOf(v2.getPasajeros()).compareTo(v1.getPasajeros()));//poder ordenar


        var menorPasajeros = llegadas.get(0);

        System.out.println("El vuelo con menor numero de pasajeros es :" + menorPasajeros.getNombre());
    }
}
