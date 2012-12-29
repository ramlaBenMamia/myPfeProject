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

	public void save(Unite entity);

	public void delete(Unite entity);

	public Unite update(Unite entity);

	public List<Unite> findAll();

	public void removeUnite(Unite e);

	public List<String> findAllUnite();

	public Unite findByRef(int ref);

	void deleteByRef(int ref);

	public List<Unite> findByLibelle(String libelleUnite);

	public List<Unite> findByDescription(String description);

	public List<Unite> findByMatEnseignant(String matriculeEnseigant);
}