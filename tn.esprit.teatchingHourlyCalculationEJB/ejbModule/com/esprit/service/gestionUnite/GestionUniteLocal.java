package com.esprit.service.gestionUnite;

import java.util.List;
import javax.ejb.Local;

import com.esprit.entity.Unite;

/**
 * Local interface for GestionProjet.
 * 
 * @author MyEclipse Persistence Tools
 */
@Local
public interface GestionUniteLocal {
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
	public void save(Unite entity);

	/**
	 * Delete a persistent Projet entity.
	 * 
	 * @param entity
	 *            Projet entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Unite entity);

	/**
	 * Persist a previously saved Unite entity and return it or a copy of
	 * it to the sender. A copy of the Unite entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity.
	 * 
	 * @param entity
	 *            Unite entity to update
	 * @return Unite the persisted Unite entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Unite update(Unite entity);

	public Unite findById(Long id);

	/**
	 * Find all Unite entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Unite property to query
	 * @param value
	 *            the property value to match
	 * @return List<Unite> found by query
	 */

	/**
	 * Find all Unite entities.
	 * 
	 * @return List<Unite> all Unite entities
	 */
	public List<Unite> findAll();


	public void removeUnite(Unite e);
	public List<String> findAllUnite();
	public Unite findByRef(int ref);
	
	void deleteByRef(int ref);


	
	
	
	
	
	public List<Unite> findByLibelle(String libelleUnite);
	public List<Unite> findByDescription(String description);
	
	public List<Unite> findByMatEnseignant(String matriculeEnseigant);
}