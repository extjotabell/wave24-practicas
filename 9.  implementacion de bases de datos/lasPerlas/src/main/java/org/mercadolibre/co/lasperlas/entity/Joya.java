package org.mercadolibre.co.lasperlas.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Joya {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    //@Column(name="", length =12, nullable = false)
    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    private boolean poseePiedra;

    private boolean ventaONo;

    private boolean eliminado;
}
