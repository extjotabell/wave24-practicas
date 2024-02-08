package org.joyeria.joyeria.dto.Jewel;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.joyeria.joyeria.model.Jewel;

public record CreateJewelWithoutIdDTO(
        @Size(max = 25, message = "El nombre no puede tener mas de 25 caracteres")
        @NotNull(message = "El nombre no puede ser nulo")
        @NotBlank(message = "El nombre no puede estar en blanco")
        String nombre,

        @NotNull(message = "El material no puede ser nulo")
        @NotBlank(message = "El material no puede estar en blanco")
        @Size(max = 100, message = "El material no puede tener mas de 100 caracteres")
        String material,

        @Max(value = 1000, message = "El peso no puede ser menor a 0 ni mayor a 1000")
        @NotNull(message = "El peso no puede ser nulo")
        Double peso,

        @Size(max = 255, message = "La particularidad no puede tener mas de 255 caracteres")
        String particularidad,

        Boolean poseePiedra,
        Boolean ventaONo
) {
    public Jewel mapToJewel(Long id) {
            return new Jewel(
                    id,
                    nombre,
                    material,
                    peso,
                    particularidad,
                    poseePiedra,
                    ventaONo
            );
    }

    public Jewel mapToJewel() {
        return new Jewel(
                null,
                nombre,
                material,
                peso,
                particularidad,
                poseePiedra,
                ventaONo
        );
    }
}
