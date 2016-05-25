package com.webapp.persistencia.dao.impl;

import com.webapp.dominio.Registro;
import com.webapp.persistencia.dao.RegistroDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RegistroDAOImplHibernate implements RegistroDAO{
    @Autowired
    SessionFactory sessionFactory;
    
    public RegistroDAOImplHibernate() {
    }
    
    @Override
    public void insert(Registro registro){
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        sessionFactory = context.getBean(SessionFactory.class);
        
        Session session = sessionFactory.getCurrentSession();
        
        session.beginTransaction();
        session.save(registro);
        session.getTransaction().commit();
    }
    
    @Override
    public Registro get(int idRegistro){
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        sessionFactory = context.getBean(SessionFactory.class);
        
        Session session = sessionFactory.getCurrentSession();
        
        session.beginTransaction();
        Registro registro = (Registro)session.get(Registro.class, idRegistro);
        session.getTransaction().commit();
        
        return registro;
    }
    
}
