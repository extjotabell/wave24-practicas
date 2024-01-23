package com.bootcampW22.EjercicioGlobal.util;

import com.bootcampW22.EjercicioGlobal.dto.MessageDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public class Utils {
    public VehicleDto getVehicleDto(){
        return new VehicleDto(1, "Pontiac", "Fiero",
                "6603", "Mauv", 1986, "85",
                2, "gasoline", "semi-automatic",
                105.43, 280.28, 288.8);
    }

    public VehicleDto getNewVehicleDto(){
        return new VehicleDto(501, "Pontiac", "Fiero",
                "6603", "Mauv", 1986, "85",
                2, "gasoline", "semi-automatic",
                105.43, 280.28, 288.8);
    }

    public VehicleDto getDummyVehicleDto(){
        return new VehicleDto(501, "Pontiac", "Fiero",
                "6603", "Mauv", 1986, "85",
                2, "gasoline", "semi-automatic",
                105.43, 280.28, 288.8);
    }

    public Vehicle getVehicle(){
        return new Vehicle(1, "Pontiac", "Fiero",
                "6603", "Mauv", 1986, "85",
                2, "gasoline", "semi-automatic",
                105.43, 280.28, 288.8);
    }

    public Vehicle getNewVehicle(){
        return new Vehicle(501, "Pontiac", "Fiero",
                "6603", "Mauv", 1986, "85",
                2, "gasoline", "semi-automatic",
                105.43, 280.28, 288.8);
    }

    public Vehicle getModifiedVehicle(){
        return new Vehicle(1, "Pontiac", "Fiero",
                "6603", "Mauv", 1986, "90",
                2, "gasoline", "semi-automatic",
                105.43, 280.28, 288.8);
    }

    public Vehicle getDummyVehicle(){
        return new Vehicle(2, "Pontiac", "Fiero",
                "6603", "Mauv", 1986, "90",
                4, "gasoline", "semi-automatic",
                105.43, 280.28, 288.8);
    }

    public List<Vehicle> getAListOfVehicle(){
        return List.of(getVehicle());
    }

    public List<VehicleDto> getAListOfVehicleDto(){
        return List.of(getVehicleDto());
    }

    public MessageDto getAddedMessageDto(){
        return new MessageDto("Se agrego correctamente.");
    }
}
