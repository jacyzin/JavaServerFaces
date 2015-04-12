package com.docyousign.pizzeria.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	    private static final SessionFactory sessionFactory;
	    private static final Configuration configuration;
	    
	    static {
	       configuration = new Configuration().configure();
	       sessionFactory = configuration.buildSessionFactory();
	    }

	    public static SessionFactory getSessionFactory() {
	       return sessionFactory;
	    }  
	    
	    public static Configuration getConfiguration() {
	        return configuration;
	     } 
    
}