package com.formation.foodtruck.model.dao.impl.jpa;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.formation.foodtruck.model.dao.CommandDAO;
import com.formation.foodtruck.model.entity.Command;

public class CommandDAOImplJPA implements CommandDAO{

	/**
	 * Appel de l'entityManager pour intégration en base
	 */
	private EntityManager entityManager;


	/**
	 * Méthode de création d'une commande en base
	 *
	 */

	@Override
	public boolean create(Command cmd) throws SQLException {
		if (cmd == null){
			return false;
		}
		entityManager.persist(cmd);
		return true;
	}

	/**
	 * Méthode de suppression d'une commande en base
	 *
	 */

	@Override
	public boolean delete(Command cmd) throws SQLException {
		if (cmd == null){
			return false;
		}
		entityManager.remove(cmd);
		return true;
	}

	/**
	 * Méthode de modification d'une commande en base
	 *
	 */

	@Override
	public boolean update(Command cmd) throws SQLException {
		if (cmd == null){
			return false;
		}
		entityManager.persist(cmd);
		return true;
	}

	/**
	 * Méthode pour trouver une commande via son ID
	 *
	 */

	@Override
	public Command find(Integer id) throws SQLException {
		if (id == null){
			return null;
		}
		return entityManager.find(Command.class, id);
	}

	/**
	 * méthode pour récupérer toutes les commandes de la base stockés dans une liste
	 * création d'une requête puis affichage via l'entityManager
	 */

	@Override
	public List<Command> findAll() {
		final String request = "select * from articla a";
		final TypedQuery<Command> query = entityManager.createQuery(request, Command.class);
		return query.getResultList();
	}

}