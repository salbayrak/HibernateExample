package com.javaegitimleri.petclinic.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * User: salbayrak
 * Date: 5/26/13
 * Time: 11:05 AM
 */
public class HibernateUtils {

    private static SessionFactory sessionFactory;

    static {
        AnnotationConfiguration cfg = new AnnotationConfiguration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
