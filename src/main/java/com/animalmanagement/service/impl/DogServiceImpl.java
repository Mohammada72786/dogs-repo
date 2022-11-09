package com.animalmanagement.service.impl;

import java.util.Date;
import java.util.List;

import com.animalmanagement.dao.DogDao;
import com.animalmanagement.dao.impl.DogDaoImpl;
import com.animalmanagement.model.Dog;
import com.animalmanagement.model.Food;
import com.animalmanagement.model.PetStore;
import com.animalmanagement.service.DogService;
import com.animalmanagement.util.constant.Gender;
import com.animalmanagement.util.exception.AnimalManagementException;

public class DogServiceImpl implements DogService {

	private DogDao dogDao = new DogDaoImpl();

	/**
	 * This method is used to add the dog in the list of dogs.
	 *
	 * @param name   It is used to set the name of dog.
	 * @param breed  It is used to set the breed of the dog.
	 * @param weight It is used to set the weight of the dog.
	 * @param colour It is used to set the color of the dog.
	 * @param gender It is used to set the color of the dog.
	 * @param dob    it Is used to set the date of birth of the dog.
	 * @return dog. It returns the dog to the method from where it is called.
	 */
	public Dog insertDog(String name, float weight, String colour, Gender gender, Date dateOfBirth, float speed)
			throws AnimalManagementException {
		String dogCode = dogDao.generateDogCode();
		Dog dog = new Dog(name, weight, colour, gender, dateOfBirth, speed, dogCode);
		return dogDao.insertDog(dog);
	}

	/**
	 * Gets id as a parameter from the controller class and sends back a dog that
	 * matches the id.
	 * 
	 * @param id It is a unique field of dog class on which we can find a particular
	 *           dog among list of dogs.
	 */
	public Dog getDogByDogCode(String dogCode) throws AnimalManagementException {
		return dogDao.getDogByDogCode(dogCode);
	}

	/**
	 * This method is used to update the old values of cat with new values.
	 *
	 * @param option   It is to used to find the field of cat that a user wants to
	 *                 update.
	 * @param newvalue it is new value that will replace old value.
	 * @param Id       It is used to find a particular cat, that needs update.
	 */
	public Dog updateDogByDogCode(Dog dog) throws AnimalManagementException {
		return dogDao.updateDogByDogCode(dog);
	}

	/**
	 * This method takes animal id as parameter and checks for a dog. If there will
	 * be any dog with given id, it will remove that dog and true will be returned;
	 * If there will not be any dog with given, it will return false.
	 *
	 * @param id It is animal id of dog.
	 * @return true/false
	 */
	public boolean deleteDogByDogCode(String dogCode) throws AnimalManagementException {

		if (dogDao.deleteDogByDogCode(dogCode) > 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * It makes a list of all those objects that starts with given value.
	 *
	 * @param name It is a user input to search the dogs.
	 * @return list of filtered dogs that starts with given name.
	 */
	public List<Dog> getDogsByName(String name) throws AnimalManagementException {
		List<Dog> dogs = dogDao.getDogsByName(name);
		if (dogs.isEmpty()) {
			return null;
		} else {
			return dogs;
		}
	}

	/**
	 * It gets first and last ids of the range and passes to the DAO class.
	 * 
	 * @param firstId. First id of range.
	 * @param lastId.  Last id of the range. @ return. return list of dogs between
	 *                 the given ids. Or null if no data found.
	 */

	public List<Dog> getDogsBetweenDogCodes(String firstId, String secondId) throws AnimalManagementException {
		return dogDao.getDogsBetweenDogCodes(firstId, secondId);

	}
	// to do
	/*
	 * public Dog getDogWithFoods(String dogCode) { return
	 * dogDao.getDogWithFoods(dogCode); }
	 */

	public List<Dog> getDogsBetweenBirthDates(Date startingDateOfBirth, Date endingDateOfBirth)
			throws AnimalManagementException {
		List<Dog> dogs = dogDao.getDogsBetweenBirthDates(startingDateOfBirth, endingDateOfBirth);
		if (dogs.isEmpty()) {
			return null;
		} else {
			return dogs;
		}
	}

	public Dog assignFoodToDog(Dog dog, List<Food> foods) throws AnimalManagementException {
		if (!foods.isEmpty()) {
			dog.setFoods(foods);
			return null;
		}
		return dogDao.updateDogByDogCode(dog);
	}

	public Dog assignPetStoreToDog(Dog dog, PetStore petStore) throws AnimalManagementException {
		dog.setPetStore(petStore);
		return dogDao.updateDogByDogCode(dog);
	}

	public List<Dog> getDogsByIds(String dogIds) throws AnimalManagementException {
		System.out.println(dogIds + "I am in service");
		List<Dog> dogs = dogDao.getDogsByIds(dogIds);
		if (dogs.isEmpty()) {
			return null;
		} else {
			return dogs;
		}
	}
}
