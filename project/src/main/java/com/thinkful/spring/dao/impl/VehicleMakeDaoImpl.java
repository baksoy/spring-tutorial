package com.thinkful.spring.dao.impl;

import com.thinkful.spring.dao.VehicleMakeDao;
import com.thinkful.spring.entity.VehicleMake;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleMakeDaoImpl extends AbstractCrudDao<VehicleMake, Integer> implements VehicleMakeDao {
}
