package com.formation.foodtruck.model.dao.impl.jpa;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.formation.foodtruck.model.dao.ClientDAO;
import com.formation.foodtruck.model.entity.Client;

@Repository
public class ClientDAOImplJPA implements ClientDAO {


	/**
	 * Appel de l'entityManager pour intégration en base
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Méthode de création d'un client en base
	 *
	 */

	@Override
	public boolean create(Client client) throws SQLException {
		if (client == null) {
			return false;
		}
		entityManager.persist(client);
		return true;
	}

	/**
	 * Méthode de suppression d'un client en base
	 *
	 */

	@Override
	public boolean delete(Client client) throws SQLException {
		if (client == null) {
			return false;
		}
		//entityManager.remove(client);
		entityManager.merge(client);
		return true;
	}

	/**
	 * Méthode de modification d'un client en base
	 *
	 */

	@Override
	public boolean update(Client client) throws SQLException {
		if (client == null || client.isDelete()) {
			return false;
		}
		entityManager.merge(client);
		return true;
	}

	/**
	 * Méthode pour trouver un client via son ID
	 *
	 */

	@Override
	public Client find(Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		final Client client = entityManager.find(Client.class, id);
		if (client == null){
			return null;
		}
		return (client.isDelete()) ? null : client;
	}

	/**
	 * méthode pour récupérer tous les clients de la base stockés dans une liste
	 * création d'une requête puis affichage via l'entityManager
	 */

	@Override
	public List<Client> findAll() {
		final String request = "select c from Client c where c.delete = false";
		final TypedQuery<Client> query = entityManager.createQuery(request,
				Client.class);
		return query.getResultList();
	}

}
