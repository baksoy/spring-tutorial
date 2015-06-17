package com.thinkful.contract.dto;

import org.joda.time.DateTime;

public class VehicleDto {
    private Long id;
    private Long lastMileage;
    private DateTime lastMileageDate;
    private VehicleMakeDto make;
    private VehicleModelDto model;

    public VehicleDto() {
    }

    public Long getId() {
        return this.id;
    }

    public Long getLastMileage() {
        return this.lastMileage;
    }

    public DateTime getLastMileageDate() {
        return this.lastMileageDate;
    }

    public VehicleMakeDto getMake() {
        return this.make;
    }

    public VehicleModelDto getModel() {
        return this.model;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastMileage(Long lastMileage) {
        this.lastMileage = lastMileage;
    }

    public void setLastMileageDate(DateTime lastMileageDate) {
        this.lastMileageDate = lastMileageDate;
    }

    public void setMake(VehicleMakeDto make) {
        this.make = make;
    }

    public void setModel(VehicleModelDto model) {
        this.model = model;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof VehicleDto)) return false;
        final VehicleDto other = (VehicleDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.id;
        final Object other$id = other.id;
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$lastMileage = this.lastMileage;
        final Object other$lastMileage = other.lastMileage;
        if (this$lastMileage == null ? other$lastMileage != null : !this$lastMileage.equals(other$lastMileage))
            return false;
        final Object this$lastMileageDate = this.lastMileageDate;
        final Object other$lastMileageDate = other.lastMileageDate;
        if (this$lastMileageDate == null ? other$lastMileageDate != null : !this$lastMileageDate.equals(other$lastMileageDate))
            return false;
        final Object this$make = this.make;
        final Object other$make = other.make;
        if (this$make == null ? other$make != null : !this$make.equals(other$make)) return false;
        final Object this$model = this.model;
        final Object other$model = other.model;
        if (this$model == null ? other$model != null : !this$model.equals(other$model)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.id;
        result = result * PRIME + ($id == null ? 0 : $id.hashCode());
        final Object $lastMileage = this.lastMileage;
        result = result * PRIME + ($lastMileage == null ? 0 : $lastMileage.hashCode());
        final Object $lastMileageDate = this.lastMileageDate;
        result = result * PRIME + ($lastMileageDate == null ? 0 : $lastMileageDate.hashCode());
        final Object $make = this.make;
        result = result * PRIME + ($make == null ? 0 : $make.hashCode());
        final Object $model = this.model;
        result = result * PRIME + ($model == null ? 0 : $model.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof VehicleDto;
    }

    public String toString() {
        return "com.thinkful.contract.dto.VehicleDto(id=" + this.id + ", lastMileage=" + this.lastMileage + ", lastMileageDate=" + this.lastMileageDate + ", make=" + this.make + ", model=" + this.model + ")";
    }
}
