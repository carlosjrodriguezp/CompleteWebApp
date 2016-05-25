package com.webapp.persistencia.dao.impl;

import com.webapp.persistencia.dao.GenericDAO;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author carlos.r
 */
public class GenericDAOImplHibernate<T,ID extends Serializable> implements GenericDAO<T,ID>{
    @Autowired
    SessionFactory sessionFactory;
    
    public GenericDAOImplHibernate(){
    }
    
    @Override
    public T create(){
        try {
            return getEntityClass().newInstance();
        } catch (RuntimeException ex) {
            throw ex;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void saveOrUpdate(T entity) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
    }

    @Override
    public T get(ID id) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        T entity = (T) session.get(getEntityClass(), id);
        session.getTransaction().commit();
        
        return entity;
    }
    
    private Class<T> getEntityClass(){
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
