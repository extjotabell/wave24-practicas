package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VehicleRepositoryTest {
    private Utils utils = new Utils();

    IVehicleRepository repository = new VehicleRepositoryImpl();

    @Test
    @DisplayName("Test validates that list return the same size of list")
    public void findAllTest(){
        // arrage
        int cantResults = 500;

        // act
        var result =  repository.findAll();

        // assert
        Assertions.assertEquals(cantResults, result.size(),"Las listas no coinciden");
    }

    @Test
    @DisplayName("Test that by receiving an id returns the correct object")
    public void findByIdTest(){
        //arrange
        int idVehicle= 1;
        Vehicle expected = utils.getVehicle();

        // act
        var result = repository.findById(idVehicle);

        // assert
        Assertions.assertEquals(expected, result, "El objeto no corresponde al id brindado.");
    }

    @Test
    @DisplayName("Test that by receiving an id returns the correct object")
    public void getVehicleAddedTest(){
        //arrange
        Vehicle param = utils.getNewVehicle();
        Vehicle expected = utils.getNewVehicle();

        // act
        var result = repository.addVehicle(param);

        // assert
        Assertions.assertEquals(expected, result, "El objeto no corresponde al id brindado.");
    }

    @Test
    @DisplayName("Test that by receiving an id and speed and update the speed")
    public void updateSpeedByVehicleTest(){
        //arrange
        int idVehicle = 1;
        String speed = "90";
        Vehicle param = utils.getVehicle();
        Vehicle expected = utils.getModifiedVehicle();

        //act
        var result = repository.updateSpeed(idVehicle, speed);

        //assert
        Assertions.assertEquals(result, expected, "El objeto no corresponde al id brindado.");
    }

    @Test
    @DisplayName("Test that by receiving a color and year and update the speed")
    public void findByColorAndYearTest(){
        //arrange
        int year = 1986;
        String color = "Mauv";
        Vehicle expected = utils.getVehicle();

        //act
        var result = repository.findByColorAndYear(color, year);

        //assert
        Assertions.assertTrue(result.contains(expected));
    }
}