package com.javaegitimleri.petclinic.service;

import java.util.Collection;

import com.javaegitimleri.petclinic.dao.PetClinicDao;
import com.javaegitimleri.petclinic.model.Owner;
import com.javaegitimleri.petclinic.model.Person;
import com.javaegitimleri.petclinic.model.Pet;
import com.javaegitimleri.petclinic.model.Vet;
import com.javaegitimleri.petclinic.model.Visit;

public class PetClinicServiceImpl implements PetClinicService {
	
	private PetClinicDao petClinicDao;

	public PetClinicServiceImpl(PetClinicDao petClinicDao) {
		this.petClinicDao = petClinicDao;
	}

	public Collection<Vet> getVets() {
		return petClinicDao.getVets();
	}

	public Collection<Owner> findOwners(String lastName) {
		return petClinicDao.findOwners(lastName);
	}

	public Collection<Visit> findVisits(long petId) {
		return petClinicDao.findVisits(petId);
	}

	public Collection<Person> findAllPersons() {
		return petClinicDao.findAllPersons();
	}

	public Owner loadOwner(long id) {
		return petClinicDao.loadOwner(id);
	}

	public Pet loadPet(long id) {
		return petClinicDao.loadPet(id);
	}

	public Vet loadVet(long id) {
		return petClinicDao.loadVet(id);
	}

	public long saveOwner(Owner owner) {
		petClinicDao.saveOwner(owner);
		return owner.getId();
	}

	public void saveVet(Vet vet) {
		petClinicDao.saveVet(vet);
	}

	public void deleteOwner(long ownerId) {
		petClinicDao.deleteOwner(ownerId);
	}

}
