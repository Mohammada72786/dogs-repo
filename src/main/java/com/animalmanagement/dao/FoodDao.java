package com.animalmanagement.dao;

import java.util.List;

import com.animalmanagement.util.exception.AnimalManagementException;
import com.animalmanagement.model.Food;

public interface FoodDao {

    /**
     * This method gets an object of Food from the service class and adds a new record to the
     * list of existing records.
     *
     * @param food. It contains data about the attributes of the food.
     * @return food. After the add operation to the database it returns food object back to the service layes.
     */
    public Food insertFood(Food food) throws AnimalManagementException ;

    /**
     * It fetches the food from  the foods table that matches the given id.
     * After it fetches the data from the database it assigns to an object of food and returns 
     * back to the service.
     * @param id. It contains id of a food on which it gets record from the foods table.
     * @return Food. after it fetches the data from the database it makes its object and returns to the service layes.
     */
    public Food getFoodById(int id)  throws AnimalManagementException ;
    
    /**
     * It is used to update the record on the database that holds the given id.
     * If there will be any record on the given id it will replace all its old values with new values.
     * @param name. Contains  new name of food.
     * @param type. It contains data whether the food type is solid or liquid.
     * @param id. It contains the id on which it updates the records.
     * @return. It returns the user message whether the record  updated successfully or not.
     */
    public Food updateFoodById(Food food) throws AnimalManagementException ;

    /**
     * It gets id as food id and removes that food from the list of foods.
     *
     * @param id. It contains the identification number of the food.
     * @return. It returns true if the record will be removed from the database
     * else it returns false to the service.
     */
    public int deleteFoodById(int id)  throws AnimalManagementException;

     /**
     * It searches from the list of all records from the database and will find all those records
     * that partially matches the given string and makes the list of all those records in the map
     * and then returns back to the service class.
     *
     * @param name. it contains name of the food.
     * @return it returns the map that contains list of the foods that holds the given name as name.
     */
    public List<Food> getFoodsByName(String name) throws AnimalManagementException ;

    /**
     * It fetches all the records that lies between the given pair of IDs 
     * 
     * @param firstId.  It contains first identification number of food.
     * @param secondId. It contains last identification number of food range.
     * @return Map<Integer,Food>, It contains all those foods that lies between the given range.
     */
    public List<Food> getFoodsBetweenIds(int startingId, int endingId) throws AnimalManagementException ;

    /**
     * It gets food that is associate with the given id.
     * It also fetches all those dogs that eats that food.
     *
     * @param id. it contains identification number of the food.
     * @return Food. Contains the food that has food id as given id.
     * it also contains list of dogs that are eating this particular food.
     */
    public List<Food> getFoodsByIds(String foodIds)  throws AnimalManagementException;
}