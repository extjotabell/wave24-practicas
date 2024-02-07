package org.laperla.configs;

import org.laperla.dtos.JewerlyRequestDTO;
import org.laperla.entity.Jewerly;

public class ModelMapper {

    public Jewerly map(JewerlyRequestDTO dto, Class c) {
        if(c == Jewerly.class) {
            return new Jewerly(
                    null,
                    dto.name(),
                    dto.material(),
                    dto.weight(),
                    dto.particularity(),
                    dto.hasStone(),
                    null
            );
        }
        return null;
    }

    public JewerlyRequestDTO map(Jewerly e, Class c) {
        if(c == JewerlyRequestDTO.class) {
            return new JewerlyRequestDTO(
                    e.getName(),
                    e.getMaterial(),
                    e.getWeight(),
                    e.getParticularity(),
                    e.getHasStone()
            );
        }
        return null;
    }


}
