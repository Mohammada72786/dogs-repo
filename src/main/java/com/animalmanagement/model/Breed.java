package com.animalmanagement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * This class is used to define all the attributed of the breed and also contain methods to 
 * get and set values of the breed. It also contains list of dogs that are associated with breed.
 *
 */
@Entity
public class Breed extends BaseClass {
   
    private String name;
    private String countryOfOrigin;
	@OneToMany(mappedBy = "breed")
    private List<Dog> dogs;

    public Breed() {
    }

    public Breed(String name) {
        this.name = name;
    }

    public Breed(int id, String name, Date createdAt, Date updatedAt, int isDeleted) {
        super(id, createdAt, updatedAt, isDeleted);
        this.name = name;
    }
    public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
     

    public String getName() {
        return name;
    }
  
    public List<Dog> getDogs() {
        return dogs;
    }
  
    public void setName(String name) {
        this.name = name;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    } 
   
    public String toString() {
        return"__________________________________________________\n"
             +"Breed id            " +   getId()              +  "\n"
             + "Breed Name         " +   getName()            +  "\n"
             + "Country of Origin  " +   getCountryOfOrigin() +  "\n"
             + "Created at         " +   getCreatedAt()           +  "\n"
             + "Updated at         " +   getUpdatedAt();  
    }    
}

