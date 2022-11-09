package com.animalmanagement.dao;

import java.util.List;
import java.util.Map;
import java.sql.SQLException;

import com.animalmanagement.util.exception.AnimalManagementException;
import com.animalmanagement.model.PetStore;
/**
 * This class is used to store data into the database tables and fetches the data from the database 
 * tables. this class has many methods for each operation like in this class there is separate method
 * to add an object of pet store into the database likewise there is spearate method to delete method
 * from the database and so on.
 */

public interface PetStoreDao {
    
    /**
     * This method gets 'Perstore' object from the service and runs a query to add this object into  
     * the database table. If the insertion process remains successful then it will return that 
     * perstore object back to the service layer. if any error will occur then it will throw Exception.
     *
     * @param petstore. It contains all the information about petstore that is going to be added into the table.
     * @return petstore. It returns petstore object to the service after the successful insertion.
     */
    public PetStore insertPetStore(PetStore petStore) throws AnimalManagementException;
    
    /**
     * It fetches the petstore by its id from the database table and makes it as object  
     * of petstore class. if there will not be data on the given id then it sends null back to the service
     * if there is data on that id, then it assigns that resutl set to an object and returns back to the service.
     *
     * @param id. It is unique identification number of petstore on which it fetches the data from the database tables.
     * @return petStore. It returns the PetStore object to the service in case the id given by the user is valid. otherwise 
     * it will return null to the service layer. 
     */
    public PetStore getPetStoreById(int id)  throws AnimalManagementException;

    /**
     * It gets new values and id from the service layer to update the existing records of the petstore table.
     * If there will be any petstore on the given id then it updates that record else if there will not be any record
     * then it returns the message back to the service that the id is not valid.
     *
     * @param name. It contains new name for the petstore.
     * @param address. It contains new address for the existing petstore.
     * @param id. It contains unique identification number petsotre that is going to be updated.
     * @return. It returns message whether the record is updated or not.
     */
    public PetStore updatePetStoreById(PetStore petStore) throws AnimalManagementException;

    /**
     * It fetches those records from the database that partially matches the given name with their names.
     * If there is a record or number of records in that database that starts with the given name or
     * that contains the given name or ends with the given name it stores all of them in the Map.
     *
     * @param name. It contains the name of petstore.
     * @return petStores. It returns a Map of petstores to the service for printing on the console.
     */
    public List<PetStore> getPetStoresByName(String name) throws AnimalManagementException;

    /**
     * It fetches the records that lies between the two given IDs and passes to the service layer.
     * If there is record or records between the given IDs then it stores those records in the Map.
     * 
     * @param firstid. It contains first id of the range.
     * @param lastId. It contains last id of the  range.
     * @petStores. It is actually the Map of records that lies between the two given IDs. 
     */
    public List<PetStore> getPetStoresBetweenIds(int firstId, int lastId) throws AnimalManagementException;


    /**
     * It gets an id from the service and delets that particular record among the table of records.
     * If there is any record on the given id then it deletes that record and returns true to the 
     * service. If there is not any record on that given id then, it returns false to the service.
     *
     * @param id. It contains the unique identification number of the petstore.
     * @return true id the id is valid and there is record on that id. else it returns false.
     */
    public int deletePetStoreById(int id)  throws AnimalManagementException;

}