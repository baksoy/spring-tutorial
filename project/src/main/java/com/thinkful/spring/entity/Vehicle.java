package com.thinkful.spring.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne(targetEntity = VehicleMake.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiclemake_id")
    private VehicleMake make;

    @ManyToOne(targetEntity = VehicleModel.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiclemodel_id")
    private VehicleModel model;

    @Column(nullable = true, name = "last_mileage")
    private Long lastMileage;

    @Column(nullable = true, name = "last_mileage_date")
    private Date lastMileageDate;

    public Vehicle() {
    }

    public long getId() {
        return this.id;
    }

    public VehicleMake getMake() {
        return this.make;
    }

    public VehicleModel getModel() {
        return this.model;
    }

    public Long getLastMileage() {
        return this.lastMileage;
    }

    public Date getLastMileageDate() {
        return this.lastMileageDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMake(VehicleMake make) {
        this.make = make;
    }

    public void setModel(VehicleModel model) {
        this.model = model;
    }

    public void setLastMileage(Long lastMileage) {
        this.lastMileage = lastMileage;
    }

    public void setLastMileageDate(Date lastMileageDate) {
        this.lastMileageDate = lastMileageDate;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Vehicle)) return false;
        final Vehicle other = (Vehicle) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.id != other.id) return false;
        final Object this$make = this.make;
        final Object other$make = other.make;
        if (this$make == null ? other$make != null : !this$make.equals(other$make)) return false;
        final Object this$model = this.model;
        final Object other$model = other.model;
        if (this$model == null ? other$model != null : !this$model.equals(other$model)) return false;
        final Object this$lastMileage = this.lastMileage;
        final Object other$lastMileage = other.lastMileage;
        if (this$lastMileage == null ? other$lastMileage != null : !this$lastMileage.equals(other$lastMileage))
            return false;
        final Object this$lastMileageDate = this.lastMileageDate;
        final Object other$lastMileageDate = other.lastMileageDate;
        if (this$lastMileageDate == null ? other$lastMileageDate != null : !this$lastMileageDate.equals(other$lastMileageDate))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.id;
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $make = this.make;
        result = result * PRIME + ($make == null ? 0 : $make.hashCode());
        final Object $model = this.model;
        result = result * PRIME + ($model == null ? 0 : $model.hashCode());
        final Object $lastMileage = this.lastMileage;
        result = result * PRIME + ($lastMileage == null ? 0 : $lastMileage.hashCode());
        final Object $lastMileageDate = this.lastMileageDate;
        result = result * PRIME + ($lastMileageDate == null ? 0 : $lastMileageDate.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Vehicle;
    }

    public String toString() {
        return "com.thinkful.spring.entity.Vehicle(id=" + this.id + ", make=" + this.make + ", model=" + this.model + ", lastMileage=" + this.lastMileage + ", lastMileageDate=" + this.lastMileageDate + ")";
    }
}