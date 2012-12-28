package org.primefaces.beans.gestionActivite;

import java.util.List;

import javax.ejb.EJB;

import com.esprit.service.gestionActivite.GestionActiviteLocal;
import com.esprit.entity.Activite;

public class ListeActiviteCtr {
	private Activite activite = new Activite();
	private List<String> typeActivites;
	private Activite selectedActivite;
	private List<Activite> listeActivites;

	@EJB
	GestionActiviteLocal bean;

	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	public List<String> getTypeActivites() {
		typeActivites = bean.findAllTypeActivite();
		return typeActivites;
	}

	public void setTypeActivites(List<String> typeActivites) {
		this.typeActivites = typeActivites;
	}

	public Activite getSelectedActivite() {
		return selectedActivite;
	}

	public void setSelectedActivite(Activite selectedActivite) {
		this.selectedActivite = selectedActivite;
	}

	public List<Activite> getListeActivites() {
		listeActivites = bean.findAll();
		return listeActivites;
	}

	public void setListeActivites(List<Activite> listeActivites) {
		this.listeActivites = listeActivites;
	}

}
