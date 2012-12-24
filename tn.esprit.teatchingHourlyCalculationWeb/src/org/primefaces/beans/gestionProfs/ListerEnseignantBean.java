package org.primefaces.beans.gestionProfs;

import java.util.List;

import javax.ejb.EJB;

import com.esprit.entity.Enseignant;
import com.esprit.service.gestionEnseignant.GestionEnseignantLocal;

public class ListerEnseignantBean {
	@EJB
	GestionEnseignantLocal bean;
	List<String> enseignants;
	List<Enseignant> listeEnseignants;
	Enseignant enseignant;
	private Enseignant selectedEnseignant;

	public List<String> getEnseignants() {
		enseignants = bean.findAllEnseignant();

		return enseignants;
	}

	public void setEnseignants(List<String> enseignants) {
		this.enseignants = enseignants;
	}

	public List<Enseignant> getListeEnseignants() {
		listeEnseignants = bean.findAll();
		return listeEnseignants;
	}

	public void setListeEnseignants(List<Enseignant> listeEnseignants) {
		this.listeEnseignants = listeEnseignants;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Enseignant getSelectedEnseignant() {
		return selectedEnseignant;
	}

	public void setSelectedEnseignant(Enseignant selectedEnseignant) {
		this.selectedEnseignant = selectedEnseignant;
	}

	public void delete() {
		bean.removeEnseignant(selectedEnseignant);
	}

}
