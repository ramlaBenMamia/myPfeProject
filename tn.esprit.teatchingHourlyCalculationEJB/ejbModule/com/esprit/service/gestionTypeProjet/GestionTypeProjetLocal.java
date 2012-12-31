package com.esprit.service.gestionTypeProjet;

import java.util.List;

import javax.ejb.Local;

import com.esprit.entity.TypeProjet;

/**
 * Local interface for GestionProjet.
 * 
 * @author MyEclipse Persistence Tools
 */
@Local
public interface GestionTypeProjetLocal {

	public void save(TypeProjet entity);

	public void delete(TypeProjet entity);

	public TypeProjet update(TypeProjet entity);

	public List<TypeProjet> findAll();

	public void removeTypeProjet(TypeProjet e);

	public List<String> findAllTypeProjet();

	public TypeProjet findById(int id);

	void deleteById(int id);

	public List<TypeProjet> findByLibelle(String libelleTypeProjet);

	public List<TypeProjet> findByMatEnseignant(String matriculeEnseigant);
	
	
}