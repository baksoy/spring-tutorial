package com.thinkful.contract.dto;

import lombok.Data;
import org.joda.time.DateTime;

@Data
public class VehicleDto {
    private Long id;
    private Long lastMileage;
    private DateTime lastMileageDate;
    private VehicleMakeDto make;
    private VehicleModelDto model;
}
