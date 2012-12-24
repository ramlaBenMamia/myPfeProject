package com.esprit.service.gestionProjet;

import java.util.List;

import javax.ejb.Local;

import com.esprit.entity.Projet;

/**
 * Local interface for GestionProjet.
 * 
 * @author MyEclipse Persistence Tools
 */
@Local
public interface GestionProjetLocal {
	/**
	 * Perform an initial save of a previously unsaved Projet entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method.
	 * 
	 * @param entity
	 *            Projet entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Projet entity);

	/**
	 * Delete a persistent Projet entity.
	 * 
	 * @param entity
	 *            Projet entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Projet entity);

	/**
	 * Persist a previously saved Projet entity and return it or a copy of it to
	 * the sender. A copy of the Projet entity parameter is returned when the
	 * JPA persistence mechanism has not previously been tracking the updated
	 * entity.
	 * 
	 * @param entity
	 *            Projet entity to update
	 * @return Projet the persisted Projet entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Projet update(Projet entity);

	public Projet findById(int id);

	/**
	 * Find all Projet entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Projet property to query
	 * @param value
	 *            the property value to match
	 * @return List<Projet> found by query
	 */

	/**
	 * Find all Projet entities.
	 * 
	 * @return List<Projet> all Projet entities
	 */
	public List<Projet> findAll();

	public void removeProjet(Projet e);

	public List<String> findAllProjet();

	public Projet findByRef(int ref);

	void deleteByRef(int ref);

	public List<Projet> findByLibelle(String libelleProjet);

	public List<Projet> findByDescription(String description);

	public List<Projet> findByMatEnseignant(String matriculeEnseigant);

	public void addProject(Projet projet);
}