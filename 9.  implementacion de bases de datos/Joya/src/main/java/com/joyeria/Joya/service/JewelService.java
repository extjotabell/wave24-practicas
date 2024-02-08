package com.joyeria.Joya.service;

import com.joyeria.Joya.dto.CreateJewelDTO;
import com.joyeria.Joya.dto.JewelDTO;
import com.joyeria.Joya.entity.Jewel;
import com.joyeria.Joya.exception.NotFoundException;
import com.joyeria.Joya.repository.IJewelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelService implements IJewelService {

    private final IJewelRepository jewelRepository;

    public JewelService(IJewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
    }

    @Override
    public CreateJewelDTO saveJewel(JewelDTO jewelDTO) {

        Jewel jewel = this.convertJewelDTOToJewel(jewelDTO);
        jewel = jewelRepository.save(jewel);

        return new CreateJewelDTO("Jewel created with the identification number: " + jewel.getId().toString());

    }

    @Override
    public List<JewelDTO> getAllJewels() {

        return jewelRepository.findByForSaleIsTrueAnd()
                .stream().map(this::convertJewelToJewelDTO).toList();
    }

    @Override
    public JewelDTO findJewel(long id) {

        return null;
    }

    @Override
    public JewelDTO updateJewel(long id, JewelDTO jewelDTO) {

        Jewel updateJewel = convertJewelDTOToJewel(jewelDTO);
        updateJewel.setId(id);
        updateJewel = jewelRepository.save(updateJewel);

        return convertJewelToJewelDTO(updateJewel);
    }

    @Override
    public void deleteJewel(long id) {

        Jewel deleteJewel = jewelRepository.findById(id).orElseThrow(() -> new NotFoundException("Jewel not found"));
        deleteJewel.setIsForSale(false);
        jewelRepository.save(deleteJewel);
    }

    private JewelDTO convertJewelToJewelDTO(Jewel jewel) {
        return new JewelDTO(
                jewel.getId(),
                jewel.getName(),
                jewel.getMaterial(),
                jewel.getWeight(),
                jewel.getParticularity(),
                jewel.getHasGemstone(),
                jewel.getIsForSale()
        );
    }

    private Jewel convertJewelDTOToJewel(JewelDTO jewelDTO) {
        return new Jewel(
                jewelDTO.id(),
                jewelDTO.name(),
                jewelDTO.material(),
                jewelDTO.weight(),
                jewelDTO.particularity(),
                jewelDTO.hasGemstone(),
                jewelDTO.isForSale()
        );
    }
}
