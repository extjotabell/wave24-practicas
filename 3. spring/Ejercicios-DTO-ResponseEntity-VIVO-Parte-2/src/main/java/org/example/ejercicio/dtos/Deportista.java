package org.example.ejercicio.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ejercicio.classes.Deporte;
import org.example.ejercicio.classes.Persona;


public record Deportista(String Nombre, String apellido, String deporte) {

}
