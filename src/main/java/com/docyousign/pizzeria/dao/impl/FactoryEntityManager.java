package com.docyousign.pizzeria.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryEntityManager {

	private final EntityManager manager;

	public FactoryEntityManager() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("pizzeriaweb");
		this.manager = factory.createEntityManager();
	}

	public EntityManager getInstance() {
		return this.manager;
	}

}
