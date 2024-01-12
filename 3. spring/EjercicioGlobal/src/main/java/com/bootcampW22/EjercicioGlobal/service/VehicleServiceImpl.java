package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.CreateVehicleDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    private final Map<String, String> FUEL_TYPE = new HashMap<>(){{
        put("gas", "gas");
        put("gasoline", "gasoline");
        put("diesel", "diesel");
        put("biodiesel", "biodiesel");
    }};

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(this::convertVehicleToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreateVehicleDTO> createVehiclesBatch(List<VehicleDto> vehiclesDTO) {
        vehiclesDTO.forEach(vehicleDto -> {
            validateDTO(vehicleDto);
            if(this.vehicleRepository.findById(vehicleDto.id()).isPresent()){
                throw new ConflictException("Id "+ vehicleDto.id() + " existe en la base de datos");
            }
        });

        vehicleRepository.bulkCreate(vehiclesDTO.stream().map(this::convertDTOtoVehicle).collect(Collectors.toList()));
        return vehiclesDTO.stream().map(vehicleDto -> new CreateVehicleDTO(vehicleDto.id())).toList();
    }

    @Override
    public List<VehicleDto> findByDimensions(Double minLength, Double maxLength, Double minWidth, Double maxWidth) {
        List<Vehicle> vehiclesFinded = this.vehicleRepository.findByDimensions(minLength, maxLength, minWidth, maxWidth);
        if(vehiclesFinded.isEmpty()){
            throw new NotFoundException("No Existen Vehiculos bajo los filtros porporcionados");
        }


        return vehiclesFinded.stream()
                .map(this::convertVehicleToDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto updateFuel(VehicleDto vehicleDto) {
        if(this.vehicleRepository.findById(vehicleDto.id()).isEmpty()){
            throw new NotFoundException("Vehiculo no encontrado");
        }
        if(FUEL_TYPE.get(vehicleDto.fuel_type()) == null){
            throw new BadRequestException("El combustible proporcinado no es valido");
        }
        Vehicle vehicleUpdated = this.vehicleRepository.update(this.convertDTOtoVehicle(vehicleDto));
        return this.convertVehicleToDto(vehicleUpdated);
    }

    private VehicleDto validateDTO(VehicleDto vehicleDto){
        if(
            vehicleDto.passengers() != null ||
            vehicleDto.color().isEmpty() ||
            vehicleDto.length() != null ||
            vehicleDto.brand().isEmpty() ||
            vehicleDto.fuel_type().isEmpty() ||
            vehicleDto.id() != null ||
            vehicleDto.max_speed().isEmpty() ||
            vehicleDto.model().isEmpty() ||
            vehicleDto.registration().isEmpty() ||
            vehicleDto.transmission().isEmpty() ||
            vehicleDto.weight() != null ||
            vehicleDto.width() != null ||
            vehicleDto.year() != null
        ){
            throw new BadRequestException("Los campos de registro son incorrectos");
        }

        return vehicleDto;
    }

    private VehicleDto convertVehicleToDto(Vehicle v){
        return new VehicleDto(
                v.getId(),
                v.getBrand(),
                v.getModel(),
                v.getRegistration(),
                v.getColor(),
                v.getYear(),
                v.getMax_speed(),
                v.getPassengers(),
                v.getFuel_type(),
                v.getTransmission(),
                v.getLength(),
                v.getWidth(),
                v.getWeight());
    }

    private Vehicle convertDTOtoVehicle(VehicleDto vehicleDto){
        return new Vehicle(
                vehicleDto.id(),
                vehicleDto.brand(),
                vehicleDto.model(),
                vehicleDto.registration(),
                vehicleDto.color(),
                vehicleDto.year(),
                vehicleDto.max_speed(),
                vehicleDto.passengers(),
                vehicleDto.fuel_type(),
                vehicleDto.transmission(),
                vehicleDto.length(),
                vehicleDto.width(),
                vehicleDto.weight()
        );
    }
}
