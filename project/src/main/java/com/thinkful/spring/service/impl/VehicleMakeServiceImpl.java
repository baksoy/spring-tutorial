package com.thinkful.spring.service.impl;

import com.google.common.base.Preconditions;
import com.thinkful.spring.dao.VehicleMakeDao;
import com.thinkful.spring.entity.VehicleMake;
import com.thinkful.spring.service.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleMakeServiceImpl implements VehicleMakeService{

   @Autowired
   VehicleMakeDao vehicleMakeDao;

   @Override
   @javax.transaction.Transactional
   public VehicleMake createVehicleMake(String makeName) {
      Preconditions.checkArgument(makeName != null, "Vehicle Make cannot be null");

      VehicleMake vehicleMake = new VehicleMake();
      vehicleMake.setName(makeName);
      vehicleMakeDao.create(vehicleMake);

      return vehicleMake;
   }

   @Override
   @Transactional
   public VehicleMake updateVehicleMake(VehicleMake vehicleMake) {
      Preconditions.checkArgument(vehicleMake != null, "Vehicle Make cannot be null");
      Preconditions.checkArgument(vehicleMake.getId() > 0, "Vehicle make's id should be greater than zero");
      return vehicleMakeDao.update(vehicleMake);
   }

   @Override
   @Transactional (readOnly = true)
   public VehicleMake findById(int id) {
      return vehicleMakeDao.findById(id);
   }

   @Override
   @Transactional (readOnly = true)
   public List<VehicleMake> findAllVehicleMakes() {
      return vehicleMakeDao.findAll();
   }

   @Override
   @Transactional
   public void deleteVehicleMake(int vehicleMakeId) {
      vehicleMakeDao.deleteById(vehicleMakeId);
   }
}
