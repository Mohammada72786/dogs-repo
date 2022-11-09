package com.animalmanagement.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * This class contains all the attributes of the pet store.
 * It also contains the list of dogs that are associated with the pet store.
 *
 */ 
@Entity
public class PetStore extends BaseClass {
   
    private String name;
    private String address;
    @OneToMany(mappedBy="petStore")
    private List<Dog> dogs;

    public PetStore() {
    }

    public PetStore(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    public String getName() {
        return name;
    }
  
    public List<Dog> getDogs() {
        return dogs;
    }

    public String getAddress() {
        return address;
    }
  
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    } 

    public String toString() {
        return "****************************************\n"
              +"Store name     " +   getName()      +  "\n"
              +"Store Id       " +   getId()        +  "\n"
              +"updated at     " +   getUpdatedAt() +  "\n"
              +"Created at     " +   getCreatedAt() +  "\n"
              +"Store Address  " +   getAddress(); 
    }    
}

