package org.joyeria.joyeria.dto.Jewel;

import org.joyeria.joyeria.model.Jewel;

public record JewelDTO(
        Long id,
        String nombre,
        String material,
        Double peso,
        String particularidad,
        Boolean poseePiedra,
        Boolean ventaONo
) {
    public static JewelDTO jewelToDTO(Jewel jewel) {
        return new JewelDTO(
                jewel.getId(),
                jewel.getName(),
                jewel.getMaterial(),
                jewel.getWeight(),
                jewel.getParticularity(),
                jewel.getIsAvailable(),
                jewel.getIsForSale()
        );
    }
}
