package com.thinkful.spring.service;

import com.thinkful.spring.config.MainConfiguration;
import com.thinkful.spring.config.Profiles;
import com.thinkful.spring.entity.Vehicle;
import com.thinkful.spring.entity.VehicleMake;
import com.thinkful.spring.entity.VehicleModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {MainConfiguration.class})
@ActiveProfiles(profiles = Profiles.DEFAULT)
public class VehicleServiceTest {

    @Autowired
    VehicleModelService vehicleModelService;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    VehicleMakeService vehicleMakeService;

    @Test(expected = IllegalArgumentException.class)
    public void testCreateVehicleErrorNullModel() {
        vehicleService.createVehicle(null, null);
    }

    @Test
    public void vehicleCreation() {
        VehicleModel vehicleModel = vehicleModelService.createVehicleModel("model");
        Assert.assertNotNull(vehicleModel);

        VehicleMake vehicleMake= vehicleMakeService.createVehicleMake("make");
        Assert.assertNotNull(vehicleMake);

        Vehicle vehicle = vehicleService.createVehicle(vehicleMake, vehicleModel);
        Assert.assertNotNull(vehicle);
        Assert.assertTrue("The primary key was not properly assigned", vehicle.getId() > 0);
        Assert.assertNotNull(vehicle.getModel());
        Assert.assertEquals("model", vehicle.getModel().getName());
//        Assert.assertEquals("Red", vehicle.getColor());

        vehicleService.deleteVehicle(vehicle.getId());
        vehicleModelService.deleteVehicleModel(vehicleModel.getId());
    }

    @Test
    public void testVehicleFinding() {
        //Step 1... Checking that there are no vehicles in the database
        List<Vehicle> allVehicles = vehicleService.findAllVehicles();
        Assert.assertNotNull(allVehicles);
        Assert.assertTrue(allVehicles.size() == 0);

        //Step 2... Creating 10 vehicles.
        VehicleModel model = vehicleModelService.createVehicleModel("model");
        VehicleMake make = vehicleMakeService.createVehicleMake("make");

        int vecicleCreationCount = 10;
        for (int i=0; i<vecicleCreationCount; i++) {
            vehicleService.createVehicle(make, model);
        }

        //Step 3... Checking that there are 10 vehicle in the database
        allVehicles = vehicleService.findAllVehicles();
        Assert.assertNotNull(allVehicles);
        Assert.assertTrue(allVehicles.size() == vecicleCreationCount);

        //Step 4... Deleting all vehicles that were created
        for (Vehicle vehicle: allVehicles) {
            vehicleService.deleteVehicle(vehicle.getId());
        }
        vehicleModelService.deleteVehicleModel(model.getId());

        //Step 5... Checking that the vehicle have all been deleted
        allVehicles = vehicleService.findAllVehicles();
        Assert.assertNotNull(allVehicles);
        Assert.assertTrue(allVehicles.size() == 0);
    }
}
