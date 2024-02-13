package org.carinsurance.carinsurancehql.service.implement;

import org.carinsurance.carinsurancehql.dto.VehiclesDTO;
import org.carinsurance.carinsurancehql.entity.Sinister;
import org.carinsurance.carinsurancehql.entity.Vehicle;
import org.carinsurance.carinsurancehql.repository.ISinisterRepository;
import org.carinsurance.carinsurancehql.repository.IVehicleRepository;
import org.carinsurance.carinsurancehql.dto.SinisterDTO;
import org.carinsurance.carinsurancehql.service.interfaces.ISinisterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinisterService implements ISinisterService {
    ISinisterRepository sinisterRepository;
    IVehicleRepository vehicleRepository;
    public SinisterService(ISinisterRepository sinisterRepository, IVehicleRepository vehicleRepository) {
        this.sinisterRepository = sinisterRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public SinisterDTO createSinister(SinisterDTO sinisterDTO) {
        Vehicle vehicle = vehicleRepository.findById(sinisterDTO.vehicle().id()).orElse(null);
        System.out.println(vehicle);
        Sinister sinister = new Sinister(
            sinisterDTO.id(),
            sinisterDTO.dateSinister(),
            sinisterDTO.economicLoss(),
                vehicle
        );
        sinisterRepository.save(sinister);
        SinisterDTO sinisterDTOToReturn = new SinisterDTO(
            sinister.getId(),
            sinister.getDateSinister(),
            sinister.getEconomicLoss(),
            new VehiclesDTO(
                sinister.getVehicle().getId(),
                sinister.getVehicle().getPatent(),
                sinister.getVehicle().getBrand(),
                sinister.getVehicle().getModel(),
                sinister.getVehicle().getFabricationYear(),
                sinister.getVehicle().getQuantityWheels()
            )
        );
        return sinisterDTOToReturn;
    }

    @Override
    public List<SinisterDTO> getListOfSinisters() {
        List<Sinister> sinisters = sinisterRepository.findAll();
        if (sinisters.isEmpty())
            return null;
        List<SinisterDTO> sinistersDTO = sinisters.stream().map(sinister -> new SinisterDTO(
            sinister.getId(),
            sinister.getDateSinister(),
            sinister.getEconomicLoss(),
            new VehiclesDTO(
                sinister.getVehicle().getId(),
                sinister.getVehicle().getPatent(),
                sinister.getVehicle().getBrand(),
                sinister.getVehicle().getModel(),
                sinister.getVehicle().getFabricationYear(),
                sinister.getVehicle().getQuantityWheels()
            )
        )).toList();
        return sinistersDTO;
    }
}
