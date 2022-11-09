package com.animalmanagement.controller;

import java.util.NoSuchElementException;

import com.animalmanagement.util.PetLogger;
import com.animalmanagement.util.constant.Constants;
import com.animalmanagement.view.UserInput;


/**
 * It contains main menu of project.
 * This class Shows the user options whether user wants to go in pet store controller or any other controller.
 */
public class AnimalController {
    private final DogController dogController = new DogController();
    private final PetStoreController petStoreController = new PetStoreController();
    private final FoodController foodController = new FoodController();
    private final BreedController breedController = new BreedController();

    /**
     * Shows user interface to get choice from the user, whether user wants to perform operations on Petstore, dog, food or breed. 
     */
    public void showUserInterface() {
        try {
            char choice = Constants.YES;
            while('y' == choice || choice == 'Y') {
                int option = UserInput.getInt(Constants.MAIN_MENU_OPTIONS);
                switch (option) {
                    case Constants.DOG -> dogController.showMenu();
                    case Constants.PET_STORE -> petStoreController.showMenu();
                    case Constants.PET_FOOD -> foodController.showMenu();
                    case Constants.BREED -> breedController.showMenu();
                    default -> PetLogger.info("Invalid Input");
                }
                choice = UserInput.getChar("Enter Y to continue");
            }    
        } catch(NoSuchElementException exception) {
            PetLogger.error("You have entered a wrong character" + exception.toString());
        }
    }    
}