package com.animalmanagement.service;

import java.util.List;

import com.animalmanagement.model.Food;
import com.animalmanagement.util.exception.AnimalManagementException;
public interface FoodService {

    /**
     * It gets name and type of food from the controller and calls the constructor to create
     * the object of food and, the it passes that object to the Dao to add the new record into
     * the foods table.
     *
     * @param name. It contains the name of the food.
     * @param type. It contains type of food whether the food is solid or liquid.
     * @returns Food. it gets the value from the Dao and returns that value back to the controller
     * the value will be an object of food or it may be null.
     */
    public Food addFood(String name, String type) throws AnimalManagementException;

    /**
     * It calls the Dao with id as an argument and gets food associated with  that id.
     * once it will get food object from the Dao class it sends that object to the controller.
     * if there is no record on the particular id then null will be returned from the Dao
     * and same null will be returned to the controller of the food.
     *
     * @param id. It contains unique identification number of the food.
     * @returns Food object to the controller if Food object will be returned from the Dao.
     * if null will be returned from the Dao then it will return same null to the controller
     */
    public Food getFoodById(int id)  throws AnimalManagementException ;


    /**
     * It gets user inputs from the controller layer and passed same attributes to the the Dao
     * layer to update the existing record that marches the id.
     * 
     * @param name. It contains new name of the food.
     * @param type. It contains type of food, means that whether the food is solid or liquid food.
     * @return String. It will get the message about the successful or unsuccessful operation from
     * Dao and will directly pass the message to the controller.
     */
    public Food updateFoodById(String name, String type, int id, Food food) throws AnimalManagementException ;

    /**
     * It get gets id as a parameter and calls the Dao and passed that id to the dao
     * to delete a food from the records that has id as given id.
     * it gets called by the controller and calls the Dao to delete the food.
     *
     * @param id. It contains the unique identification number of the food.
     * @return true/false. It will return true of the record will be removed 
     * else it will return false to the controller.
     */
    public boolean deleteFoodById(int id)  throws AnimalManagementException ;

    /**
     * It gets name of the food and calls to Dao and asks to send those records that partially 
     * or fully matches the given name. 
     *
     * @param name. it may contain name or part of the food name.
     * @return foods. It will return list of foods to the controller.
     */
    public List<Food> getFoodsByName(String name) throws AnimalManagementException ;
    /**
     * It gets two IDs from the controller and calls the Dao to fetch all those records that lies between
     * the given IDs. 
     *
     * @param firstId. It is Initial id of the range.
     * @param secondId. It is last id of the range.
     * @return foods. It returns the list of the foods that lies between two given IDs.
     */
    public List<Food> getFoodsBetweenIds(int startingId, int endingId) throws AnimalManagementException ;

    /**
     * It gets food that matches with the given id and also it gets all those dogs who are assigned
     * with this food.
     *
     * @param id. It contains Unique identification number of a food.
     * @return foods. A list of foods that are assigned to the dog.
     */
    public List<Food> getFoodsByIds(String foodIds)  throws AnimalManagementException;
}