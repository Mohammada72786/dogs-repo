package com.animalmanagement.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.animalmanagement.dao.FoodDao;
import com.animalmanagement.model.Breed;
import com.animalmanagement.model.Food;
import com.animalmanagement.util.connection.HibernateConnection;
import com.animalmanagement.util.exception.AnimalManagementException;

/**
 * This class overrite all those methods that are in FoodDao. In this class
 * there is implementation of each and every method that are mentioned in
 * FoodDao.
 */
public class FoodDaoImpl implements FoodDao {

	/**
	 * {@InheritDoc}
	 *
	 */
	public Food insertFood(Food food) throws AnimalManagementException {
		Session session = null;
		SessionFactory factory = null;
		try {
			factory = HibernateConnection.getConnection();
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(food);
			transaction.commit();
			return food;
		} catch (HibernateException exception) {
			throw new AnimalManagementException("Error occured while inserting data");
		} finally {
			session.close();
		}
	}

	/**
	 * {@InheritDoc}
	 *
	 */
	public Food getFoodById(int id) throws AnimalManagementException {
		Food food = null;
		Session session = null;
		try {
			SessionFactory factory = HibernateConnection.getConnection();
			session = factory.openSession();
			food = session.get(Food.class, id);
		} catch (HibernateException exception) {
			throw new AnimalManagementException("Error occured while fetching data");
		} finally {
			session.close();
		}
		return food;
	}

	/**
	 * {@InheritDoc}
	 *
	 */
	public Food updateFoodById(Food food) throws AnimalManagementException {
		Session session = null;
		SessionFactory factory = HibernateConnection.getConnection();
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(food);
			transaction.commit();
			return food;
		} catch (HibernateException exception) {
			throw new AnimalManagementException("Error occured while updating Breed" + exception.getMessage());
		} finally {
			session.close();
		}
	}

	/**
	 * {@InheritDoc}
	 *
	 */
	public int deleteFoodById(int id) throws AnimalManagementException {
		SessionFactory factory = HibernateConnection.getConnection();
		Session session = factory.openSession();
		int flag = 0;
		try {
			Transaction transaction = session.beginTransaction();
			Query<?> query = session
					.createQuery("update Food set is_deleted = 1 where id = :id and is_deleted = 0");
			query.setParameter("id", id);
			flag = query.executeUpdate();
			transaction.commit();
			return flag;
		} catch (HibernateException exception) {
			throw new AnimalManagementException("error occured while deleting" + exception.getMessage());
		} finally {
			session.close();
		}
	}

	/**
	 * {@InheritDoc}
	 *
	 */
	public List<Food> getFoodsByName(String name) throws AnimalManagementException {
		SessionFactory factory = HibernateConnection.getConnection();
		Session session = factory.openSession();
		try {
			Criteria criteria = session.createCriteria(Food.class);
			criteria.add(Restrictions.like("name", "%"+name+"%"));
			// criteria.add(Restrictions.eq("isDeleted", '0'));
			return criteria.list();
		} catch (HibernateException exception) {
			throw new AnimalManagementException("error occured while fetching data" + exception.getMessage());
		} finally {
			session.close();
		}
	}

	/**
	 * {@InheritDoc}
	 *
	 */
	public List<Food> getFoodsBetweenIds(int startingId, int endingId) throws AnimalManagementException {
		List<Food> foods = null;
        SessionFactory factory = HibernateConnection.getConnection();
        Session session = factory.openSession();
        try {
    		Criteria criteria = session.createCriteria(Food.class);
    		criteria.add(Restrictions.between("id", startingId,endingId));
    		foods= criteria.list();
        } catch(HibernateException exception) {
        	throw new AnimalManagementException("Error while fetching data please check your input"
        			+exception.getMessage());
        } finally {
        	session.close();
        }
        return foods;
    }

	/**
	 * {@InheritDoc}
	 *
	 */
	public List<Food> getFoodsByIds(String foodIds)  throws AnimalManagementException  {
    	Session session = null;
    	try {
        	SessionFactory factory = HibernateConnection.getConnection();
            session = factory.openSession();
            StringBuffer inQuery = new StringBuffer();
            inQuery.append("from Food where id in(");
            inQuery.append(foodIds);
            inQuery.append(") and isDeleted = 0");
            Query query = session.createQuery(inQuery.toString(),Food.class);
            return query.getResultList();
    	} catch (HibernateException exception) {
    		throw new AnimalManagementException("error occured while fetching Foods"+exception.getMessage());
    	} finally {
        	session.close();
    	}
    } 
}