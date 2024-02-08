package org.example.joyeria.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.joyeria.dto.JewelDTO;

@Data
@NoArgsConstructor
@Entity
public class Jewel {

    @Id
    @Column(name = "nro_idenfiicatorio")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer nroIdenfiicatorio;

    @Column(length = 15)
    private String nombre;

    @Column(length = 15)
    private String material;

    private Integer peso;

    @Column(name = "posee_piedra")
    private Boolean poseePiedra;

    @Column(name = "venta_o_no")
    private Boolean ventaONo;

    public Jewel(JewelDTO jewelDTO) {
        this.nroIdenfiicatorio = jewelDTO.nro_idenfiicatorio();
        this.nombre = jewelDTO.nombre();
        this.material = jewelDTO.material();
        this.peso = jewelDTO.peso();
        this.poseePiedra = jewelDTO.posee_piedra();
        this.ventaONo = true;
    }

}
