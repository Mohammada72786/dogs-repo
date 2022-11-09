package com.animalmanagement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.animalmanagement.util.constant.Gender;
import com.animalmanagement.util.DateUtil;

/**
 * This class contains all the attributes related to the dog and also contains methods
 * to set values its attributed and to get values from its attributs.
 * It also contains the list of foods that a dog eats.
 */
@Entity
public class Dog extends BaseClass{
    private String name;
    private float weight;
    private String colour;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date dateOfBirth;
    private float speed;
    private String dogCode;
    @ManyToOne
    private PetStore petStore;
    @ManyToOne  
    private Breed breed;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Food> foods;
    public Dog() {
    }

    public Dog(String name, 
        float weight, 
        String colour, 
        Gender gender, 
        Date dateOfBirth, 
        float speed,
        String dogCode) {
        this.name = name;
        this.weight = weight;
        this.colour = colour;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.speed = speed; 
        this.dogCode = dogCode;
    }

    public void setName (String name) {
        this.name = name;
    }
    

    public void setDogCode(String dogCode) {
        this.dogCode = dogCode;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    public void setFoods(List<Food> foods) {
	this.foods = foods;
    }
    
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setDob(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }


    public Gender getGender() {
        return gender;
    }


    public float getWeight() {
        return weight;
    }


    public Date getDob() {
        return dateOfBirth;
    }


    public float getSpeed() {
	return speed;
    }

    public String getDogCode() {
        return dogCode;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }
    
    public PetStore getPetStore() {
        return petStore;
    }

    public List<Food> getFoods() {
	return foods;
    }
  
    public Breed getBreed() {
        return breed;
    }

    public String toString() {
        return ("******************************************************\n"
              + "Name of dog is            : " + getName()       + "\n"  
              + "ID of your dog is         : " + getId()    + "\n" 
              + "DOB of dog is 	          : " + getDob()        + "\n" 
              + "speed of  dog is          : " + getSpeed()      + "\n" 
              + "Colour of dog is          : " + getColour()     + "\n" 
              + "Gender of your dog is     : " + getGender()     + "\n"
              +"Created at                : " + getCreatedAt()  + "\n"
              +"Updated at                : " + getUpdatedAt() + "\n"
              + "Age of the dog is         : "// + getAge()+ " years \n" 
              + "____________________________________________"
	      );
    } 
}