package org.carinsurance.carinsurancehql.service.implement;

import org.carinsurance.carinsurancehql.dto.PatentDTO;
import org.carinsurance.carinsurancehql.dto.SummaryVehiclesDTO;
import org.carinsurance.carinsurancehql.dto.VehiclesDTO;
import org.carinsurance.carinsurancehql.entity.Vehicle;
import org.carinsurance.carinsurancehql.repository.IVehicleRepository;
import org.carinsurance.carinsurancehql.service.interfaces.IVehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService implements IVehicleService {
    IVehicleRepository vehicleRepository;

    public VehicleService(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehiclesDTO save(VehiclesDTO vehicle) {
        Vehicle vehicleToSave = new Vehicle(
            vehicle.id(),
            vehicle.patent(),
            vehicle.brand(),
            vehicle.model(),
            vehicle.fabricationYear(),
            vehicle.quantityWheels()
        );
        vehicleRepository.save(vehicleToSave);
        return vehicle;
    }

    @Override
    public List<VehiclesDTO> listOfVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehiclesDTO> vehiclesDTO = vehicles.stream().map(vehicle -> new VehiclesDTO(vehicle.getId(),
                                                        vehicle.getPatent(),
                                                        vehicle.getBrand(),
                                                        vehicle.getModel(),
                                                        vehicle.getFabricationYear(),
                                                        vehicle.getQuantityWheels())).toList();

        return vehiclesDTO;
    }

    @Override
    public List<PatentDTO> listOfPatents() {
        List<PatentDTO> patentOfVehicles = vehicleRepository.allPatents();
        if (patentOfVehicles.isEmpty())
            return null;
        return patentOfVehicles;
    }

    @Override
    public List<SummaryVehiclesDTO> listOfPatentsAndBrands() {
        List<SummaryVehiclesDTO> patentAndBrandOfVehicles = vehicleRepository.allPatentsAndBrands();
        if (patentAndBrandOfVehicles.isEmpty())
            return null;
        return patentAndBrandOfVehicles;
    }

    @Override
    public List<SummaryVehiclesDTO> listOfPatentsWithWheelsAndYear() {
        List<SummaryVehiclesDTO> patentWithWheelsAndYear = vehicleRepository.allPatentsWithWheelsAndYear();
        if (patentWithWheelsAndYear.isEmpty())
            return null;
        return patentWithWheelsAndYear;
    }

    @Override
    public List<SummaryVehiclesDTO> listOfIdAndBrandAndModelByHigherPriceToOneHundredThousand() {
        List<SummaryVehiclesDTO> summaryVehiclesByLossHigherThanOneHundredThousand = vehicleRepository.allPatentsAndBrandAndModelByHigherPriceToOneHundredThousand();
        if (summaryVehiclesByLossHigherThanOneHundredThousand.isEmpty())
            return null;
        return summaryVehiclesByLossHigherThanOneHundredThousand;
    }

    @Override
    public List<SummaryVehiclesDTO> listOfIdAndBrandAndModelByHigherPriceToOneHundredThousandAndTotalLoss() {
        List<SummaryVehiclesDTO> summaryVehiclesByLossHigherThanOneHundredThousandAndTotalLoss = vehicleRepository.allPatentAndBrandAndModelByHigherPriceToOneHundredThousandAndTotalLoss();
        if (summaryVehiclesByLossHigherThanOneHundredThousandAndTotalLoss.isEmpty())
            return null;
        return summaryVehiclesByLossHigherThanOneHundredThousandAndTotalLoss;
    }
}
