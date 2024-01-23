package com.bootcampW22.EjercicioGlobal.service;


import com.bootcampW22.EjercicioGlobal.dto.MessageDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.OptionalDouble;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {
    @Mock
    private IVehicleRepository repository;

    @InjectMocks
    private VehicleServiceImpl service;

    Utils utils = new Utils();

    @Test
    public void searchAllVehiclesTest(){
        //arrange
        VehicleDto expected = utils.getVehicleDto();
        Mockito.when(repository.findAll()).thenReturn(utils.getAListOfVehicle());

        //act
        var result = service.searchAllVehicles();

        //assert
        Assertions.assertTrue(result.contains(expected));
    }

    @Test
    public void addVehicleTest(){
        //arrange
        MessageDto expectedMessage = new MessageDto("Se agrego correctamente.");
        VehicleDto param = utils.getVehicleDto();
        Mockito.when(repository.addVehicle(utils.getVehicle())).thenReturn(utils.getVehicle());

        //act
        var result = service.addVehicle(param);

        //assert
        Assertions.assertEquals(result, expectedMessage);
    }

    @Test
    public void addVehicleThowsBadRequestExceptionTest(){
        //arrange
        VehicleDto param = new VehicleDto(null, null, null, null, null, null,null, null, null, null, null, null, null);

        //act
        //assert
        Assertions.assertThrows(BadRequestException.class, ()-> service.addVehicle(param));
    }

    @Test
    public void addVehicleThowsConflictExceptionTest(){
        //arrange
        int idVehicle = 1;
        VehicleDto param = utils.getVehicleDto();
        Mockito.when(repository.findById(idVehicle)).thenReturn(utils.getVehicle());

        //act
        //assert
        Assertions.assertThrows(ConflictException.class, ()-> service.addVehicle(param));
    }

    @Test
    public void searchByBrandAndYearTest(){
        //arrange
        String brand = "Pontiac";
        int startYear = 1985;
        int endYear = 1987;
        List<VehicleDto> expected = utils.getAListOfVehicleDto();
        Mockito.when(repository.findByBrandAndYearsRange(brand, startYear, endYear)).thenReturn(utils.getAListOfVehicle());

        //act
        var result = service.searchByBrandAndYear(brand, startYear, endYear);

        //assert
        Assertions.assertEquals(result, expected);
    }

    @Test
    public void calculateAveragePassangersByBrandTest(){
        //arrange
        String brand = "Pontiac";
        MessageDto expectedMessage = new MessageDto("El promedio de pasajes de la marca Pontiac es 3.0");
        Mockito.when(repository.calculateAveragePassangersByBrand(brand)).thenReturn(OptionalDouble.of(3.0));

        //act
        var result = service.calculateAveragePassangersByBrand(brand);

        //assert
        Assertions.assertEquals(result, expectedMessage);
    }

    @Test
    public void calculateAveragePassangersByBrandTrowsNotFoundExceptionTest(){
        //arrange
        String brand = "Pontiac";
        Mockito.when(repository.calculateAveragePassangersByBrand(brand)).thenReturn(OptionalDouble.empty());

        //act
        //assert
        Assertions.assertThrows(NotFoundException.class, () -> service.calculateAveragePassangersByBrand(brand));
    }

}