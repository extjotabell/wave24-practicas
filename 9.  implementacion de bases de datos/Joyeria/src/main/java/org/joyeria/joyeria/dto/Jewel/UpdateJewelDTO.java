package org.joyeria.joyeria.dto.Jewel;

import jakarta.validation.constraints.*;
import org.joyeria.joyeria.model.Jewel;

import java.util.Optional;

public record UpdateJewelDTO(
        @Size(max = 25, message = "El nombre no puede tener mas de 25 caracteres")
        String nombre,

        @Size(max = 100, message = "El material no puede tener mas de 100 caracteres")
        String material,

        @Max(value = 1000, message = "El peso no puede ser menor a 0 ni mayor a 1000")
        Double peso,

        @Size(max = 255, message = "La particularidad no puede tener mas de 255 caracteres")
        String particularidad,

        Boolean poseePiedra,
        Boolean ventaONo
) {
    public Jewel assignData(Jewel jewel) {
        Optional.ofNullable(nombre).ifPresent(jewel::setName);
        Optional.ofNullable(material).ifPresent(jewel::setMaterial);
        Optional.ofNullable(peso).ifPresent(jewel::setWeight);
        Optional.ofNullable(particularidad).ifPresent(jewel::setParticularity);
        Optional.ofNullable(poseePiedra).ifPresent(jewel::setIsAvailable);
        Optional.ofNullable(ventaONo).ifPresent(jewel::setIsForSale);

        return jewel;
    }
}
