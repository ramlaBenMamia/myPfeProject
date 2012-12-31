package com.esprit.service.gestionActivite;

import java.util.List;

import javax.ejb.Local;

import com.esprit.domain.gestionEntites.IGestionGeneric;
import com.esprit.entity.Activite;

@Local
public interface GestionActiviteLocal extends IGestionGeneric<Activite> {
	
	
	public List<Activite> findByNom(String nomActivite);

	public List<Activite> findByDescription(String description);

	public List<String> findAllTypeActivite();

	public List<Activite> findAll();

	public void removeActivite(Activite e);

	public List<String> findAllActivite();

	public Activite findByRef(int ref);

	void deleteByRef(int ref);

	public List<Activite> findByLibelle(String libelleActivite);

	public List<Activite> findByMatEnseignant(String matriculeEnseigant);

	public void addActivite(Activite activite);

}
