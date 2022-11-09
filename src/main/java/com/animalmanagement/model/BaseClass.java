package com.animalmanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


/**
 * This class contains common data fields and common methods that all the sub-models needed. 
 *
 */
@MappedSuperclass
public  class BaseClass {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
	
	@CreationTimestamp
	@Column(name = "created_at")
    private Date createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_At")
    private Date updatedAt;
	
	@ColumnDefault("0")
	@Column(name="is_deleted" , columnDefinition= "boolean")
    private int isDeleted;

    public BaseClass() {
        this.isDeleted = 0;
    }

 
    public BaseClass(int id, Date createdAt, Date updatedAt, int isDeleted) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isDeleted = isDeleted;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    
    }
    
    public int getId() {
        return this.id;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }
    
    public int getIsDeleted() {
        return isDeleted;
    } 
    
}