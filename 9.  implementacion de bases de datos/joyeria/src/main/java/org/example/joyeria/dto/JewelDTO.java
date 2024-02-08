package org.example.joyeria.dto;

import org.example.joyeria.model.Jewel;

public record JewelDTO(
        Integer nro_idenfiicatorio,
        String nombre,
        String material,
        Integer peso,
        Boolean posee_piedra
) {

    public JewelDTO(Jewel jewel) {
        this(jewel.getNroIdenfiicatorio(), jewel.getNombre(), jewel.getMaterial(), jewel.getPeso(), jewel.getPoseePiedra());
    }

}
