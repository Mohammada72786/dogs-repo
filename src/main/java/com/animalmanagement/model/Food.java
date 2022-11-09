package com.animalmanagement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * It contains all the attributes of the food and also created and updates of the food.
 * It also includes the list of dogs that is eats the food.
 * In this class there are setter and getter methods to set values to the data members and get values of the 
 * data members.
 */
@Entity
public class Food extends BaseClass{

    private String name;
    private String type;
 
	@ManyToMany(mappedBy="foods", cascade = CascadeType.ALL)
    private List<Dog> dogs;

    public Food() {}

    public Food(String name, String foodType) {
        this.name = name;
        this.type = foodType;
    }

    public Food(String name, String foodType, int id, Date createdAt, Date updatedAt) {
        super(id, createdAt, updatedAt, 0);
        this.name = name;
        this.type = foodType;
    }

    public String getName() {
        return name;
    }
  
    public List<Dog> getDogs() {
        return dogs;
    }
    
    public String getType() {
        return type;
     }
  
    public void setName(String name) {
        this.name = name;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    } 
   
    public void setType(String type) {
        this.type = type;
    }
    public String toString() {
        return "\n*****************************************\n" 
             + "Food name     " +   getName()        +  "\n"
             + "Food type     " +   getType()        +  "\n"
             + "Food Id       " +   getId()          +  "\n"
             + "Update at     " +   getUpdatedAt()   +  "\n"
             + "Created at    " +   getCreatedAt(); 
    }    
}

