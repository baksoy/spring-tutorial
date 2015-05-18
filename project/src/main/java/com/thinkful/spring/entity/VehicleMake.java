package com.thinkful.spring.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "VEHICLEMAKE")
@Data

public class VehicleMake {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private int id;

   @Column(nullable = false)
   private String name;

}
