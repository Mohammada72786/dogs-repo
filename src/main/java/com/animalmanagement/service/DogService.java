package com.animalmanagement.service;

import java.util.Date;
import java.util.List;

import com.animalmanagement.model.Dog;
import com.animalmanagement.model.Food;
import com.animalmanagement.model.PetStore;
import com.animalmanagement.util.constant.Gender;
import com.animalmanagement.util.exception.AnimalManagementException;

public interface DogService {


    /**
     * This method is used to add the dog in the list of dogs.
     *
     * @param name  It is used to set the name of dog.
     * @param breed It is used to set the breed of the dog.
     * @param weight It is used to set the weight of the dog.
     * @param colour It is used to set the color of the dog.
     * @param gender It is used to set the color of the dog.
     * @param dob it Is used to set the date of birth of the dog.
     * @param furType It is used to set the fur type of the dog.
     * @param eyeColour It is used to service the eye colour of the dog.
     * @return dog. It returns the dog to the method from where it is called.
     */
    public Dog insertDog(String name, 
        float weight, 
        String colour,
        Gender gender,
        Date dateOfBirth,
        float speed) throws AnimalManagementException;

    /**
     * Gets id as a parameter from the controller class and sends back a dog that matches the id.
     * @param id It is a unique field of dog class on which we can find a particulat dog among list of dogs.
     */
    public Dog getDogByDogCode(String dogCode) throws AnimalManagementException ;

    /**
     * This method is used to update the old values of cat with new values.
     *
     * @param option It is to used to find the field of cat that a user wants to update.
     * @param newvalue it is new value that will replace old value.
     * @param Id  It is used to find a particular cat, that needs updation.
     */
    public Dog updateDogByDogCode(Dog dog) throws AnimalManagementException;

    /**
     * This method takes animal id as parameter and checks for a dog.
     * If there will be any dog with given id, it will remove that dog and true will be returned;
     * If there will not be any dog with given, it will return false.
     *
     * @param id It is animal id of dog.
     * @return true/false
     */
    public boolean deleteDogByDogCode(String id) throws AnimalManagementException ;

    /**
     * It makes a list of all those objects that starts with given value.
     *
     * @param name It is a user input to search the dogs.
     * @return list of filtered dogs  that starts with given name.
     */  
    public List<Dog> getDogsByName(String name) throws AnimalManagementException;


    /**
     * It gets first and last IDs of the range and passes to the DAO class.
     * 
     * @param firstId. First id of range.
     * @param lastId. Last id of the range.
     * @ return. return list of dogs between the given ids. Or null if no data found.
     */
    
    public List<Dog> getDogsBetweenDogCodes(String firstId, String secondId) throws AnimalManagementException;

    //public Dog getDogWithFoods(String dogCode) throws AnimalManagementException;
    public List<Dog> getDogsBetweenBirthDates(Date firstDateOfBirth, Date lastDateOfBirth) throws AnimalManagementException;
    public Dog assignFoodToDog(Dog Dog, List<Food> foods) throws AnimalManagementException;
    public Dog assignPetStoreToDog(Dog dog, PetStore petStore) throws AnimalManagementException;
    public List<Dog> getDogsByIds(String dogIds) throws AnimalManagementException;


}