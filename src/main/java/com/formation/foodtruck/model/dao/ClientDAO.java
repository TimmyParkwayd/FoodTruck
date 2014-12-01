package com.formation.foodtruck.model.dao;

import com.formation.foodtruck.model.entity.Client;

import java.util.List;

public interface ClientDAO extends DAO<Client> {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Client> findAll();
}
