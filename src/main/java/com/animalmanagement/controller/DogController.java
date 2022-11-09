package com.animalmanagement.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.animalmanagement.model.Dog;
import com.animalmanagement.model.Food;
import com.animalmanagement.model.PetStore;
import com.animalmanagement.service.DogService;
import com.animalmanagement.service.FoodService;
import com.animalmanagement.service.PetStoreService;
import com.animalmanagement.service.impl.DogServiceImpl;
import com.animalmanagement.service.impl.FoodServiceImpl;
import com.animalmanagement.service.impl.PetStoreServiceImpl;
import com.animalmanagement.util.DateUtil;
import com.animalmanagement.util.PetLogger;
import com.animalmanagement.util.Validator;
import com.animalmanagement.util.constant.Constants;
import com.animalmanagement.util.constant.Gender;
import com.animalmanagement.util.exception.AnimalManagementException;
import com.animalmanagement.view.UserInput;
    
    /**
     * This class is used to get the inputs from the user and perform operations on the dog.
     * It gets user inputs and calls to the dog service class to add remove update etc.
     *
     */
public class DogController {	
	
    private final DogService dogService = new DogServiceImpl();

    /**
     * It shows menu to the user , then user will select an option according to his/her choice.
     * In this method user can choose choice like.
     *  Add, delete, update, search etc
     */
    public void showMenu() {
        int option = UserInput.getInt(Constants.DOG_MENU);
        try {
            switch (option) {
                case Constants.ADD -> addDog();
                case Constants.SHOW -> showDogById();
                case Constants.DELETE -> deleteDogByDogCode();
                case Constants.UPDATE -> updateDog();
                case Constants.SEARCH -> displayDogsByName();
                case Constants.SEARCH_BETWEEN -> displayDogsBetweenDogCodes();
                case Constants.ASSIGN_FOODS -> assignFoodsToDog();
                case Constants.DISPLAY_DOGS_BETWEEN_DATES -> displayDogsBetweenBirthDates();
                case 9 -> assignPetStoreToDog();
                default -> {
                    System.out.println("invalid input");
                    PetLogger.info("Invalid Input");
                }
            }
        } catch (AnimalManagementException ex) {
            PetLogger.error(ex.getMessage());
        }
    }

    /**
     * It gets dog code and calls the service class to delete the dog from the list of dogs.
     * If there will not be any dog on given code then it will throw a AnimalManagementException.
     *
     */
    public void deleteDogByDogCode() {
        String dogCode = UserInput.getAlphaNumericString("Please enter dog code");
        try {
        	if(dogService.deleteDogByDogCode(dogCode)) {
                System.out.println("dog deleted successfully");
            }
            else {
                System.out.println("Dog code not found");
            } 
        } catch(AnimalManagementException exception) {
        	PetLogger.error(exception.getMessage());
        }       
    }

    /**
     * It gets user inputs and passes to the service layer to add a new record to the list of dogs.
     * If user type any  invalid value it will ask to type again.
     * If user type any wrong age it will throw InvalidAgeException.
     */
    private void addDog() throws AnimalManagementException {
        Gender gender;
        String name = UserInput.getString(Constants.INPUT_NAME);
        float weight = UserInput.getFloat(Constants.INPUT_WEIGHT);
        String colour = UserInput.getString(Constants.INPUT_COLOUR);
        while(true) {
            int gen = UserInput.getInt(Constants.INPUT_GENDER);
            gender = Gender.getGender(gen);
            if(gender != null) {
                break;
            }
            else {  
                System.out.println("Invalid Gender");
            }
        } 
        Date dateOfBirth = null;
        try {
            dateOfBirth = Validator.getDate(Validator.validateDate(UserInput.getAlphaNumericString(Constants.INPUT_DOB)));
            int age = DateUtil.calculateAge(dateOfBirth); 
        } catch(ParseException ex) {
            PetLogger.error(ex.toString());
        }
        float speed = UserInput.getFloat(Constants.INPUT_SPEED);
            if(speed < 1 || speed > 30) {
                throw new AnimalManagementException("Speed of animal must be 1 km to 30 km per hour");
            }
        System.out.println(dogService.insertDog(
            name,
            weight, 
            colour, 
            gender,
            dateOfBirth, 
            speed));
        System.out.println("Dog added successfully!---");
    }

    /**
     * It gets dog code from the user and passes to the service layer to show the particular dog on the console.
     * If the id will be invalid it will display a message on the console regarding the wrong or invalid dog code.
     */
    private void showDogById()  throws AnimalManagementException {
    	try {
    	    String dogCode = UserInput.getAlphaNumericString(Constants.INPUT_ID);
    	    Dog dog = dogService.getDogByDogCode(dogCode);
    	    if(null != dog) {
    	        System.out.println(dog);
    	        System.out.println("Associated pet store");
    	        System.out.println(dog.getPetStore());
    	        System.out.println("Favourite Foods");
    	        for(Food food : dog.getFoods()) {
    	        	System.out.println(food);
    	        }	
    	    } else {
    		    PetLogger.info("No dog found on given dog code");
    	    }
    	} catch(AnimalManagementException exception) {
    		PetLogger.error(exception.getMessage());
    	}
    }
    /**
     * It gets and a dog code from the user to update the existing dog from the dog list.
     * If the dog code will be present in the list of dog codes
     * Then it will proceed otherwise it will throw exception NoAnimalFoundException
     *  but if dog code is valid then it will ask for values, and then it will call to the service layer
     * to proceed for update.
     */
    private void updateDog() throws AnimalManagementException {
        String dogCode = UserInput.getAlphaNumericString("Please enter Code of dog");
        Dog dog = dogService.getDogByDogCode(dogCode);
        if(null == dog) {
            PetLogger.error("No Dog found, please check your id and try again");
        } else { 
        	System.out.println(dog);
            Date dateOfBirth = null;
            Gender gender;
            dog.setName(UserInput.getString(Constants.INPUT_NAME));
            dog.setWeight(UserInput.getFloat(Constants.INPUT_WEIGHT));
            dog.setColour(UserInput.getString(Constants.INPUT_COLOUR));
            while(true) {
                int gen = UserInput.getInt(Constants.INPUT_GENDER);
                gender = Gender.getGender(gen);
                if (null != gender) {
                    break;
                } else {  
                    PetLogger.info("Invalid Gender");
                }
            }
            dog.setSpeed(UserInput.getFloat(Constants.INPUT_SPEED));
            System.out.println(dog);
            System.out.println(dogService.updateDogByDogCode(dog));
        }
    }



    /**
     * This method is used to search dogs by name that starts with given value.
     */
    private void displayDogsByName() { 
    	try {
    		List<Dog> dogs = dogService.getDogsByName(UserInput.getString(Constants.INPUT_NAME));
            if(null == dogs) {  
                System.out.println("No result found");  
            } else {
                for(Dog dog : dogs) {
                	System.out.println(dog);
                	System.out.println("Favorite Foods of dog " + dog.getName()+ " are");
                	List<Food> foods = dog.getFoods();
                	for(Food food : foods) {
                		System.out.println(food);
                	}
                }
            }
    	} catch(AnimalManagementException exception) {
    		PetLogger.error(exception.getMessage());
    	}
    }

    /**
     * It gets two IDs from the user and passes to the service class to print all the entries between two IDs.
     * 
     */
    private void displayDogsBetweenDogCodes() throws AnimalManagementException {
        String startingId = UserInput.getAlphaNumericString("Enter starting Id");
        String endingId = UserInput.getAlphaNumericString("Enter ending Id");
        List<Dog> dogs = dogService.getDogsBetweenDogCodes(startingId, endingId);
        if(null == dogs) {
            System.out.println("No dog found between your given IDs");
        } else {
        	for(Dog dog : dogs)
            System.out.println(dog);
        }
    }

    /**
     * It displays dog on given dog code, if the dog will be there on the give code,
     * then it will show that dog, and it will also show all those foods that are assigned to that particular dog.
     */
    
    private void displayDogsBetweenBirthDates()  {
        Date startingDate = null, endingDate = null;
        try {
            startingDate = Validator.getDate(UserInput.getAlphaNumericString("Please enter  initial birth date"));
            endingDate = Validator.getDate(UserInput.getAlphaNumericString("Please enter final birth date"));
            List<Dog> dogs = dogService.getDogsBetweenBirthDates(startingDate, endingDate);
            if(null == dogs) {
                System.out.println("No record found between your dates please check and try again");
            } else {
                for(Dog dog : dogs) {
                    System.out.println(dog);
                }
            }
        } catch(ParseException exception) { 
        	PetLogger.error("Invalid date format" + exception.getMessage());
        } catch(AnimalManagementException exception) {
        	PetLogger.error("something went worng while fetcing data from dog" 
        + exception.getMessage());
        }
    }
    private void assignFoodsToDog() {
    	StringBuilder foodIds = new StringBuilder();
    	FoodService foodService = new FoodServiceImpl();
        try {
        	Dog dog = dogService.getDogByDogCode(UserInput.getAlphaNumericString("Enter dog code"));
        	if(null == dog) {
        		System.out.println("Invalid dog code");
        	} else {
        		int noOfFoods = UserInput.getInt("Please enter how many food/foods you want to assign");
                System.out.println("Please enter food IDs one by one");
                for(int i = 0; i < noOfFoods; i++) {
                    foodIds.append(UserInput.getInt("id no "+ (i+1))); 
                    foodIds.append(",");
                }
                foodIds.delete(foodIds.length()-1,foodIds.length());
                List<Food> foods = foodService.getFoodsByIds(foodIds);
                dogService.assignFoodToDog(dog, foods);
        	}	
        } catch(AnimalManagementException exception) {
        	PetLogger.error(exception.getMessage());
        }
    }
    private void assignPetStoreToDog() {
    	PetStoreService petStoreService = new PetStoreServiceImpl();
    	PetStore petStore = null;
        try {
        	Dog dog = dogService.getDogByDogCode(UserInput.getAlphaNumericString("Enter dog code"));
        	if(null == dog) {
        		System.out.println("Invalid dog code");
        	} else {
        		int petStoreId = UserInput.getInt("Please enter pet store Id");
                petStore = petStoreService.getPetStoreById(petStoreId);
                if(null == petStore) {
                	System.out.println("Invalid Pet store ID");
                } else {
                    dog = dogService.assignPetStoreToDog(dog, petStore);
                    System.out.println(dog);
                }
        	}	
        } catch(AnimalManagementException exception) {
        	PetLogger.error(exception.getMessage());
        }
    }
}
