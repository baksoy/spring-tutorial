package com.thinkful.spring.dao.impl;


import com.thinkful.spring.dao.MaintenanceDao;
import com.thinkful.spring.entity.Maintenance;
import org.springframework.stereotype.Repository;

@Repository
public class MaintenanceDaoImpl extends AbstractCrudDao<Maintenance, Integer> implements MaintenanceDao{
}

