package org.example.joyeria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private Integer peso;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;

    public Joya(String nombre, String material, Integer peso, String particularidad, Boolean poseePiedra, Boolean ventaONo) {
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.poseePiedra = poseePiedra;
        this.ventaONo = ventaONo;
    }
}
