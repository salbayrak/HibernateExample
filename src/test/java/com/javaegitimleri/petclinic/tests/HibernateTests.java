package com.javaegitimleri.petclinic.tests;

import com.javaegitimleri.petclinic.dao.HibernateUtils;
import com.javaegitimleri.petclinic.model.Foo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * User: salbayrak
 * Date: 5/26/13
 * Time: 11:27 AM
 */
public class HibernateTests {
    @Test
    public void testHibernateSetup() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Foo foo = new Foo();
        foo.setName("xxx");
        foo.setId(1L);
        session.save(foo);
        transaction.commit();
        session.close();
    }
}
