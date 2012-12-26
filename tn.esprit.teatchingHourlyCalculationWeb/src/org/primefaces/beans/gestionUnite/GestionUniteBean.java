package org.primefaces.beans.gestionUnite;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import com.esprit.entity.Unite;
import com.esprit.service.gestionEnseignant.GestionEnseignantLocal;
import com.esprit.service.gestionUnite.GestionUniteLocal;

public class GestionUniteBean {
	@EJB
	GestionUniteLocal bean;

	List<Unite> unites;
	Unite unite;
	private List<String> nomUnite;
	private String nomUnit;

	String label = "Choisir";

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setUnites(List<Unite> Unites) {
		this.unites = Unites;
	}

	public Unite getUnite() {
		if (unite == null) {
			unite = new Unite();
		}

		return unite;
	}

	public void setUnite(Unite Unite) {
		this.unite = Unite;
	}

	public List<Unite> getUnites() {
		return unites;
	}

	public void doAddUnite() {

		bean.save(unite);

	}

	// *******************************
	// affectation*********************************

	private List<SelectItem> unitesElements;

	private String libelleUnite;

	private String description;

	private String etatUnite;

	private String nomEnseignant;

	private DataModel dataModel = new ListDataModel();

	@EJB
	private GestionUniteLocal gestionUniteLocal;
	@EJB
	private GestionEnseignantLocal gestionEnseignantLocal;

	public void init() {
		Unite unite = new Unite();

	}

	public List<SelectItem> getUnitesElements() {

		List<Unite> unites = gestionUniteLocal.findAll();
		if (unitesElements == null) {
			unitesElements = new ArrayList<SelectItem>();
			for (Unite F : unites) {
				unitesElements.add(new SelectItem(F.getNomUnite()));
			}
		}

		return unitesElements;
	}

	public void setUnitesElements(List<SelectItem> unitesElements) {
		this.unitesElements = unitesElements;
	}

	public String getLibelleUnite() {
		return libelleUnite;
	}

	public void setLibelleUnite(String libelleUnite) {
		this.libelleUnite = libelleUnite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEtatUnite() {
		return etatUnite;
	}

	public void setEtatUnite(String etatUnite) {
		this.etatUnite = etatUnite;
	}

	public String getNomEnseignant() {
		return nomEnseignant;
	}

	public void setNomEnseignant(String nomEnseignant) {
		this.nomEnseignant = nomEnseignant;
	}

	public DataModel getDataModel() {
		dataModel.setWrappedData(gestionUniteLocal.findAll());

		return dataModel;
	}

	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	// -------------------------------Ajouter une nouvelle
	// affectation------------------------------

	

	// ------------------------------Mise a jour affectation
	// ---------------------------------
	public String update() {
		unite = (Unite) dataModel.getRowData();
		gestionUniteLocal.update(unite);
		return "updateUnite";
	}

	// -------------------------------Supression affectation
	// ---------------------------------
	public String delete() {
		unite = (Unite) dataModel.getRowData();
		gestionUniteLocal.deleteByRef(unite.getRefUnite());
		return "deleteUnite";

	}

	// -------------------------------Mise a jour affectation
	// --------------------------------
	public void updateUnite(ActionEvent actionEvent) {

		gestionUniteLocal.update(unite);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("update with success !!! "));

	}

	// -------------------------------Supression affectation
	// ---------------------------------

	public void deleteUnite(ActionEvent actionEvent) {
		gestionUniteLocal.delete(unite);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Delete with success !!! "));
	}

	public void reset() {
		setLibelleUnite(null);
		setDescription(null);
	}

	public List<String> getNomUnite() {
		return nomUnite;
	}

	public void setNomUnite(List<String> nomUnite) {
		this.nomUnite = nomUnite;
	}

	public String getNomUnit() {
		return nomUnit;
	}

	public void setNomUnit(String nomUnit) {
		this.nomUnit = nomUnit;
	}

	

}
