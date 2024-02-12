package org.example.hqlvehiculosasegurados.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "siniestro")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_siniestro")
    private LocalDate fechaSiniestro;

    @Column(name = "perdida_economica")
    private Double perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculo vehiculo;

    public Siniestro(Long id, LocalDate fechaSiniestro, Double perdidaEconomica) {
        this.id = id;
        this.fechaSiniestro = fechaSiniestro;
        this.perdidaEconomica = perdidaEconomica;
    }
}

