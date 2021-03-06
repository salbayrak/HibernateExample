package com.javaegitimleri.petclinic.tests;

import com.javaegitimleri.petclinic.dao.HibernateUtils;
import com.javaegitimleri.petclinic.dao.PetClinicDao;
import com.javaegitimleri.petclinic.dao.PetClinicDaoHibernateImpl;
import com.javaegitimleri.petclinic.model.*;
import junit.framework.Assert;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

/**
 * User: salbayrak
 * Date: 5/26/13
 * Time: 11:27 AM
 */
public class HibernateTests {

    private PetClinicDaoHibernateImpl petClinicDaoHibernateImpl;

    @Before
    public void testHibernateSetup() {
        petClinicDaoHibernateImpl = new PetClinicDaoHibernateImpl();
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
        o.setFirstName("Denem");
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

    @Test
    public void testHQL() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Owner> list = session.createQuery("select distinct o from Owner o join fetch o.pets p where p.name like 'L%'").list();
        session.close();
        System.out.println(list.get(0).getPets().size());
    }

    @Test
    public void testHQLTwo() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Owner> list = session.createQuery("select distinct o from Owner o join fetch o.pets p left join fetch p.visits left join fetch  p.imagesByName where p.name like 'L%'").list();
        session.close();
        System.out.println(list.get(0).getPets());
    }

    @Test
    public void testGetVets() {
        Collection<Vet> vets = petClinicDaoHibernateImpl.getVets();
        for(Vet v : vets) {
            System.out.println(v);
        }
    }

    @Test
    public void testFindOwners() {
        Collection<Owner> owners = petClinicDaoHibernateImpl.findOwners("SEDA");
        for(Owner o : owners) {
            System.out.println(o);
        }
    }

    @Test
    public void testFindVisits() {
        Collection<Visit> visits = petClinicDaoHibernateImpl.findVisits(7L);
        for(Visit v: visits) {
            System.out.println(v);
        }
    }

   @Test
   public void testConversation() {
       // No CurrentSessionContext configured! hatası verir,
       // fakat hibernate.cfg.xml'e hibernate.current_session_context_class
       // property'sini thread olarak eklersek çalışır
       HibernateUtils.getSessionFactory().getCurrentSession();
   }

    @Test
    public void testConversationTwo() {
        Session session1 = HibernateUtils.getSessionFactory().getCurrentSession();
        Session session2 = HibernateUtils.getSessionFactory().getCurrentSession();

        Assert.assertSame(session1,session2);
    }

    @Test
    public void testConversationTwoNotSame() {
        Session session1 = HibernateUtils.getSessionFactory().getCurrentSession();
        session1.beginTransaction().commit();
        Session session2 = HibernateUtils.getSessionFactory().getCurrentSession();

        Assert.assertNotSame(session1,session2);
    }
}
