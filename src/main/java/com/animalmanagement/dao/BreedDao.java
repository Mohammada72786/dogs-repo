package com.animalmanagement.dao;

import java.util.List;
import java.util.Map;
import java.sql.SQLException;

import com.animalmanagement.util.exception.AnimalManagementException;
import com.animalmanagement.model.Breed;

    /**
     * This interface has methods to add, remove, update search breed from the daabase and to the database.
     * It performs all the operations related to breed. there are separate methods for separate transaction
     *
     */
public interface BreedDao {


    /**
     * This method gets the name of the breed and passes to the database query processor to
     * ass a new breed on the given name.
     *
     * @param name. It contains the name of new breed that is going to be addes in the database.
     * @ return breed. It returns breed object to the service after the successful insertion.
     *
     */
    public Breed insertBreed(Breed breed) throws AnimalManagementException;

    /**
     * This method fetches a particular breed from the table which as an id as given id.
     * If there will be any record on the given id, then it fetches that record and makes 
     * a new object of type Breed and returns back to the service layer.
     * If there is no record on the given id then it throws an exception. 
     *
     * @param id. It contains the unique identification number of the breed that a user wants to see.
     */
    public Breed getBreedById(int id) throws AnimalManagementException;

    /**
     * This method updates the previous breed record with new values.
     * Once the record is updated it will return message back to the service about
     * successful update. If there is no record on the given id then it returns the message regarding the unsuccessful 
     * operation on the database.
     *
     * @param name. It contains the new value for the name of the breed.
     * @param id. It contains unique id of the particular breed that needs updation.
     * @return string. it returns about the successful and unsuccessful updation to the the service layer.
     */
    public Breed updateBreedById(Breed breed)  throws AnimalManagementException;

    /**
     * It gets id from the service layer and deletes the particular record that matches id with the given id.
     *
     *
     * @param id. it contains id of the breed that needs to be deleted from the database.
     * @return true.false. It returns true if the record on the given id is present int he database
     * it returns false if the there is not any record that marches the id.
     */
    public int deleteBreedById(int id)  throws AnimalManagementException;

    /**
     * It gets the name from the service layer and finds all those records that contains the given name
     * It will find all thosse breeds that starts with, contains, or ends with the given name.
     *
     * @param name. name of the breed.
     * @return . It returns the all those records that partially or fully matches with the given name.
     *
     */ 
    public List<Breed> getBreedsByName(String name)  throws AnimalManagementException;

    /**
     * It gets two IDs from the service and finds all those records that lies between those given ids.
     * If there is no record between given IDs then it returns null. but if there is any record or number 
     * of records then all those records will be saved into the Map list and will be returned to the the 
     * service layer.
     *
     * @param firstId. It is initial id of the breed range.
     * @param lastId. it is final id of the range.
     * @return breeds. list of those breeds that lies between the two given ids.
     */
    public List<Breed> getBreedsBetweenIds(int firstId, int lastId)  throws AnimalManagementException;

    /**
     *
     *
     *
     *
     */
    public List<Breed> getBreedsByIds(String breedIds)  throws AnimalManagementException;
}