package com.thinkful.spring.service.impl;

import com.google.common.base.Preconditions;
import com.thinkful.spring.dao.MaintenanceDao;
import com.thinkful.spring.entity.Maintenance;
import com.thinkful.spring.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

   @Autowired
   MaintenanceDao maintenanceDao;

   @Override
   @Transactional
   public Maintenance createMaintenance(String maintenanceItem) {
      Preconditions.checkArgument(maintenanceItem != null, "Maintenance Item cannot be null");

      Maintenance maintenance = new Maintenance();
      maintenance.setMaintenance(maintenanceItem);
      maintenanceDao.create(maintenance);

      return maintenance;
   }

   @Override
   @Transactional
   public Maintenance updateMaintenance(Maintenance maintenance) {
      Preconditions.checkArgument(maintenance != null, "Maintenance Item cannot be null");
      Preconditions.checkArgument(maintenance.getId() > 0, "Maintenance id should be greater than zero");
      return maintenanceDao.update(maintenance);
   }

   @Override
   @Transactional(readOnly = true)
   public Maintenance findById(int id) {
      return maintenanceDao.findById(id);
   }

   @Override
   @Transactional(readOnly = true)
   public List<Maintenance> findAllMaintenanceItems() {
      return maintenanceDao.findAll();
   }

   @Override
   @Transactional
   public void deleteMaintenanceItem(int maintenanceId) {
      maintenanceDao.deleteById(maintenanceId);
   }
}
