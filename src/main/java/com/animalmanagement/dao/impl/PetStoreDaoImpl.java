package com.animalmanagement.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.animalmanagement.dao.PetStoreDao;
import com.animalmanagement.model.PetStore;
import com.animalmanagement.util.connection.HibernateConnection;
import com.animalmanagement.util.exception.AnimalManagementException;

public class PetStoreDaoImpl implements PetStoreDao {
  
    public PetStore insertPetStore(PetStore petStore) throws AnimalManagementException {
    	Session session = null;
    	SessionFactory factory = null;
    	try {
		    factory = HibernateConnection.getConnection();
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(petStore);
			transaction.commit();
		 	return petStore;
       } catch (HibernateException exception) {
    	   throw new AnimalManagementException("Error occured while inserting data");
       } finally {
    	   session.close();
       }
    }

    public PetStore getPetStoreById(int id) throws AnimalManagementException {
    	PetStore petStore = null;
	    Session session = null;
	    try {
	    	SessionFactory factory = HibernateConnection.getConnection();
		    session = factory.openSession();
		    petStore = session.get(PetStore.class,id);
		    return petStore;
	    } catch(HibernateException exception) {
	    	throw new AnimalManagementException("Error occured while fetching data");
	    } finally {
		    session.close();
	    }
    }

    /**
     *{@InhertiDoc}
     */
    public PetStore updatePetStoreById(PetStore petStore) throws AnimalManagementException{
    	Session session = null;
        SessionFactory factory = HibernateConnection.getConnection();
        try {
        	session = factory.openSession();
        	Transaction transaction = session.beginTransaction();
    	    session.update(petStore);
    	    transaction.commit();
    	    return petStore;
       } catch (HibernateException exception) {
    	   throw new AnimalManagementException("Error occured while updating pet store" + exception.getMessage()); 
       }finally {
    	   session.close();
       }   
    }

     
    public int deletePetStoreById(int id) throws AnimalManagementException {
    	SessionFactory factory = HibernateConnection.getConnection();
    	Session session = factory.openSession();
    	int flag = 0;
    	try {
        	Transaction transaction = session.beginTransaction();  
        	Query<?> query  = session.createQuery(
        			"update PetStore set is_deleted = 1 where id = :id and is_deleted = '0'");
        	query.setParameter("id",id);
        	flag = query.executeUpdate();
        	transaction.commit();
    	} catch(HibernateException exception) {
    		throw new AnimalManagementException("error occured while deleting"
    				+exception.getMessage());
    	} finally {
    		session.close();
    	}
    	return flag;
    }

    public List<PetStore> getPetStoresByName(String name)throws AnimalManagementException {
    	List<PetStore> petStores = null;
        SessionFactory factory = HibernateConnection.getConnection();
        Session session = factory.openSession();
        try {
        	Criteria criteria = session.createCriteria(PetStore.class);
    		criteria.add(Restrictions.like("name","%"+name+"%"))
    		.add(Restrictions.eq("isDeleted", 0));
    		petStores = criteria.list();        
        } catch (HibernateException exception) {
        	throw new AnimalManagementException("error occured while fetching data. Please check your input"
        			+exception.getMessage());
        } finally {
        	session.close();
        } 
        return petStores;
    }
    
  
//to do
    public List<PetStore> getPetStoresBetweenIds(int firstId, int lastId) throws AnimalManagementException {
     return null;
  
    } 
}