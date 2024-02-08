package com.joyeria.Joya.service;

import com.joyeria.Joya.dto.CreateJewelDTO;
import com.joyeria.Joya.dto.JewelDTO;
import com.joyeria.Joya.entity.Jewel;

import java.util.List;

public interface IJewelService {

    CreateJewelDTO saveJewel (JewelDTO jewelDTO);
    List<JewelDTO> getAllJewels();
    JewelDTO findJewel (long id);
    JewelDTO updateJewel (long id, JewelDTO jewelDTO);
    void deleteJewel (long id);



}
