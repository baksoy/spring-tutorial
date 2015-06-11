package com.thinkful.spring.service;


import com.thinkful.spring.entity.Maintenance;

import java.util.List;

public interface MaintenanceService {
   Maintenance createMaintenance (String maintenanceItem);
   Maintenance updateMaintenance (Maintenance maintenance);
   Maintenance findById(int id);
   List<Maintenance> findAllMaintenanceItems();
   void deleteMaintenanceItem(int maintenanceId);
}


