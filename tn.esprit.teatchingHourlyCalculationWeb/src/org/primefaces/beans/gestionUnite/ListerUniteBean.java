package org.primefaces.beans.gestionUnite;

import java.util.List;

import javax.ejb.EJB;

import com.esprit.entity.Unite;
import com.esprit.service.gestionUnite.GestionUniteLocal;

public class ListerUniteBean {
	@EJB
	GestionUniteLocal bean;
	List<String> unites;
	List<Unite> listeUnites;
	Unite unite;
	private Unite selectedUnite;

	public List<String> getUnites() {
		unites=bean.findAllUnite();
		return unites;
	}

	public void setUnites(List<String> unites) {
		this.unites = unites;
	}

	public List<Unite> getListeUnites() {
		listeUnites = bean.findAll();
		return listeUnites;
	}

	public void setListeUnites(List<Unite> listeUnites) {
		this.listeUnites = listeUnites;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	public Unite getSelectedUnite() {
		return selectedUnite;
	}

	public void setSelectedUnite(Unite selectedUnite) {
		this.selectedUnite = selectedUnite;
	}

	public void delete() {
		bean.removeUnite(selectedUnite);
	}

}
