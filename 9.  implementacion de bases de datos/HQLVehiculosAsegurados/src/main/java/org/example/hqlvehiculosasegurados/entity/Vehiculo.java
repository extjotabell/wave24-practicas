package org.example.hqlvehiculosasegurados.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patente;

    private String marca;

    private String modelo;

    @Column(name = "anio_fabricacion")
    private Integer anioFabricacion;

    @Column(name = "cantidad_de_ruedas")
    private Integer cantidadDeRuedas;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Siniestro> siniestros;

    public Vehiculo(Long id, String patente, String marca, String modelo, Integer anioFabricacion, Integer cantidadDeRuedas) {
        this.id = id;
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.cantidadDeRuedas = cantidadDeRuedas;
    }
}
