package com.practice.jewerly.service;

import com.practice.jewerly.dto.JewelDto;
import com.practice.jewerly.dto.MessageDto;
import com.practice.jewerly.mapper.JewelMapper;
import com.practice.jewerly.model.Jewel;
import com.practice.jewerly.repository.IJewelRepository;
import com.practice.jewerly.service.interfaces.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelService implements IJewelService {
    private final JewelMapper jewelMapper = new JewelMapper();

    @Autowired
    private IJewelRepository jewelRepository;

    @Override
    public MessageDto save(JewelDto jewelDto) {
        Jewel jewel = jewelMapper.jewerlyDtoToJewerly(jewelDto);
        jewel.setVentaONo(true);
        jewel = jewelRepository.save(jewel);

        return new MessageDto(HttpStatus.OK.value(), "Jewel " + jewel.getNroIdentificatorio() + " saved.");
    }

    @Override
    public JewelDto getById(Long id) {
        Jewel jewel = jewelRepository.findById(id).orElseThrow();

        return jewelMapper.jewerlyToJewerlyDto(jewel);
    }

    @Override
    public List<JewelDto> getAll() {
        return jewelRepository.findByVentaONoIsTrue().stream().map(
                jewelMapper::jewerlyToJewerlyDto
        ).toList();
    }

    @Override
    public MessageDto deleteById(Long id) {
        if (!jewelRepository.existsById(id)) {
            return new MessageDto(HttpStatus.NOT_FOUND.value(), "Jewel " + id + " doesn't exist.");
        }

        Jewel jewel = jewelRepository.findById(id).orElseThrow();
        jewel.setVentaONo(false);
        jewel = jewelRepository.save(jewel);
        return new MessageDto(HttpStatus.OK.value(), "Jewel " + jewel.getNroIdentificatorio() + " deleted.");
    }

    @Override
    public MessageDto updateById(Long id, JewelDto jewelDto) {
        if (!jewelRepository.existsById(id)) {
            return new MessageDto(HttpStatus.NOT_FOUND.value(), "Jewel " + jewelDto.nroIdentificatorio() + " doesn't exist.");
        }

        Jewel jewel = jewelMapper.jewerlyDtoToJewerly(jewelDto);
        jewel.setNroIdentificatorio(id);
        jewel = jewelRepository.save(jewel);

        return new MessageDto(HttpStatus.OK.value(), "Jewel " + jewel.getNroIdentificatorio() + " updated.");
    }
}
