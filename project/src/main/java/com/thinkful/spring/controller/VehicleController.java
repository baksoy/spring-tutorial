package com.thinkful.spring.controller;


import com.google.common.base.Preconditions;
import com.thinkful.contract.dto.*;
import com.thinkful.spring.entity.Maintenance;
import com.thinkful.spring.entity.Vehicle;
import com.thinkful.spring.entity.VehicleMake;
import com.thinkful.spring.entity.VehicleModel;
import com.thinkful.spring.mapper.DtoMapper;
import com.thinkful.spring.service.MaintenanceService;
import com.thinkful.spring.service.VehicleMakeService;
import com.thinkful.spring.service.VehicleModelService;
import com.thinkful.spring.service.VehicleService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class VehicleController {

   @Autowired
   VehicleService vehicleService;

   @Autowired
   VehicleModelService vehicleModelService;

   @Autowired
   VehicleMakeService vehicleMakeService;

   @Autowired
   MaintenanceService maintenanceService;

   @Autowired
   DtoMapper mapper;

   @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
   public HttpEntity<List<VehicleDto>> getAllVehicles() {
      List<Vehicle> vehicles = vehicleService.findAllVehicles();
      List<VehicleDto> vehicleDtos = mapper.mapAsList(vehicles, VehicleDto.class);

      return new ResponseEntity<List<VehicleDto>>(vehicleDtos, HttpStatus.OK);
   }

   @RequestMapping(value="/vehicle/mileage/{vehicleId}/{mileage}", method = RequestMethod.GET)
   public HttpEntity<VehicleDto> updateVehicleMileage(@PathVariable("vehicleId")Long vehicleId,
                                                      @PathVariable("mileage")Long mileage) {

      Preconditions.checkArgument(vehicleId != null,"Unable to update Vehicle Mileage for a null vehicleId");
      Preconditions.checkArgument(mileage != null,"Unable to update Vehicle Mileage with a null mileage");

      Vehicle vehicleEntity = vehicleService.findVehicleById(vehicleId);
      Preconditions.checkArgument(vehicleEntity != null, "No matching vehicle found for id: " + vehicleId);

      Vehicle updatedVehicleEntity = vehicleService.setVehicleMileage(vehicleEntity, mileage);
      VehicleDto vehicleDto = mapper.map(updatedVehicleEntity, VehicleDto.class);

      return new ResponseEntity<VehicleDto>(vehicleDto, HttpStatus.OK);
   }

   @RequestMapping(value = "/vehicle", method = RequestMethod.POST)
   public HttpEntity<VehicleDto> createVehicle(@RequestBody VehiclePersistenceRequest vehiclePersistenceRequest) {
      Preconditions.checkArgument(vehiclePersistenceRequest != null);

      VehicleMake vehicleMakeEntity = vehicleMakeService.findById(vehiclePersistenceRequest.getMakeId());
      Preconditions.checkArgument(vehicleMakeEntity != null, "No matching vehicle make found");

      VehicleModel vehicleModelEntity = vehicleModelService.findById(vehiclePersistenceRequest.getModelId());
      Preconditions.checkArgument(vehicleModelEntity != null, "No matching vehicle model found");

//      Vehicle vehicleEntity = vehicleService.createVehicle(vehicleModelEntity, vehiclePersistenceRequest.getColor());
      Vehicle vehicleEntity = vehicleService.createVehicle(vehicleMakeEntity, vehicleModelEntity);
      VehicleDto vehicleDto = mapper.map(vehicleEntity, VehicleDto.class);

      return new ResponseEntity<VehicleDto>(vehicleDto, HttpStatus.OK);
   }

   @RequestMapping(value = "/vehicle", method = RequestMethod.PUT)
   public HttpEntity<VehicleDto> updateVehicle(@RequestBody VehiclePersistenceRequest vehiclePersistenceRequest) {
      Preconditions.checkArgument(vehiclePersistenceRequest != null);


      Vehicle vehicleEntity = vehicleService.findVehicleById(vehiclePersistenceRequest.getId());
      Preconditions.checkArgument(vehicleEntity != null, "No matching vehicle found");

      if (vehicleEntity.getModel().getId() != vehiclePersistenceRequest.getModelId()) {

         VehicleModel vehicleModel = vehicleModelService.findById(vehiclePersistenceRequest.getModelId());
         Preconditions.checkArgument(vehicleModel != null, "No matching vehicle model found");

         vehicleEntity.setModel(vehicleModel);
      }

      if (vehicleEntity.getMake().getId() != vehiclePersistenceRequest.getMakeId()) {

         VehicleMake vehicleMake = vehicleMakeService.findById(vehiclePersistenceRequest.getMakeId());
         Preconditions.checkArgument(vehicleMake != null, "No matching vehicle make found");

         vehicleEntity.setMake(vehicleMake);
      }

      if (vehicleEntity.getMake().getId() != vehiclePersistenceRequest.getMakeId()) {
         VehicleMake vehicleMake = vehicleMakeService.findById(vehiclePersistenceRequest.getMakeId());
         Preconditions.checkArgument(vehicleMake != null, "No matching vehicle make found");

         vehicleEntity.setMake(vehicleMake);
      }

      //vehicleEntity.setColor(vehiclePersistenceRequest.getColor());


      Vehicle updatedVehicleEntity = vehicleService.updateVehicle(vehicleEntity);
      VehicleDto updatedVehicleDto = mapper.map(updatedVehicleEntity, VehicleDto.class);


      return new ResponseEntity<VehicleDto>(updatedVehicleDto, HttpStatus.OK);
   }

   @RequestMapping(value = "/vehicle-models", method = RequestMethod.GET)
   public HttpEntity<List<VehicleModelDto>> getAllVehicleModels() {


      List<VehicleModel> vehicleModels = vehicleModelService.findAllVehicleModels();


//        List<VehicleModelDto> vehicleModelDtos = new ArrayList<VehicleModelDto>();
//        for (VehicleModel vehicleModel: vehicleModels) {
//            VehicleModelDto vehicleModelDto = new VehicleModelDto();
//            vehicleModelDto.setId(vehicleModel.getId());
//            vehicleModelDto.setName(vehicleModel.getName());
//            vehicleModelDtos.add(vehicleModelDto);
//        }
      List<VehicleModelDto> vehicleModelDtos = mapper.mapAsList(vehicleModels, VehicleModelDto.class);


      return new ResponseEntity<List<VehicleModelDto>>(vehicleModelDtos, HttpStatus.OK);
   }

   @RequestMapping(value = "/vehicle-model", method = RequestMethod.POST)
   public HttpEntity<VehicleModelDto> createVehicleModel(@RequestBody VehicleModelDto vehicleModelRequest) {
      Preconditions.checkArgument(vehicleModelRequest != null);

      VehicleModel vehicleModelEntity = vehicleModelService.createVehicleModel(vehicleModelRequest.getName());
      VehicleModelDto vehicleModelDto = mapper.map(vehicleModelEntity, VehicleModelDto.class);

      return new ResponseEntity<VehicleModelDto>(vehicleModelDto, HttpStatus.OK);
   }

   @RequestMapping(value = "/vehicle-model", method = RequestMethod.PUT)
   public HttpEntity<VehicleModelDto> updateVehicleModel(@RequestBody VehicleModelDto vehicleModelRequest) {
      Preconditions.checkArgument(vehicleModelRequest != null);

      VehicleModel vehicleModelEntity = vehicleModelService.findById(vehicleModelRequest.getId());
      Preconditions.checkArgument(vehicleModelEntity != null, "No matching vehicle model found");

      vehicleModelEntity.setName(vehicleModelRequest.getName());

      VehicleModel updateVehicleModelEntity = vehicleModelService.updateVehicleModel(vehicleModelEntity);
      VehicleModelDto updateVehicleModelDto = mapper.map(updateVehicleModelEntity, VehicleModelDto.class);

      return new ResponseEntity<VehicleModelDto>(updateVehicleModelDto, HttpStatus.OK);
   }

   @RequestMapping(value = "/vehicle-makes", method = RequestMethod.GET)
   public HttpEntity<List<VehicleMakeDto>> getAllVehicleMakes() {
      List<VehicleMake> vehicleMakes = vehicleMakeService.findAllVehicleMakes();
      List<VehicleMakeDto> vehicleMakeDtos = mapper.mapAsList(vehicleMakes, VehicleMakeDto.class);

      return new ResponseEntity<List<VehicleMakeDto>>(vehicleMakeDtos, HttpStatus.OK);
   }

   @RequestMapping(value = "/vehicle-make", method = RequestMethod.POST)
   public HttpEntity<VehicleMakeDto> createVehicleMake(@RequestBody VehicleMakeDto vehicleMakeRequest) {
      Preconditions.checkArgument(vehicleMakeRequest != null);
      VehicleMake vehicleMakeEntity = vehicleMakeService.createVehicleMake(vehicleMakeRequest.getName());
      VehicleMakeDto vehicleMakeDto = mapper.map(vehicleMakeEntity, VehicleMakeDto.class);
      return new ResponseEntity<VehicleMakeDto>(vehicleMakeDto, HttpStatus.OK);
   }

   @RequestMapping(value = "/vehicle-make", method = RequestMethod.PUT)
   public HttpEntity<VehicleMakeDto> updateVehicleMake(@RequestBody VehicleMakeDto vehicleMakeRequest) {
      Preconditions.checkArgument(vehicleMakeRequest != null);
      VehicleMake vehicleMakeEntity = vehicleMakeService.findById(vehicleMakeRequest.getId());
      Preconditions.checkArgument(vehicleMakeEntity != null, "No matching vehicle make found");
      vehicleMakeEntity.setName(vehicleMakeRequest.getName());

      VehicleMake updateVehicleMakeEntity = vehicleMakeService.updateVehicleMake(vehicleMakeEntity);
      VehicleMakeDto updateVehicleMakeDto = mapper.map(updateVehicleMakeEntity, VehicleMakeDto.class);
      return new ResponseEntity<VehicleMakeDto>(updateVehicleMakeDto, HttpStatus.OK);
   }

   @RequestMapping(value = "/maintenance-items", method = RequestMethod.GET)
   public HttpEntity<List<MaintenanceDto>> getAllMaintenanceItems() {
      List<Maintenance> maintenanceItems = maintenanceService.findAllMaintenanceItems();
      List<MaintenanceDto> maintenanceDtos = mapper.mapAsList(maintenanceItems, MaintenanceDto.class);

      return new ResponseEntity<List<MaintenanceDto>>(maintenanceDtos, HttpStatus.OK);
   }

   @RequestMapping(value = "/maintenance-item", method = RequestMethod.POST)
   public HttpEntity<MaintenanceDto> createMaintenanceItem(@RequestBody MaintenanceDto maintenanceItemRequest) {
      Preconditions.checkArgument(maintenanceItemRequest != null);
      Maintenance maintenanceEntity = maintenanceService.createMaintenance(maintenanceItemRequest.getName());
      MaintenanceDto maintenanceDto = mapper.map(maintenanceEntity, MaintenanceDto.class);
      return new ResponseEntity<MaintenanceDto>(maintenanceDto, HttpStatus.OK);
   }

   @RequestMapping(value = "/maintenance-item", method = RequestMethod.PUT)
   public HttpEntity<MaintenanceDto> updatemaintenanceItem(@RequestBody MaintenanceDto maintenanceItemRequest) {
      Preconditions.checkArgument(maintenanceItemRequest != null);
      Maintenance maintenanceEntity = maintenanceService.findById(maintenanceItemRequest.getId());
      Preconditions.checkArgument(maintenanceEntity != null, "No matching maintenance item found");
      maintenanceEntity.setMaintenance(maintenanceItemRequest.getName());

      Maintenance updateMaintenanceItemEntity = maintenanceService.updateMaintenance(maintenanceEntity);
      MaintenanceDto updateMaintenanceDto = mapper.map(updateMaintenanceItemEntity, MaintenanceDto.class);
      return new ResponseEntity<MaintenanceDto>(updateMaintenanceDto, HttpStatus.OK);
   }

}
