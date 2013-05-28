package com.javaegitimleri.petclinic.dao;

import com.javaegitimleri.petclinic.model.*;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.Collection;
import java.util.List;

/**
 * User: salbayrak
 * Date: 5/27/13
 * Time: 1:52 PM
 */
public class PetClinicDaoHibernateImpl implements PetClinicDao {
    @Override
    public Collection<Vet> getVets() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Collection<Vet> result = session.createQuery("from Vet v left join fetch v.specialties").list();
        session.close();
        return result;
    }

    @Override
    public Collection<Owner> findOwners(String lastName) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Collection<Owner> result = session.createQuery("from Owner o left join fetch o.pets p left join fetch p.imagesByName where o.lastName = :lastName").setParameter("lastName", lastName).list();
        session.close();
        return result;
    }

    @Override
    public Collection<Visit> findVisits(long petId) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Visit.class).
                createAlias("pet", "p").
                createAlias("p.type", "t", JoinType.LEFT_OUTER_JOIN).
                createAlias("p.imagesByName", "i", JoinType.LEFT_OUTER_JOIN).
                add(Restrictions.eq("p.id", petId));
        // Dublicate kayıtları elemine etmek için DISTINCT_ROOT_ENTITY kullandık.
        List result = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        session.close();
        return result;
    }

    @Override
    public Collection<Person> findAllPersons() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Collection<Person> result = session.createQuery("from Person").list();
        session.close();
        return result;
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
