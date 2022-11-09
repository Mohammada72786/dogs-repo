package com.animalmanagement.dao;

import java.util.Map;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.animalmanagement.util.constant.Gender;
import com.animalmanagement.util.exception.AnimalManagementException;
import com.animalmanagement.model.Dog;
public interface DogDao {

    /**
     * Gets object of type dog from the service and stored in the database.
     *
     * @param dog object of type Dog.
     * @return . It returns dog object to the service after the successful insertion on the table.
     */
    public Dog insertDog(Dog dog) throws AnimalManagementException;

    /**
     * It gets dog code as an identification and fetches record from the table that matches that code and returns back.
     *
     * @param id. It contains dog code of a dog.
     * @return dog. It returns the object that matches with the dog code. if there is no dog on given id, it returns null.
     */
    public Dog getDogByDogCode(String dogCode) throws AnimalManagementException;

    /**
     * It updates the existing record that matches the id.
     *
     * @param name. It contains new name of dog.
     * @param breed. It contains new breed id of a dog.
     * @param weight. It contains new weight of dog.
     * @param colour It contains new colour of dog.
     * @param gender. It contains new gender of dog.
     * @param dateOfBirth. It contains new date of birth of dog.
     * @param  speed. It contains new running speed of the dog.
     * @param dogCode. It contains new code of the dog
     * @return string. It returns message about the update operation. whether the dog is updated or not.
     */
    public Dog updateDogByDogCode(Dog dog) throws AnimalManagementException;
    
    /**
     * It delets the dog from the list of dogs.
     *
     * @param id. It contains the dog code on which it finds a particular record and delets it.
     * @return True if record delets otherwise it returns false.
     */
    public int deleteDogByDogCode(String dogCode) throws AnimalManagementException;
    
    /**
     * It returns the list of dogs that matches with the given name. 
     *  
     * @param name. It contains the name of the dog.
     * @return dogs. The list that contains the list of dogs that partially matches the given name.
     */
    public List<Dog> getDogsByName(String name) throws AnimalManagementException;

    /**
     * It searches dogs between two given dog code.
     *
     * @param firstId. It contains the Code of first dog from where records will be fetched. 
     * @param secondId. It contains the code of last dog to where records will be fetched from the table.
     * @ return dogs. List of dogs that contains the dog code between the given codes.
     */
    public List<Dog> getDogsBetweenDogCodes(String firstId, String secondId) throws AnimalManagementException;

    /**
     * It generated the next that will be assigned to the next dog object.
     *
     * @return id. It contains the id that will be assigned to the dog.
     */
    public String generateDogCode() throws AnimalManagementException;

    /**
     * It fetches the dog and also all the foods that is assigned to that dog.
     *
     * @param dogCode. it is code of dog on which it fetches a particular record among number of records.
     * @return dog. the dog object that contains details of dog and also all the food details related to that dog. 
     */
   // public Dog getDogWithFoods(String dogCode) throws AnimalManagementException;
    public List<Dog> getDogsBetweenBirthDates(Date firstDateOfBirth, Date lastDateOfBirth) throws AnimalManagementException;
    public List<Dog> getDogsByIds(String dogIds)  throws AnimalManagementException;

}