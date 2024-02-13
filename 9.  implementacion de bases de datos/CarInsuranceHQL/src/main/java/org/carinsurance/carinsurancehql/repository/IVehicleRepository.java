package org.carinsurance.carinsurancehql.repository;

import org.carinsurance.carinsurancehql.dto.PatentDTO;
import org.carinsurance.carinsurancehql.dto.SummaryVehiclesDTO;
import org.carinsurance.carinsurancehql.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT new org.carinsurance.carinsurancehql.dto.PatentDTO(c.patent) from Vehicle c")
    List<PatentDTO> allPatents();

    @Query("SELECT new org.carinsurance.carinsurancehql.dto.SummaryVehiclesDTO(c.patent, c.brand) from Vehicle c " +
            "order by c.fabricationYear")
    List<SummaryVehiclesDTO> allPatentsAndBrands();

    @Query("SELECT new org.carinsurance.carinsurancehql.dto.SummaryVehiclesDTO(c.patent) from Vehicle c " +
            "where c.quantityWheels = 4 and c.fabricationYear = '2024'")
    List<SummaryVehiclesDTO> allPatentsWithWheelsAndYear();

    @Query("SELECT new org.carinsurance.carinsurancehql.dto.SummaryVehiclesDTO(c.patent, c.brand, c.model) from Vehicle c " +
            "join Sinister s on c.id = s.vehicle.id where s.economicLoss > 10000")
    List<SummaryVehiclesDTO> allPatentsAndBrandAndModelByHigherPriceToOneHundredThousand();

    @Query("SELECT new org.carinsurance.carinsurancehql.dto.SummaryVehiclesDTO(c.patent, c.brand, c.model), sum(s.economicLoss) " +
            "from Vehicle c join Sinister s on c.id = s.vehicle.id where s.economicLoss > 10000 group by c.patent, c.brand, c.model")
    List<SummaryVehiclesDTO> allPatentAndBrandAndModelByHigherPriceToOneHundredThousandAndTotalLoss();
}
