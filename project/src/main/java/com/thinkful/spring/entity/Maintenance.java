package com.thinkful.spring.entity;

import lombok.*;

import javax.persistence.*;

@Data
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

}
