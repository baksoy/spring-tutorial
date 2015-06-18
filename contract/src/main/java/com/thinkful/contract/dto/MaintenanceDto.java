package com.thinkful.contract.dto;

public class MaintenanceDto {
   private Integer id;
   private String name;
   private String desc_;

   public MaintenanceDto() {
   }

   public Integer getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getDesc_() {
      return this.desc_;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setDesc_(String desc_) {
      this.desc_ = desc_;
   }

   public boolean equals(Object o) {
      if (o == this) return true;
      if (!(o instanceof MaintenanceDto)) return false;
      final MaintenanceDto other = (MaintenanceDto) o;
      if (!other.canEqual((Object) this)) return false;
      final Object this$id = this.id;
      final Object other$id = other.id;
      if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
      final Object this$name = this.name;
      final Object other$name = other.name;
      if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
      final Object this$desc_ = this.desc_;
      final Object other$desc_ = other.desc_;
      if (this$desc_ == null ? other$desc_ != null : !this$desc_.equals(other$desc_)) return false;
      return true;
   }

   public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final Object $id = this.id;
      result = result * PRIME + ($id == null ? 0 : $id.hashCode());
      final Object $name = this.name;
      result = result * PRIME + ($name == null ? 0 : $name.hashCode());
      final Object $desc_ = this.desc_;
      result = result * PRIME + ($desc_ == null ? 0 : $desc_.hashCode());
      return result;
   }

   protected boolean canEqual(Object other) {
      return other instanceof MaintenanceDto;
   }

   public String toString() {
      return "com.thinkful.contract.dto.MaintenanceDto(id=" + this.id + ", name=" + this.name + ", desc_=" + this.desc_ + ")";
   }
}
