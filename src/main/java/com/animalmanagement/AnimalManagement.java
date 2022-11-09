package com.animalmanagement;

import com.animalmanagement.controller.AnimalController;

public class AnimalManagement {   
 
    /**
     * Starting method of application.
     */
    public static void main(String[] args) {
        AnimalController animalController = new AnimalController();
        animalController.showUserInterface();
    }
}