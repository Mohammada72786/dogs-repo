package com.animalmanagement.service;
import java.util.List;

import com.animalmanagement.model.PetStore;
import com.animalmanagement.util.exception.AnimalManagementException;

/*
 * In this methods are called by the controllers and it passes those calls to the Dao to perform
 * operation on the database.
 */
public interface PetStoreService {
    /**
     * This method gets name and address of the pet store and calls constructor to create object
     * of type pet store and passes to the Dao to add the pet store into the database.
     *
     * @param name. It contains name of pet store.
     * @param address. It contains address of pet store.
     * @return It returns object if insertion operation is done successfully by the Dao else it will return null.
     */

    public PetStore addPetStore(String name, String address) throws AnimalManagementException;
    /**
     * It gets pet Store by its id from the the database through the Dao and returns back to  
     * the controller to print it on the console.
     *
     * @param id. Contains id of the pet store that is needed to be printed.
     * @return. returns pet store that matches the given id. If id will be invalid then null will be returned.
     */
    public PetStore getPetStoreById(int id)  throws AnimalManagementException;

    /**
     * This method is used to update the existing pet store that matches the id received from the controller.
     * It gets parameters from the controller and passes to the Dao to check whether there is any record on the 
     * given id or not. If there will be any record associated with the id the it will update that record with new values.
     *
     * @param name. It contains new name of the pet store.
     * @param address. It contains new address of the pet store.
     * @param id. It contains unique identification number of the pet store that needs updation.
     * @return It returns string in which there will be message about the updation process whether the record is updated or not.
     */
    public PetStore updatePetStoreById(String name, String address, int id, PetStore petStore) throws AnimalManagementException;

    /**
     * It gets id from the controller layer and calls the method of Dao to delete the petstore from 
     * the records. if there will be record that matches the given id. then that record will bre removed and true will be returned.
     * If there will not be any record then it returns false.
     *
     * @param id. It contains unique identification of the pet store.
     * @return true/false. true if record is removed else false.
     *
     */
    public boolean deletePetStoreById(int id)  throws AnimalManagementException;

    /**
     *  It fetches all those pet stores that match with the given name   
     *  either partially or fully.
     *
     * @param name. It contains the name of pet store.
     * @return pet stores. List of filtered pet stores. 
     *
     */ 
    public List<PetStore> getPetStoresByName(String name) throws AnimalManagementException; 

    /**
     * It takes two IDs from the user and passes to the Dao to fetch all those records that lies between the
     * given IDs. if there will be number of records it gets all those records in the form of Map and passes 
     * that Map to the controller to display on the console.
     *
     * @param firstId. It contains first id of the range.
     * @param lastId. It contains last id of the range.
     * @return pet stores. the Map of the those pet stores that lies between two given IDs.
     *
     */    

    public List<PetStore> getPetStoresBetweenIds(int firstId, int lastId) throws AnimalManagementException;

}
