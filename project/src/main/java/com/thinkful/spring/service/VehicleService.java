package com.thinkful.spring.service;


import com.thinkful.spring.entity.Vehicle;
import com.thinkful.spring.entity.VehicleMake;
import com.thinkful.spring.entity.VehicleModel;

import java.util.List;

public interface VehicleService {

    Vehicle createVehicle(VehicleMake vehicleMake, VehicleModel model, String color);
    Vehicle updateVehicle(Vehicle vehicle);
    List<Vehicle> findAllVehicles();
    Vehicle findVehicleById(long id);
    void deleteVehicle(long vehicleId);
}
