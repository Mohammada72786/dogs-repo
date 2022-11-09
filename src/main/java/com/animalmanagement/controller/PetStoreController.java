package com.animalmanagement.controller;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import com.animalmanagement.util.constant.Constants;
import com.animalmanagement.util.exception.AnimalManagementException;
import com.animalmanagement.util.PetLogger;
import com.animalmanagement.model.PetStore;
import com.animalmanagement.service.PetStoreService;
import com.animalmanagement.service.impl.PetStoreServiceImpl;
import com.animalmanagement.view.UserInput;

/**
 * This class is used to control all the operation related to pet store, operations are like add, delete, 
 * search etc. 
 */
public class PetStoreController {

    private PetStoreService petStoreService = new PetStoreServiceImpl();

    /**
     * Shows options related to pet store.
     * It calls the methods add, remove, update search etc.
     * If the user input will be with the range then it will call corresponding methods.
     * If the user input will be out of the range then it displays a message regarding wrong input.
     */
    public void showMenu() {
        int option = UserInput.getInt(Constants.PET_STORE_MENU);
        try {
            switch(option) {
                case Constants.ADD:
                    addPetStore();
                    break;
                case Constants.SHOW:
                    getPetStoreById();
                    break;
                case Constants.DELETE:
                    deletePetStoreById();
                    break;
                case Constants.UPDATE:
                    updatePetStoreById();
                    break;
                case Constants.SEARCH:
                    displayPetStoresByName();
                    break; 
                case Constants.SEARCH_BETWEEN:
                	displayPetStoresBetweenIds();
                	break;
                default:
                    System.err.println(Constants.INVALID_INPUT);
                    break;
            }
        } catch (NoSuchElementException exception) {
            PetLogger.error(exception.toString());
        }
    }
    
    /**
     * It gets an id from the user and calls to the service class to delete the pet store associated with 
     * the given id. if id will valid then it will display the message about the successful delete of pet store.
     * If the id will not match any pet store then it will display a message regarding invalid input id.
     */
    private void deletePetStoreById() {
    	try {
    		int id = UserInput.getInt("Please enter petstore Id");
            if(petStoreService.deletePetStoreById(id)) {
                System.out.println("pet store removed successfully");
            }
            else {
                System.out.println("Pet store Id not found");
            }
    	} catch(AnimalManagementException exception) {
    		PetLogger.error(exception.getMessage());
    	}  
    }
     
    /**
     * It gets all the values from the user and calls to the service to add one more
     * record to the pet stores table. If prints the object that is added to the list of 
     * existing list. if there is any exception during the adding process then it will throw the exception.
     *
     */
    private void addPetStore()  {
    	try {
    		String name = UserInput.getString("Please enter name of petstore");
            String address = UserInput.getString("Please enter address of petstore");
            System.out.println(petStoreService.addPetStore(name, address));
    	} catch(AnimalManagementException exception) {
    		PetLogger.error(exception.getMessage());
    	}
    }

    /**
     * It gets id from the user and passes to the service layer to fetch the record from the list of records.
     * If the id will be valid the pet store will be displayed on the console.
     * If the id will be invalid the AnimalManagementException will be thrown.
     */
    private void getPetStoreById() {
    	try {
    		int id = UserInput.getInt(Constants.INPUT_ID);
            PetStore petStore = petStoreService.getPetStoreById(id);
            if (null != petStore) {
                System.out.println(petStore);
            } else {
                System.out.println("Petstore id not found");
            }
    	} catch(AnimalManagementException exception) {
    		PetLogger.error(exception.getMessage());
    	}
    }

    /**
     * Gets id from the user and checks whether the id belongs to any pet store or not.
     * If there will be any pet store associate with the given id the it asks to type new values
     * for fields, if the given id will be invalid, then AnimalManagementException will be thrown.
     */
    private void updatePetStoreById() {
    	try {
    		int id = UserInput.getInt("Please enter store Id");
            PetStore petStore = petStoreService.getPetStoreById(id);
            if(null == petStore) {
                System.out.println("No petstore found, please check your id and try again");
            } else { 
                String name = UserInput.getString(Constants.INPUT_NAME);
                String address = UserInput.getString("Please enter address");
                System.out.println(petStoreService.updatePetStoreById(name,address,id, petStore));
            }
    	} catch(AnimalManagementException exception) {
    		PetLogger.error(exception.getMessage());
    	}    
    }

    /**
     * It displays all the available store on the console that starts with the given name.
     * It forwards the user input to the service layer and gets records in the form of map, 
     *
     */
    private void displayPetStoresByName()  { 
    	try {
    		List<PetStore> petStores = petStoreService.getPetStoresByName(UserInput.getString(Constants.INPUT_NAME));
            if(null == petStores) {
            	System.out.println("No data found");
            }  else {
            	for(PetStore petStore: petStores) {
            		System.out.println(petStore);
            	}
            }
    	} catch(AnimalManagementException exception) {
    		PetLogger.error(exception.getMessage());
    	}
    }
   
    /**
     * It gets two IDs from the user and passes to the service layer to get all the records from the list of records
     * that lies between the given IDs.
     * If no record will be returned by the service layer the it prints message about the empty set.
     * If there will be records that will be stored in map and will be displayed on console.
     */
    private void displayPetStoresBetweenIds() {
        int firstId = UserInput.getInt("Enter starting Id");
        int lastId = UserInput.getInt("Enter ending Id");
        try {
        	List<PetStore> petStores = petStoreService.getPetStoresBetweenIds(firstId, lastId);
            if(null == petStores) {
                PetLogger.info("No Petstore found between your given IDs");
            } else {
            	for(PetStore petStore : petStores) {
            		System.out.println(petStore);
            	}
            }
        } catch(AnimalManagementException exception) {
        	PetLogger.error(exception.getMessage());
        }   
    }
}
