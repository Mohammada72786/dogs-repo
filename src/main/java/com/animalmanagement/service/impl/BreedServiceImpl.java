package com.animalmanagement.service.impl;
import java.util.List;

import com.animalmanagement.dao.BreedDao;
import com.animalmanagement.dao.impl.BreedDaoImpl;
import com.animalmanagement.model.Breed;
import com.animalmanagement.service.BreedService;
import com.animalmanagement.util.exception.AnimalManagementException;

    
public class BreedServiceImpl implements BreedService {

    private BreedDao breedDao = new BreedDaoImpl();

    /**
     * It gets name as a parameter and passes to the Dao to add a new breed into the database.
     *
     * @param name. it contains name of the breed.
     * @return breed. Object of class breed.
     *
     */
    public Breed addBreed(String name, String countryOfOrigin) throws AnimalManagementException {
    	Breed breed = new Breed();
    	breed.setName(name);
    	breed.setCountryOfOrigin(countryOfOrigin);
        return breedDao.insertBreed(breed);
    }

    /**
     * It gets id from the controller and passes the same id to the Dao to
     * fetch the record that is associated with give id.
     *
     * @param id. Unique identification number.
     * @return breed. It returns breed object of class Breed to the controller.
     */
    public Breed getBreedById(int id) throws AnimalManagementException  {
        return breedDao.getBreedById(id);
    }


    /**
     * It gets the new values and id of the breed from the controller and calls to the Dao to update the existing breed.
     * If there will be any breed associated with the given id then new value will be assigned.
     *
     * @param name. it is new value for breed name.
     * @param id. It is unique identification number of the breed that needs update
     * @return It returns message about whether the breed is updated or not.
     */
    public Breed updateBreedById(Breed breed) throws AnimalManagementException {
        return breedDao.updateBreedById(breed);
    }


    /**
     * It deletes the breed from the list of records. This method gets id of a breed from the controller
     * passed to the service layer to delete the breed record that is associated with the given id.
     * 
     * @param id. it contains the unique identification number of breed.
     * @throws AnimalManagementException.
     * @throws SQLException.
     * @return returns true if breed is deleted else it returns false. 
     */
    public boolean deleteBreedById(int id) throws AnimalManagementException {
        if(breedDao.deleteBreedById(id) >= 1) {
            return true;
        } else {
      		return false;
        }
    }
     

    /**
     * It gets name from the controller and passes to the Dao to
     * fetch all those records that wither fully are partially match the name.
     *
     * @param name. name of the breed.
     * @return breeds. it gets the list of breeds and returns back to the controller.
     *
     */ 
    public List<Breed> getBreedsByName(String name) throws AnimalManagementException  {
    	List<Breed> breeds = breedDao.getBreedsByName(name);
    	if(breeds.isEmpty()) {
    		return null;
    	} else {
    		return breeds;
    	}
    } 


    /**
     * It gets two IDs from the controller and passes to the DAO to fetch all those 
     * records that comes between the range.
     *
     * @param firstId. it contains the first id of the range.
     * @param lastId. It contains last id of the range.
     * @return breeds. List of those breeds that falls under the given range.
     *
     */  
    public List<Breed> getBreedsBetweenIds(int startingId, int endingId) throws AnimalManagementException  {
    	List<Breed> breeds = breedDao.getBreedsBetweenIds(startingId, endingId);
        if(breeds.isEmpty()) {
        	return null;
        } else {
        	return breeds;
        }
    }

    public List<Breed> getBreedsByIds(String breedIds) throws AnimalManagementException  {
        List<Breed> breeds = breedDao.getBreedsByIds(breedIds);
        if(breeds.isEmpty()) {
        	return null;
        } else {
        	return breeds;
        }
    }
}
