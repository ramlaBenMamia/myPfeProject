package com.esprit.domain.gestionEntites.gestionActivite;

import java.util.List;

import javax.ejb.Local;

import com.esprit.domain.gestionEntites.IGestionGeneric;
import com.esprit.entity.Activite;

@Local
public interface GestionActiviteLocal extends IGestionGeneric<Activite> {
	public List<Activite> findByNom(String nomActivite);

	public List<Activite> findByDescription(String description);
	public List<String> findAllTypeActivite();
	

}
