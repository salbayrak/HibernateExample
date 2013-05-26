package com.javaegitimleri.petclinic.tests;

import com.javaegitimleri.petclinic.dao.HibernateUtils;
import com.javaegitimleri.petclinic.model.Foo;
import com.javaegitimleri.petclinic.model.Owner;
import com.javaegitimleri.petclinic.model.Pet;
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
        Foo foo = new Foo("xxx");
        session.save(foo);
        transaction.commit();
        session.close();
    }

    @Test
    public void testOneToManyBiDirectional() {
        Owner o = new Owner();
        Owner o2 = new Owner();

        Pet pet = new Pet();

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        session.save(o);
        session.save(o2);

        session.save(pet);

        o.getPets().add(pet);
        pet.setOwner(o2);

        transaction.commit();
    }
}
