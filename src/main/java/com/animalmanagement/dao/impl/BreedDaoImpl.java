package com.animalmanagement.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;

//import com.animalmanagement.util.connection.HibernateConnection;

import com.animalmanagement.dao.BreedDao;
import com.animalmanagement.model.Breed;
import com.animalmanagement.util.PetLogger;
import com.animalmanagement.util.connection.HibernateConnection;
import com.animalmanagement.util.exception.AnimalManagementException;

/**
 * This class is implementation of Breed DAO here are the definition of all those methods that 
 * are mentioned in breedDao interface.
 *
 *
 */
public class BreedDaoImpl implements BreedDao {
  
    public Breed insertBreed(Breed breed) throws AnimalManagementException {
    	Session session = null;
    	SessionFactory factory = null;
    	try {
		    factory = HibernateConnection.getConnection();
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(breed);
			transaction.commit();
		 	return breed;
       } catch (HibernateException exception) {
    	   throw new AnimalManagementException("Error occured while inserting data");
       } finally {
    	   session.close();
       }
    }

    /**
     * {@Inheritdoc}
     */
	public Breed getBreedById(int id) throws AnimalManagementException  {
	    Breed breed = null;
	    Session session = null;
	    try {
	    	SessionFactory factory = HibernateConnection.getConnection();
		    session = factory.openSession();
		    breed = session.get(Breed.class,id);
	    } catch(HibernateException exception) {
	    	throw new AnimalManagementException("Error occured while fetching data");
	    } finally {
		    session.close();
	    }
	    return breed;
    }

    /**
     * {@Inheritdoc}
     */
    public Breed updateBreedById(Breed breed) throws AnimalManagementException {   	
        Session session = null;
        SessionFactory factory = HibernateConnection.getConnection();
        try {
        	session = factory.openSession();
        	Transaction transaction = session.beginTransaction();
    	    session.update(breed);
    	    transaction.commit();
    	    return breed;
       } catch (HibernateException exception) {
    	   throw new AnimalManagementException("Error occured while updating Breed" + exception.getMessage()); 
       }finally {
    	   session.close();
       }   
    }

    /**
     * {@Inheritdoc}
     */     
    public int deleteBreedById(int id)  throws AnimalManagementException{
    	SessionFactory factory = HibernateConnection.getConnection();
    	Session session = factory.openSession();
    	int flag = 0;
    	try {
        	Transaction transaction = session.beginTransaction();  
        	Query<Breed> query  = session.createQuery(
        			"update Breed set is_deleted = 1 where id = :id and is_deleted = '0'");
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

    /**
     * {@Inheritdoc}
     */
    public List<Breed> getBreedsByName(String name) throws AnimalManagementException {
        List<Breed> breeds = null;
        SessionFactory factory = HibernateConnection.getConnection();
        Session session = factory.openSession();
        try {
        	Criteria criteria = session.createCriteria(Breed.class);
    		criteria.add(Restrictions.like("name","%"+name+"%"));
    		//criteria.add(Restrictions.eq("isDeleted", '0'));
    		breeds = criteria.list();        
        } catch (HibernateException exception) {
        	throw new AnimalManagementException("error occured while fetching data. Please check your input"
        			+exception.getMessage());
        } finally {
        	session.close();
        } 
        return breeds;
    }

    /**
     * {@Inheritdoc}
     */
    public List<Breed> getBreedsBetweenIds(int startingId, int endingId)  throws AnimalManagementException  {
    	List<Breed> breeds = null;
        SessionFactory factory = HibernateConnection.getConnection();
        Session session = factory.openSession();
        try {
    		Criteria criteria = session.createCriteria(Breed.class);
    		criteria.add(Restrictions.between("id", startingId,endingId));
    		breeds= criteria.list();
        } catch(HibernateException exception) {
        	throw new AnimalManagementException("Error while fetching data please check your input"
        			+exception.getMessage());
        } finally {
        	session.close();
        }
        return breeds;
    }

	public List<Breed> getBreedsByIds(String breedIds)  throws AnimalManagementException  {
    	Session session = null;
    	try {
        	SessionFactory factory = HibernateConnection.getConnection();
            session = factory.openSession();
            StringBuffer inQuery = new StringBuffer();
            inQuery.append("from Breed where id in(");
            inQuery.append(breedIds);
            inQuery.append(") and is_deleted = 0");
            Query query = session.createQuery(inQuery.toString(),Breed.class);
            return query.getResultList();
    	} catch (HibernateException exception) {
    		throw new AnimalManagementException("error occured while deleting"+exception.getMessage());
    	} finally {
        	session.close();
    	}
    } 
}