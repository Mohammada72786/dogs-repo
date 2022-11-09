package com.animalmanagement.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.animalmanagement.model.Breed;
import com.animalmanagement.service.BreedService;
import com.animalmanagement.service.impl.BreedServiceImpl;
import com.animalmanagement.util.PetLogger;
import com.animalmanagement.util.constant.Constants;
import com.animalmanagement.util.exception.AnimalManagementException;
import com.animalmanagement.view.UserInput;

public class BreedController {

    private final BreedService breedService = new BreedServiceImpl();

    /**
     * Shows options related to Breed.
     * It calls the methods add, remove, update, and search;
     */
    public void showMenu() {
        int option = UserInput.getInt(Constants.BREED_MENU);
        try {
            switch (option) {
                case Constants.ADD -> addBreed();
                case Constants.SHOW -> displayBreedById();
                case Constants.DELETE -> deleteBreedById();
                case Constants.UPDATE -> updateBreedById();
                case Constants.SEARCH -> displayBreedsByName();
                case Constants.DISPLAY_MANY -> displayBreedsByIds();
                case Constants.DISPLAY_BETWEEN -> displayBetweenIds();
                default -> PetLogger.info(Constants.INVALID_INPUT);
            }
        }catch (NoSuchElementException exception){
            System.out.println(exception);
        }
    }
    
    /**
     * Gets name from the user and calls to the breed servivice to add the new breed
     * in the list of breeds.
     */

    private void addBreed()  {
    	Breed breed = null;
    	try {
    		String name = UserInput.getString("Please enter name of Breed");
    		String countryOfOrigin = UserInput.getString(Constants.INPUT_COUNTRY_OF_ORIGIN);
    		breed = breedService.addBreed(name, countryOfOrigin); 
    		if (null == breed) {
    			System.out.println("Something went wrong while inserting please try again");
    		} else {
    			System.out.println(breed);
    		}
    	} catch(AnimalManagementException exception) {
    		System.err.println(exception);
    	} 
    }

    /**
     * It fetches all existing breeds and displays here with that starts with the given string.
     */
    private void displayBreedsByName() { 
    	try {
    		List<Breed> breeds = breedService.getBreedsByName(UserInput.getString(Constants.INPUT_NAME));
            if(null == breeds) {
            	System.out.println("No match found on your given name");
            } else {
            	for(Breed breed : breeds) {
            		System.out.println(breed);
            	}
            }
    	} catch(AnimalManagementException exception) {
    		System.err.println("Something went wrong while ferching data" + exception.getMessage());
        }
    }

    /**
     * It deletes Existing breed from the list of breeds
     *
     */
    private void deleteBreedById() {
    	try {
    		int id = UserInput.getInt("Please enter Breed Id");
            if(breedService.deleteBreedById(id)) {
                System.out.println("Breed removed successfully");
            }
            else {
                System.out.println("Breed Id not found");
            }  
    	} catch(AnimalManagementException exception) {
    		System.err.println("something went wrong while deleting data" + exception.getMessage());
    	}      
    }

    /**
     * Gets breed and prints on console by its id.
     *
     */
    private void displayBreedById() {
        int id = UserInput.getInt(Constants.INPUT_ID);
        try {
        	Breed breed = breedService.getBreedById(id);
            if (null != breed) {
                System.out.println(breed);
            } else {
                System.out.println("Breed id not found");
            }
        } catch(AnimalManagementException exception) {
        	System.out.println("Something went wrong while fetching data please try again");
        }
    }

    /**
     * It updates existing breeds.
     * Gets breed id from the user and checks whether the id is present or not. if not then it shows
     * message that 'breed id not found' If breed id is present then it asks for new values and sends 
     * update request to the service to proceed further.
     */
    private void updateBreedById()  {
    	try {
    		int id = UserInput.getInt("Please enter breed id");
            Breed breed = breedService.getBreedById(id);
            if(null == breed) {
                System.out.println("No Breed found, please check your id and try again");
            } else { 
            	if(1 == UserInput.getInt("You want to change the name: press 1 else press other number"))
                breed.setName(UserInput.getString(Constants.INPUT_NAME));
                if(1 == UserInput.getInt("You want to change the Country: press 1 else press other number"))
                breed.setCountryOfOrigin(UserInput.getString(Constants.INPUT_COUNTRY_OF_ORIGIN));
                System.out.println(breedService.updateBreedById(breed));
            }
    	}catch(AnimalManagementException exception) {
    		System.out.println(exception);
    	} 
    }

    /**
     * It gets two ids from the user and prints all the breeds that found between the given ids.
     *
     */
    private void displayBetweenIds() {
    	try {
    		int startingId = UserInput.getInt("Enter starting Id");
            int endingId = UserInput.getInt("Enter ending Id");
            List<Breed> breeds = breedService.getBreedsBetweenIds(startingId, endingId);
            if(null == breeds) {
                System.out.println("No Breed found between your given IDs");
            } else {
            	for(Breed breed : breeds) {
            		System.out.println(breed);
            	}
            }
    	} catch(AnimalManagementException exception) {
    		System.out.println(exception);
    	}
    }

    private void displayBreedsByIds() {
        StringBuilder breedIds = new StringBuilder();
        try {
        	int noOfBreeds = UserInput.getInt("Please enter how many breeds you want to print");
            System.out.println("Please enter breed ids one by one");
            for(int i = 0; i < noOfBreeds; i++) {
                breedIds.append(UserInput.getInt("id no "+ (i+1))); 
                breedIds.append(",");
            }
            breedIds.delete(breedIds.length()-1,breedIds.length());
            List<Breed> breeds = breedService.getBreedsByIds(breedIds);
            if(null == breeds) {
                PetLogger.info("No record found on your given input");
            } else {
                for(Breed breed : breeds) {
                    System.out.println(breed);
                }
            }
        } catch(AnimalManagementException exception) {
        	
        }     
    }
}
