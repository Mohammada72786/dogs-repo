package com.animalmanagement.controller;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;
import java.util.Map;

import com.animalmanagement.model.Dog;
import com.animalmanagement.model.Food;
import com.animalmanagement.service.FoodService;
import com.animalmanagement.service.impl.FoodServiceImpl;
import com.animalmanagement.util.constant.Constants;
import com.animalmanagement.util.exception.AnimalManagementException;
import com.animalmanagement.util.PetLogger;
import com.animalmanagement.view.UserInput;

/**
 * This class is used to control all the operations related to food.
 * It provides the interface to the user, to type inputs and to choose option among the given options.
 * It calls to the UserInput class to get the input and Validator class to validate the received input.
 */

public class FoodController {

    private FoodService foodService = new FoodServiceImpl();

    /**
     * Shows options related to Food.
     * As per users choice it calls the methods of the service layer,
     * for example if user will type 1 it will call the add food method of the food service.
     * If user will type any invalid value, then it will display a message about invalid input.
     */
    public void showMenu() {
        int option = UserInput.getInt(Constants.FOOD_MENU);
        try {
            switch(option) {
                case Constants.ADD:
                    addFood();
                    break;
                case Constants.SHOW:
                    getFoodById();
                    break;
                case Constants.DELETE:
                    deleteFoodById();
                    break;
                case Constants.UPDATE:
                    updateFoodById();
                    break;
                case Constants.SEARCH:
                    displayFoodsByName();
                    break;
                default:
                    System.err.println(Constants.INVALID_INPUT);
                    break;
            }
        } catch (AnimalManagementException ex) {
            PetLogger.error(ex.toString());
        }
    }

    /**
     * It gets the id of the food from the user and calls the service layer to delete that food from the list of foods.
     * If there will not be any food associated to the given id then it will display a message to the user about the wrong id.
     * If false will be returned from the service layer then it will throw AnimalManagementException.
     * If true will be returned from the service layer then it will show message "food removed successfully".
     */
    private void deleteFoodById()  {
    	try {
    		int id = UserInput.getInt("Please enter Food Id");
            if(foodService.deleteFoodById(id)) {
                System.out.println("Food removed successfully");
            }
            else {
                System.out.println("No data found");
            }  
    	} catch(AnimalManagementException exception) {
    		PetLogger.error(exception.getMessage());
    	}
        
    }
    
    /**
     * It gets the user inputs from the user and calls to the service layer to add one more food in the list 
     */

    private void addFood() throws AnimalManagementException {
    	try {
    		String name = UserInput.getString("Please enter name of Food");
            String type = UserInput.getString("Please enter type of Food");
            System.out.println(foodService.addFood(name, type));
    	} catch(AnimalManagementException exception) {
    		PetLogger.error(exception.getMessage());
    	}
    }

    /**
     * It gets id from the user and passes to the service layer to get the food 
     * associated to the id and displays on the console.
     * If there will not be any food associated with the given id the it throws the exception.
     */

    private void getFoodById()  {
    	try {
    		int id = UserInput.getInt(Constants.INPUT_ID);
            Food food = foodService.getFoodById(id);
            if (null != food) {
                System.out.println(food);
            } else {
                System.out.println("Invalid input");
            }
    	} catch(AnimalManagementException exception) {
    		PetLogger.error(exception.getMessage());
    	}
        
    }

    /**
     * It gets id from the user to update the existing value.
     * If there the id will be valid the it will ask user to type new values to replace old values.
     * once use will type all the values to replace existing values the it will call the method of the service layes
     * to update the old values.
     */
    private void updateFoodById() {
    	try {
    		int id = UserInput.getInt("Please enter food identification number");
            Food food = foodService.getFoodById(id);
            if(null == food) {
                throw new AnimalManagementException("No Food found, please check your id and try again");
            } else { 
                String name = UserInput.getString(Constants.INPUT_NAME);
                String type = UserInput.getString("Please enter type");
                System.out.println(foodService.updateFoodById(name, type, id, food));
            }
    	} catch(AnimalManagementException exception) {
    		PetLogger.error(exception.getMessage());
    	}
        
    }

    /**
     * It calls to the service layer to get all the existing food and display.
     * Service layer returns list of foods in the form of map and this method displays those 
     * foods on the console. If there would not be any food available the will will print null.
     */
    private void displayFoodsByName() { 
    	try {
    		List<Food> foods = foodService.getFoodsByName(UserInput.getString(Constants.INPUT_NAME));
            if(foods.isEmpty()) {
            	System.out.println("No data found");
            } else {
            	System.out.println(foods);	
            } 
    	} catch(AnimalManagementException exception) {
        	PetLogger.error(exception.getMessage());
        }
    }
    
    /**
     * This method will get two IDs of the food and will passes to the service layer of the food to display all
     * the foods that falls between the given IDs.
     * If null will be returned from the service the this method will display message about the wrong input.
     */
    private void displayBreedsBetweenIds() {
        int startingId = UserInput.getInt("Enter starting Id");
        int endingId = UserInput.getInt("Enter ending Id");
        try {
        	List <Food> foods = foodService.getFoodsBetweenIds(startingId, endingId);
            if(null == foods) {
                System.out.println("No Food found between your given IDs");
            } else {
            	for(Food food: foods ) {
            		System.out.println(foods);	
            	}
            }
        } catch(AnimalManagementException exception) {
        	PetLogger.error(exception.getMessage());
        }
    }

    /**
     * It will get food id from the user and will pass to the service layer.
     * If the id will be among the list of food IDs, then it will display that food 
     * and will will also display those dogs that are eating that particular food.
     * If the food if will not be valid the service layer will return null and here
     * message regarding out invalid id will be displayed.
     */ 
}
