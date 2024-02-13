package org.carinsurance.carinsurancehql.service.interfaces;

import org.carinsurance.carinsurancehql.dto.PatentDTO;
import org.carinsurance.carinsurancehql.dto.SummaryVehiclesDTO;
import org.carinsurance.carinsurancehql.dto.VehiclesDTO;
import org.carinsurance.carinsurancehql.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    VehiclesDTO save(VehiclesDTO vehicle);
    List<VehiclesDTO> listOfVehicles();
    List<PatentDTO> listOfPatents();

    List<SummaryVehiclesDTO> listOfPatentsAndBrands();

    List<SummaryVehiclesDTO> listOfPatentsWithWheelsAndYear();

    List<SummaryVehiclesDTO> listOfIdAndBrandAndModelByHigherPriceToOneHundredThousand();

    List<SummaryVehiclesDTO> listOfIdAndBrandAndModelByHigherPriceToOneHundredThousandAndTotalLoss();

}
