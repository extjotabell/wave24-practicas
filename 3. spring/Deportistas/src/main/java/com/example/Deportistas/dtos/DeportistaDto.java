package com.example.Deportistas.dtos;

import com.example.Deportistas.entities.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeportistaDto implements Serializable {
    private String nombre;
    private String apellido;
    private String deporte;

    public DeportistaDto(Persona persona){
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        this.deporte = persona.getDeporte().getNombre();
    }

}
