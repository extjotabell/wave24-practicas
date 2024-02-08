package org.joyeria.joyeria.service.interfaces;

import org.joyeria.joyeria.dto.Jewel.CreateJewelWithoutIdDTO;
import org.joyeria.joyeria.dto.Jewel.JewelDTO;
import org.joyeria.joyeria.dto.Jewel.UpdateJewelDTO;
import org.joyeria.joyeria.sort.JewelSortField;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IJewelService {
    Long saveJewel(CreateJewelWithoutIdDTO jewel);
    List<JewelDTO> getAllJewels(Integer page, Integer size, Sort.Direction sort, JewelSortField sortField);
    JewelDTO logicDeleteJewel(Long id);
    JewelDTO updateJewel(Long id, UpdateJewelDTO jewel);
}
