package com.formation.foodtruck.model.dao;

import java.util.List;

import com.formation.foodtruck.model.entity.Command;

public interface CommandDAO extends DAO<Command> {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Command> findAll();

}
