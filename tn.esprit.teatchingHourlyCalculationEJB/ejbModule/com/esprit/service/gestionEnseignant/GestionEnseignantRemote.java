package com.esprit.service.gestionEnseignant;

import java.util.List;
import javax.ejb.Remote;

import com.esprit.entity.Enseignant;

/**
 * Remote interface for GestionEnseignant.
 * 
 * @author MyEclipse Persistence Tools
 */
@Remote
public interface GestionEnseignantRemote {
	/**
	 * Perform an initial save of a previously unsaved Enseignant entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method.
	 * 
	 * @param entity
	 *            Enseignant entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Enseignant entity);

	/**
	 * Delete a persistent Enseignant entity.
	 * 
	 * @param entity
	 *            Enseignant entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Enseignant entity);

	/**
	 * Persist a previously saved Enseignant entity and return it or a copy of
	 * it to the sender. A copy of the Enseignant entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity.
	 * 
	 * @param entity
	 *            Enseignant entity to update
	 * @return Enseignant the persisted Enseignant entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Enseignant update(Enseignant entity);

	public Enseignant findByMat(String mat);

	/**
	 * Find all Enseignant entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Enseignant property to query
	 * @param value
	 *            the property value to match
	 * @return List<Enseignant> found by query
	 */
	public List<Enseignant> findByProperty(String propertyName, Object value);

	/**
	 * Find all Enseignant entities.
	 * 
	 * @return List<Enseignant> all Enseignant entities
	 */
	public List<Enseignant> findAll();

	public Enseignant findByUser(String login, String pwd);

	public void removeEnseignant(Enseignant e);
	
	public int volumeHoraireTotalParEnseignant(String matEnseignant);
	
	public int volumeHoraireTotalParEnseignantActivite(String matEnseignant);


}