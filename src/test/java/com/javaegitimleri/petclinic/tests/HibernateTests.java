package com.javaegitimleri.petclinic.tests;

import com.javaegitimleri.petclinic.dao.HibernateUtils;
import com.javaegitimleri.petclinic.dao.PetClinicDao;
import com.javaegitimleri.petclinic.dao.PetClinicDaoHibernateImpl;
import com.javaegitimleri.petclinic.model.Foo;
import com.javaegitimleri.petclinic.model.Owner;
import com.javaegitimleri.petclinic.model.Pet;
import com.javaegitimleri.petclinic.model.Visit;
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

        o.addPet(pet);
        //o.getPets().add(pet);
        //pet.setOwner(o2);

        transaction.commit();
    }

    @Test
    public void testSaveOwner() {
        PetClinicDaoHibernateImpl petClinicDao = new PetClinicDaoHibernateImpl();
        Owner o = new Owner();
        o.setFirstName("Yeni");
        o.setLastName("YALC");

        Pet p = new Pet();
        p.setName("miskin");

        o.addPet(p);
        petClinicDao.saveOwner(o);
    }

    @Test
    public void testLoadOwner() {
        PetClinicDaoHibernateImpl petClinicDao = new PetClinicDaoHibernateImpl();
        Owner o = petClinicDao.loadOwner(1140);
        System.out.print(o.getFirstName());
    }

    @Test
    public void testDeleteOwner() {
        PetClinicDaoHibernateImpl petClinicDao = new PetClinicDaoHibernateImpl();
        petClinicDao.deleteOwner(1040L);
    }

    @Test
    public void testFetching() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Pet pet = (Pet) session.get(Pet.class, 7L);
        System.out.println("before get visits");
    }

    @Test
    public void testPetAssociations() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Pet pet = (Pet) session.get(Pet.class, 1150L);
    }

    @Test
    /**
     * Row was updated or deleted by another transation hatası alırız,
     * id'si 7 olan person'ın version'u 1 arttırıldı.
     */
    public void testOptimisticLock() {
        Session session1 = HibernateUtils.getSessionFactory().openSession();
        Session session2 = HibernateUtils.getSessionFactory().openSession();

        Transaction tx1 = session1.beginTransaction();
        Transaction tx2 = session2.beginTransaction();

        Owner o1 = (Owner) session1.get(Owner.class, 7L);
        Owner o2 = (Owner) session2.get(Owner.class, 7L);

        o1.setLastName("taskin");
        o2.setLastName("gok");

        tx2.commit();
        System.out.println("after tx2 commit");
        tx1.commit();
    }
}
