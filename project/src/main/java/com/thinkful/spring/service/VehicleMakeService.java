package com.thinkful.spring.service;


import com.thinkful.spring.entity.VehicleMake;

import java.util.List;

public interface VehicleMakeService {
   VehicleMake createVehicleMake (String makeName);
   VehicleMake updateVehicleMake (VehicleMake vehicleMake);
   VehicleMake findById(int id);
   List<VehicleMake> findAllVehicleMakes();
   void deleteVehicleMake(int vehicleMakeId);
}
