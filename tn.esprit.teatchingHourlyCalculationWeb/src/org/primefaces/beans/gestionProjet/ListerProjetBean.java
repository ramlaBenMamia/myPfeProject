package org.primefaces.beans.gestionProjet;

import java.util.List;

import javax.ejb.EJB;

import com.esprit.entity.Projet;
import com.esprit.service.gestionProjet.GestionProjetLocal;

public class ListerProjetBean {
	@EJB
	GestionProjetLocal bean;
	List<String> projets;
	List<Projet> listeProjets;
	Projet projet;
	private Projet selectedProjet;

	public List<String> getProjets() {
		projets=bean.findAllProjet();
		return projets;
	}

	public void setProjets(List<String> projets) {
		this.projets = projets;
	}

	public List<Projet> getListeProjets() {
		listeProjets = bean.findAll();
		return listeProjets;
	}

	public void setListeProjets(List<Projet> listeProjets) {
		this.listeProjets = listeProjets;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Projet getSelectedProjet() {
		return selectedProjet;
	}

	public void setSelectedProjet(Projet selectedProjet) {
		this.selectedProjet = selectedProjet;
	}

	public void delete() {
		bean.removeProjet(selectedProjet);
	}

}
