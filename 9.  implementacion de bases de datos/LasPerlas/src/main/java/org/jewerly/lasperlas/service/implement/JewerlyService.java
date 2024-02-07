package org.jewerly.lasperlas.service.implement;

import org.jewerly.lasperlas.dto.JewerlyDTO;
import org.jewerly.lasperlas.dto.MessageDTO;
import org.jewerly.lasperlas.dto.response.JewerlyUpdateResponseDTO;
import org.jewerly.lasperlas.entity.Jewerly;
import org.jewerly.lasperlas.repository.IJewerlyRepository;
import org.jewerly.lasperlas.service.interfaces.IJewerlyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewerlyService implements IJewerlyService {
    IJewerlyRepository jewerlyRepository;

    public JewerlyService(IJewerlyRepository jewerlyRepository) {
        this.jewerlyRepository = jewerlyRepository;
    }

    @Override
    public MessageDTO saveEntity(JewerlyDTO jewerlyDTO) {

        Jewerly jewerly = convertToJewerly(jewerlyDTO);
        jewerly.setIsOnSale(true);
        jewerly = jewerlyRepository.save(jewerly);
        if (jewerly == null) {
            return null;
        }
        return new MessageDTO(jewerly.getIdentificationNumber().toString(), "200");
    }

    @Override
    public JewerlyUpdateResponseDTO updateEntityById(JewerlyDTO jewerlyDTO, Long id) {
        Jewerly jewerly = jewerlyRepository.findById(id).orElse(null);
        if (jewerly == null) {
            return null;
        }
        Jewerly jewerlyUpdate = convertToJewerly(jewerlyDTO);
        jewerly.setName(jewerlyUpdate.getName());
        jewerly.setMaterial(jewerlyUpdate.getMaterial());
        jewerly.setParticularity(jewerlyUpdate.getParticularity());
        jewerly.setWeight(jewerlyUpdate.getWeight());
        jewerly.setHasStone(jewerlyUpdate.getHasStone());
        jewerly.setIsOnSale(jewerlyUpdate.getIsOnSale());
        jewerly = jewerlyRepository.save(jewerly);
        return new JewerlyUpdateResponseDTO(new MessageDTO("Jewerly updated successfully", "200"), convertToJewerlyDTO(jewerly));
    }

    @Override
    public List<JewerlyDTO> getAllEntities() {
        List<Jewerly> jewerlyList = jewerlyRepository.findByIsOnSaleTrue();
        return jewerlyList.stream().map(this::convertToJewerlyDTO).toList();
    }

    @Override
    public MessageDTO deleteEntity(Long id) {
        Jewerly jewerly = jewerlyRepository.findById(id).orElse(null);
        if (jewerly == null) {
            return null;
        }
        jewerly.setIsOnSale(false);
        jewerly = jewerlyRepository.save(jewerly);
        if (jewerly == null) {
            return null;
        }
        return new MessageDTO("Jewerly deleted successfully", "200");
    }
    private JewerlyDTO convertToJewerlyDTO(Jewerly jewerly) {
        JewerlyDTO jewerlyDTO = new JewerlyDTO(
                jewerly.getIdentificationNumber(),
                jewerly.getName(),
                jewerly.getMaterial(),
                jewerly.getWeight(),
                jewerly.getParticularity(),
                jewerly.getHasStone(),
                jewerly.getIsOnSale()
        );
        return jewerlyDTO;
    }
    private Jewerly convertToJewerly(JewerlyDTO jewerlyDTO) {
        Jewerly jewerly = new Jewerly(
                jewerlyDTO.identificationNumber(),
                jewerlyDTO.name(),
                jewerlyDTO.material(),
                jewerlyDTO.weight(),
                jewerlyDTO.particularity(),
                jewerlyDTO.hasStone(),
                jewerlyDTO.isOnSale()
        );
        return jewerly;
    }
}
