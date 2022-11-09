package com.animalmanagement.util.connection;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

import com.animalmanagement.model.BaseClass;
import com.animalmanagement.model.Breed;
import com.animalmanagement.model.Dog;
import com.animalmanagement.model.Food;
import com.animalmanagement.model.PetStore;

abstract public class HibernateConnection {

	private static Configuration configuration;
	private static SessionFactory factory;

	static {
		configuration = new Configuration().configure().addAnnotatedClass(BaseClass.class).addAnnotatedClass(Dog.class)
				.addAnnotatedClass(Breed.class).addAnnotatedClass(PetStore.class).addAnnotatedClass(Food.class);
		factory = configuration.buildSessionFactory();
	}

	private HibernateConnection() {

	}

	public static SessionFactory getConnection() {
		return factory;
	}
}
