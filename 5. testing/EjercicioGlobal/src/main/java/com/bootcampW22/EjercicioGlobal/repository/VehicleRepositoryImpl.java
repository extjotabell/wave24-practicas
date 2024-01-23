package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl(){
        listOfVehicles = loadDataBase();
    }
    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public Vehicle findById(Integer id) {
        return listOfVehicles.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        vehicle.setId(listOfVehicles.size()+1);
        if(this.listOfVehicles.add(vehicle))
            return vehicle;
        return null;
    }

    @Override
    public Vehicle updateSpeed(Integer id, String speed) {
        Vehicle v = listOfVehicles.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst().orElse(null);
        if(Objects.nonNull(v)) {
            v.setMax_speed(speed);
            return v;
        }

        return null;
    }

    @Override
    public List<Vehicle> findByColorAndYear(String color, Integer year) {
        /*return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getColor().equals(color))
                .filter(vehicle -> vehicle.getYear().equals(year))
                .collect(Collectors.toCollection(ArrayList::new));
        */
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getColor().equals(color)
                || vehicle.getYear().equals(year))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<Vehicle> findByBrandAndYearsRange(String brand, Integer startYear, Integer endYear){
        return listOfVehicles.stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand)
                && vehicle.getYear() >= startYear && vehicle.getYear() <= endYear)
                        .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Double calculateAverageSpeedByBrand(String brand){
        List<Vehicle> speedList = listOfVehicles.stream().filter(vehicle -> vehicle.getBrand().equals(brand)).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> speedToInteger = speedList.stream().map(Vehicle::getMax_speed).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        return speedToInteger.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    @Override
    public OptionalDouble calculateAveragePassangersByBrand(String brand) {
        List<Vehicle> vehicles = listOfVehicles.stream().filter(vehicle -> vehicle.getBrand().equals(brand)).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> passangers = vehicles.stream().map(Vehicle::getPassengers).collect(Collectors.toCollection(ArrayList::new));
        return passangers.stream().mapToInt(Integer::intValue).average();
    }



    private List<Vehicle> loadDataBase(){
/*        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<>(){});

        listOfVehicles = vehicles;
*/
        List<Vehicle> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

       // objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        TypeReference<List<Vehicle>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:vehicles_100.json");
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
