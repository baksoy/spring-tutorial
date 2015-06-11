package com.thinkful.spring.dao;


import java.util.List;

public interface CrudDao<ENTITY_TYPE, PK_TYPE> {

    ENTITY_TYPE findById (PK_TYPE id);

    List<ENTITY_TYPE> findAll();

    void create(ENTITY_TYPE entity);

    ENTITY_TYPE update(ENTITY_TYPE entity);

    void delete(ENTITY_TYPE entity);

    void deleteById(PK_TYPE id);
}
