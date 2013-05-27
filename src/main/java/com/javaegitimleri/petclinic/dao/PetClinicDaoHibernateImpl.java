package com.javaegitimleri.petclinic.dao;

import com.javaegitimleri.petclinic.model.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;

/**
 * User: salbayrak
 * Date: 5/27/13
 * Time: 1:52 PM
 */
public class PetClinicDaoHibernateImpl implements PetClinicDao {
    @Override
    public Collection<Vet> getVets() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Owner> findOwners(String lastName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Visit> findVisits(long petId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Person> findAllPersons() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Owner loadOwner(long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Owner o = (Owner) session.load(Owner.class, id);
        /**
         * testLoadOwner testinde LazyInitializationException almamak için
         * 1.yol: Hibernate.initialize(o);
         * 2.yol: o.getId();
         * Ancak her iki yol da uygun çözüm değil.
         * load ekranda bir takım dataları display ederken kullanmaya
         * uygun değil.  Bu noktada hql (hibernate query language) kullanmak
         * daha doğru.
         */
        o.getId();
        session.close();
        return o;
    }

    @Override
    public Pet loadPet(long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Pet p = (Pet) session.get(Pet.class, id);
        session.close();
        return p;
    }

    @Override
    public Vet loadVet(long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Vet vet = (Vet) session.createQuery("from Vet v where v.id = ?").setParameter(0, id).uniqueResult();
        session.close();
        return vet;
    }

    @Override
    public void saveOwner(Owner owner) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(owner);
        transaction.commit();
        session.close();
    }

    @Override
    public void saveVet(Vet vet) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(vet);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteOwner(long ownerId) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.load(Owner.class, ownerId));
        transaction.commit();
        session.close();
    }
}
