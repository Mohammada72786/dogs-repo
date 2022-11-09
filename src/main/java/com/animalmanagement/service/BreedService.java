package com.animalmanagement.service;
import java.util.List;

import com.animalmanagement.model.Breed;
import com.animalmanagement.util.exception.AnimalManagementException;
public interface BreedService {
    /**
     * It gets name as a parameter and passes to the Dao to add a new breed into the database.
     *
     * @param name. it contains name of the breed.
     * @return breed. Object of class breed.
     *
     */
    public Breed addBreed(String name, String countryOfOrigin) throws AnimalManagementException;

    /**
     * It gets id from the controller and passes the same id to the Dao to
     * fetch the record that is associated with give id.
     *
     * @param id. Unique identification number.
     * @return breed. It returns breed object of class Breed to the controller.
     */
    public Breed getBreedById(int id)  throws AnimalManagementException;

    /**
     * It deletes the breed from the list of records. This method gets id of a breed from the controller
     * passed to the service layer to delete the breed record that is associated with the given id.
     * 
     * @param id. it contains the unique identification number of breed.
     * @return returns true if breed is deleted else it returns false.
     */
    public boolean deleteBreedById(int id) throws AnimalManagementException;

    /**
     * It gets name from the controller and passes to the Dao to
     * fetch all those records that wither fully are partially match the name.
     *
     * @param name. name of the breed.
     * @return breeds. it gets the list of breeds and returns back to the controller.
     *
     */ 
    public List<Breed> getBreedsByName(String name) throws AnimalManagementException;


    /**
     * It gets two IDs from he controller and passes to the Dao to fetch all those 
     * records that comes between the range.
     *
     * @param firstId. it contains the first id of the range.
     * @param lastId. It contains last id of the range.
     * @return breeds. List of those breeds that falls under the given range.
     *
     */  
    public List<Breed> getBreedsBetweenIds(int startingId, int endingId) throws AnimalManagementException;

    public List<Breed> getBreedsByIds(String breedIds) throws AnimalManagementException;

    /**
     * It gets the new values and id of the breed from the controller and calls to the Dao to update the existing breed.
     * If there will be any breed associated with the given id then new value will be assigned.
     *
     * @param name. it is new value for breed name.
     * @param id. It is unique identification number of the breed that needs updation
     * @return It returns message about whether the breed is updated or not.
     *
     */
    public Breed updateBreedById(Breed breed) throws AnimalManagementException;
}