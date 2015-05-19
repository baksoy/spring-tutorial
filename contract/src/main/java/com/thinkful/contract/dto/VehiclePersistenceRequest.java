package com.thinkful.contract.dto;

import lombok.Data;

@Data
public class VehiclePersistenceRequest {
    private Long id;
    private Integer makeId;
    private Integer modelId;
    private String color;
}
