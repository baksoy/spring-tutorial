package com.thinkful.spring.entity;

import javax.persistence.*;

@Entity
@Table(name="MAINTENANCE")

public class Maintenance {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private int id;

   @Column(nullable = false)
   private String maintenance;

   @Column
   private String desc_;

   public Maintenance() {
   }

   protected boolean canEqual(Object other) {
      return other instanceof Maintenance;
   }

   public int getId() {
      return this.id;
   }

   public String getMaintenance() {
      return this.maintenance;
   }

   public String getDesc_() {
      return this.desc_;
   }

   public void setId(int id) {
      this.id = id;
   }

   public void setMaintenance(String maintenance) {
      this.maintenance = maintenance;
   }

   public void setDesc_(String desc_) {
      this.desc_ = desc_;
   }

   public boolean equals(Object o) {
      if (o == this) return true;
      if (!(o instanceof Maintenance)) return false;
      final Maintenance other = (Maintenance) o;
      if (!other.canEqual((Object) this)) return false;
      if (this.id != other.id) return false;
      final Object this$maintenance = this.maintenance;
      final Object other$maintenance = other.maintenance;
      if (this$maintenance == null ? other$maintenance != null : !this$maintenance.equals(other$maintenance))
         return false;
      final Object this$desc_ = this.desc_;
      final Object other$desc_ = other.desc_;
      if (this$desc_ == null ? other$desc_ != null : !this$desc_.equals(other$desc_)) return false;
      return true;
   }

   public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      result = result * PRIME + this.id;
      final Object $maintenance = this.maintenance;
      result = result * PRIME + ($maintenance == null ? 0 : $maintenance.hashCode());
      final Object $desc_ = this.desc_;
      result = result * PRIME + ($desc_ == null ? 0 : $desc_.hashCode());
      return result;
   }

   public String toString() {
      return "com.thinkful.spring.entity.Maintenance(id=" + this.id + ", maintenance=" + this.maintenance + ", desc_=" + this.desc_ + ")";
   }
}
