package org.example.joyeria.service;

import org.example.joyeria.dto.JewelDTO;
import org.example.joyeria.model.Jewel;

import java.util.List;

public interface IJewelService {
    Jewel saveJewel(JewelDTO jewelDTO);
    Jewel updateJewel(Integer id, JewelDTO jewelDTO);
    Jewel deleteJewel(Integer id);
    List<Jewel> getAllJewels();
}
