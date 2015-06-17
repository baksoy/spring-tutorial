package com.thinkful.spring.dao.impl;

import com.googlecode.genericdao.dao.DAOUtil;
import com.thinkful.spring.dao.CrudDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class AbstractCrudDao<ENTITY_TYPE, PK_TYPE> implements CrudDao<ENTITY_TYPE, PK_TYPE> {

    private Class<ENTITY_TYPE> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    protected AbstractCrudDao() {
        clazz = (Class<ENTITY_TYPE>)DAOUtil.getTypeArguments(AbstractCrudDao.class, this.getClass()).get(0);
    }

    @Override
    public ENTITY_TYPE findById(PK_TYPE id) {
        return entityManager.find(clazz, id);
    }

//    "from " + clazz.getName() - is the HQL to get all the data
    @Override
    public List<ENTITY_TYPE> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    @Override
    public void create(ENTITY_TYPE entity) {
        entityManager.persist(entity);
    }

    @Override
    public ENTITY_TYPE update(ENTITY_TYPE entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(ENTITY_TYPE entity) {
        entityManager.remove(entity);
    }

    @Override
    public void deleteById(PK_TYPE id) {
        delete(findById(id));
    }
}
