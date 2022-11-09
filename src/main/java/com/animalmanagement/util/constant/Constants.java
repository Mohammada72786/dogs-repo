package com.animalmanagement.util.constant;

/**
 * This class is used to assign the values to the final static variable.
 *
 */
abstract public class Constants {

    public static final char YES = 'y';
    public static final char NO = 'n';
//  public static final int CAT = 1;
    public static final int DOG = 1;
    public static final int PET_STORE = 2;
    public static final int PET_FOOD = 3;
    public static final int BREED = 4;
    public static final int NAME = 1;
    public static final int WEIGHT = 3;
    public static final int COLOUR = 4;
    public static final int GENDER = 5;
    public static final int DOB = 6;
    public static final int FUR_TYPE = 7;
    public static final int EYE_COLOUR = 8;
    public static final int SPEED = 7;
    public static final int ADD = 1;
    public static final int SHOW = 2;
    public static final int DELETE = 3; 
    public static final int UPDATE = 4;
    public static final int SEARCH = 5;
    public static final int DISPLAY_MANY = 6;
    public static final int SEARCH_BETWEEN = 6;
    public static final int ASSIGN_FOODS = 7;
    public static final int FOOD_WITH_DOGS = 6;
    public static final int DISPLAY_BETWEEN = 7;
    public static final int DISPLAY_DOGS_BETWEEN_DATES = 8;    
    public static final String INVALID_INPUT = "Invalid input";
    public static final String ID_NOT_FOUND = "No id found please check your id and try again";
    public static final String INPUT_NAME = "Please enter Name";
    public static final String INPUT_BREED = "Please enter breed id";
    public static final String INPUT_WEIGHT = "Please enter weight in KGs";
    public static final String INPUT_COLOUR = "Please enter colour";
    public static final String INPUT_GENDER = "Select Gender\n1 Male\n2 female";
    public static final String INPUT_DOB = "Please enter DOB";
    public static final String INPUT_SPEED = "Please enter speed of dog in KM/h";
    public static final String INPUT_COUNTRY_OF_ORIGIN = "Please enter country of origin of the breed";
//  public static final String INPUT_FUR = "Please enter fur type"; 
//  public static final String INPUT_EYE = "Please enter eye colour";
    public static final String INPUT_ID = "Please enter Id";
    public static final String CAT_UPDATED = "Cat updated successfully";
    public static final String MAIN_MENU_OPTIONS = "Please choose among the following options\n\n1 dog\n2 pet Store\n3 Food\n4 breed";
    public static final String CAT_OPTIONS = "1 Add cat\n2 Show cat\n3 Delete cat\n4 Update\n5 Search Cat\n6 Search in range";
    public static final String DOG_MENU = " 1 Add dog\n 2 Show dog\n 3 Delete dog\n 4 Update dog\n 5 search Dog By Name\n 6 Search in range \n7 Assign Foods"
                                           +"\n8 Show dogs by  their Date of birth";
    public static final String PET_STORE_MENU = "1 Add petstore\n2 Show petstore by id\n3 Delete petstore\n4 update petstore\n5 Search petstore";
    public static final String FOOD_MENU = "1 Add Food\n2 Show Food\n3 Delete Food\n4 update Food\n5 Search Food\n6 Show food with dogs"; 
    public static final String BREED_MENU = "1 Add Breed\n2 Show Breed\n3 Delete Breed\n4 update Breed\n5 Search Breed\n6 Display Many breeds\n7 Display between Ids";    
    public static final String UPDATE_CAT_MENU = "Please select the field that you want to update\n"
                               +"1 Name\n2 Breed\n3 Weight\n4 Colour\n5 Gender\n"
                               +"6 DOB\n7 Fur Type\n8 Eye Colour";
    public static final String UPDATE_DOG_MENU = "Please select the field that you want to update\n"
                           +"1 Name\n2 Breed\n3 Weight\n4 Colour\n5 Gender\n"
                           +"6 DOB\n7 speed";
}