package org.primefaces.beans.gestionProjet;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import com.esprit.entity.Projet;
import com.esprit.service.gestionEnseignant.GestionEnseignantLocal;
import com.esprit.service.gestionProjet.GestionProjetLocal;

@ManagedBean
@SessionScoped
public class ProjetBean {
	@EJB
	GestionProjetLocal bean;

	List<Projet> projets;
	Projet projet;

	String label = "Choisir";

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setProjets(List<Projet> Projets) {
		this.projets = Projets;
	}

	public Projet getProjet() {
		if (projet == null) {
			projet = new Projet();
		}

		return projet;
	}

	public void setProjet(Projet Projet) {
		this.projet = Projet;
	}

	public List<Projet> getProjets() {
		return projets;
	}

	public String doAddProjet() {
		bean.save(projet);
		reset();
		return"";
	}
	
	public void reset(){
		Projet projet=new Projet();
		projet.setDescription("");
	}

	// *********************************** affectation
	// ***********************************

	private List<SelectItem> projetsElements;

	private String libelleProjet;

	private String description;

	private String etatProjet;

	private String nomEnseignant;

	private DataModel dataModel = new ListDataModel();

	@EJB
	private GestionProjetLocal gestionProjetLocal;
	@EJB
	private GestionEnseignantLocal gestionEnseignantLocal;

	public void init() {
		Projet projet = new Projet();

	}

	public List<SelectItem> getProjetsElements() {

		List<Projet> projets = gestionProjetLocal.findAll();

		// projetsElements=new ArrayList<SelectItem>(projets.size()+1);

		if (projetsElements == null) {
			projetsElements = new ArrayList<SelectItem>();
			for (Projet F : projets) {
				projetsElements.add(new SelectItem(F.getRefProjet(), F
						.getLibelleProjet()));
			}
		}

		return projetsElements;
	}

	public void setProjetsElements(List<SelectItem> projetsElements) {
		this.projetsElements = projetsElements;
	}

	public String getLibelleProjet() {
		return libelleProjet;
	}

	public void setLibelleProjet(String libelleProjet) {
		this.libelleProjet = libelleProjet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEtatProjet() {
		return etatProjet;
	}

	public void setEtatProjet(String etatProjet) {
		this.etatProjet = etatProjet;
	}

	public String getNomEnseignant() {
		return nomEnseignant;
	}

	public void setNomEnseignant(String nomEnseignant) {
		this.nomEnseignant = nomEnseignant;
	}

	public DataModel getDataModel() {
		dataModel.setWrappedData(gestionProjetLocal.findAll());

		return dataModel;
	}

	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	// -------------------------------Ajouter une nouvelle affectation
	// -------------------------------------

	public void add(ActionEvent actionEvent) {

		projet.setLibelleProjet(getLibelleProjet());
		projet.setDescription(getDescription());
		gestionProjetLocal.save(projet);

		FacesContext.getCurrentInstance()
				.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"add with success Projet : ", projet
										.getLibelleProjet()));

		reset();

	}

	// ------------------------------Mise a jour affectation
	// ---------------------------------
	public String update() {
		projet = (Projet) dataModel.getRowData();
		gestionProjetLocal.update(projet);
		return "updateProjet";
	}

	// -------------------------------Supression affectation
	// ---------------------------------
	public String delete() {
		projet = (Projet) dataModel.getRowData();
		gestionProjetLocal.deleteByRef(projet.getRefProjet());
		return "deleteProjet";

	}

	// -------------------------------Mise a jour affectation
	// --------------------------------
	public void updateProjet(ActionEvent actionEvent) {

		gestionProjetLocal.update(projet);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("update with success !!! "));

	}

	// -------------------------------Supression affectation
	// ---------------------------------

	public void deleteProjet(ActionEvent actionEvent) {
		gestionProjetLocal.delete(projet);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Delete with success !!! "));
	}

	

}
