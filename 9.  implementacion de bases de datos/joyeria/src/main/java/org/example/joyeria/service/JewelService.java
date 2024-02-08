package org.example.joyeria.service;

import org.example.joyeria.dto.JewelDTO;
import org.example.joyeria.model.Jewel;
import org.example.joyeria.repository.IJewelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelService implements IJewelService {

    IJewelRepository jewelRepository;

    public JewelService(IJewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
    }

    public Jewel saveJewel(JewelDTO jewelDTO) {
        Jewel newJewel = new Jewel(jewelDTO);
        return jewelRepository.save(newJewel);
    }

    @Override
    public Jewel updateJewel(Integer id, JewelDTO jewelDTO) {
        Jewel jewel = jewelRepository.findById(id).orElse(null);
        if (jewel != null) {
            jewel.setNombre(jewelDTO.nombre());
            jewel.setMaterial(jewelDTO.material());
            jewel.setPeso(jewelDTO.peso());
            jewel.setPoseePiedra(jewelDTO.posee_piedra());
            return jewelRepository.save(jewel);
        }
        return null;
    }

    @Override
    public Jewel deleteJewel(Integer id) {
        Jewel jewel = jewelRepository.findById(id).orElse(null);
        if (jewel != null) {
            jewel.setVentaONo(false);
            return jewelRepository.save(jewel);
        }
        return null;
    }

    @Override
    public List<Jewel> getAllJewels() {
        return jewelRepository.findAll();
    }

}
