package com.thinkful.spring.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.thinkful.spring.dao.VehicleModelDao;
import com.thinkful.spring.entity.VehicleModel;
import com.thinkful.spring.service.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleModelServiceImpl implements VehicleModelService {

    @Autowired
    VehicleModelDao vehicleModelDao;

    @Override
    @Transactional
    public VehicleModel createVehicleModel(String modelName) {
        Preconditions.checkArgument(modelName != null, "modelName cannot be null");

        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setName(modelName);

        vehicleModelDao.create(vehicleModel);

        return vehicleModel;
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehicleModel> findAllVehicleModels() {
        return vehicleModelDao.findAll();
    }

    @Override
    @Transactional
    public void deleteVehicleModel(int vehicleModelId) {
        vehicleModelDao.deleteById(vehicleModelId);
    }
}
