package org.joyeria.joyeria.service;

import org.joyeria.joyeria.dto.Jewel.CreateJewelWithoutIdDTO;
import org.joyeria.joyeria.dto.Jewel.JewelDTO;
import org.joyeria.joyeria.dto.Jewel.UpdateJewelDTO;
import org.joyeria.joyeria.exception.NotFoundException;
import org.joyeria.joyeria.exception.QueryParamException;
import org.joyeria.joyeria.repository.interfaces.IJewelRepository;
import org.joyeria.joyeria.service.interfaces.IJewelService;
import org.joyeria.joyeria.sort.JewelSortField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelService implements IJewelService {
    private final IJewelRepository jewelRepository;

    @Autowired
    public JewelService(IJewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
    }

    public Long saveJewel(CreateJewelWithoutIdDTO jewel) {
        var jewelCreated = jewelRepository.save(jewel.mapToJewel());

        return jewelCreated.getId();
    }

    public List<JewelDTO> getAllJewels(Integer page, Integer size, Sort.Direction sort, JewelSortField sortField) {
        return jewelRepository
                .findByIsForSaleIsTrue(PageRequest.of(page, size, sort, sortField.getDatabaseFieldName()))
                .stream()
                .map(JewelDTO::jewelToDTO)
                .toList();
    }

    public JewelDTO logicDeleteJewel(Long id) {
        var jewel = jewelRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Can't delete jewel because it doesn't exist"));

        jewel.setIsForSale(false);
        jewelRepository.save(jewel);

        return JewelDTO.jewelToDTO(jewel);
    }

    public JewelDTO updateJewel(Long id, UpdateJewelDTO jewel) {
        if (jewel.nombre() != null && jewel.nombre().isEmpty())
            throw new QueryParamException("Parameter \"nombre\" cannot be empty");
        if (jewel.material() != null && jewel.material().isEmpty())
            throw new QueryParamException("Parameter \"material\" cannot be empty");

        var jewelToUpdate = jewelRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Can't update jewel because it doesn't exist"));
        var jewelUpdated = jewel.assignData(jewelToUpdate);

        return JewelDTO.jewelToDTO(jewelRepository.save(jewelUpdated));
    }
}
