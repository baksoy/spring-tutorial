package com.thinkful.spring.service;


import com.thinkful.spring.entity.VehicleModel;

import java.util.List;

public interface VehicleModelService {
    VehicleModel createVehicleModel(String modelName);
    VehicleModel updateVehicleModel(VehicleModel vehicleModel);
    VehicleModel findById(int id);
    List<VehicleModel> findAllVehicleModels();
    void deleteVehicleModel(int vehicleModelId);
}
