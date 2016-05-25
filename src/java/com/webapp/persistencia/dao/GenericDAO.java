package com.webapp.persistencia.dao;

import java.io.Serializable;

public interface GenericDAO<T,ID extends Serializable> {
    T create() throws Exception;
    void saveOrUpdate(T entity) throws Exception;
    T get(ID id) throws Exception;
}
