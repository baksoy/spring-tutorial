package com.thinkful.contract.dto;

import lombok.*;

@Data
public class VehiclePersistenceRequest {
    private Long id;
    private Integer makeId;
    private Integer modelId;
    private String color;

   public VehiclePersistenceRequest() {
   }

   protected boolean canEqual(Object other) {
      return other instanceof VehiclePersistenceRequest;
   }

}
