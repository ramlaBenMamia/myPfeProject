package org.primefaces.beans.gestionProfs;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import com.esprit.entity.Enseignant;
import com.esprit.entity.Projet;
import com.esprit.service.gestionEnseignant.GestionEnseignantLocal;
import com.esprit.service.gestionProjet.GestionProjetLocal;

public class TeacherBean {
	@EJB
	GestionEnseignantLocal bean;

	@EJB
	GestionProjetLocal beanProjet;

	List<Enseignant> enseignants;
	Enseignant enseignant;
	String login;
	String password;
	String label = "Choisir";

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setEnseignants(List<Enseignant> Enseignants) {
		this.enseignants = Enseignants;
	}

	public Enseignant getEnseignant() {
		if (enseignant == null) {
			enseignant = new Enseignant();
		}

		return enseignant;
	}

	public void setEnseignant(Enseignant Enseignant) {
		this.enseignant = Enseignant;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String validate() throws Exception {
		try {
			@SuppressWarnings("unused")
			Enseignant user = bean.findByUser(getLogin(), getPassword());
		} catch (Exception e) {
			return "auth";
		}

		return "main";

	}

	public void doAddEnseignant() {

		bean.save(enseignant);
	}

	// public void addAffectationProjet() {
	// Projet p = beanProjet.findByLibelleProjet(label);
	// System.out.println(p);
	// enseignant.setProjet(p);
	//
	// bean.update(enseignant);
	// enseignant = new Enseignant();
	// label = "Choisir";
	//
	// }

	// ************************** ancien *************************************

	private String libelleProjet;

	private List<SelectItem> enseigantsElements;

	private String nomEnseignant;

	private DataModel dataModel = new ListDataModel();

	@EJB
	private GestionProjetLocal gestionProjetLocal;
	@EJB
	private GestionEnseignantLocal gestionEnseignantLocal;

	public void init() {
		Enseignant enseignant = new Enseignant();

	}

	public List<SelectItem> getEnseigantsElements() {

		List<Enseignant> enseignants = gestionEnseignantLocal.findAll();
		// enseigantsElements=new ArrayList<SelectItem>(enseignants.size()+1);

		if (enseigantsElements == null) {
			enseigantsElements = new ArrayList<SelectItem>();
			for (Enseignant F : enseignants) {
				enseigantsElements.add(new SelectItem(F.getMatriculeEnseigant(), F.getNom()));
			}
		}

		return enseigantsElements;
	}

	public void setEnseigantsElements(List<SelectItem> enseigantsElements) {
		this.enseigantsElements = enseigantsElements;
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

		List<Projet> listeProjets;
		listeProjets = gestionProjetLocal.findByLibelle(getLibelleProjet());
//		enseignant.setProjet(listeProjets.get(0));
		enseignant.setNom(getNomEnseignant());
		gestionEnseignantLocal.save(enseignant);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"add with success profile : ", enseignant.getNom()));
		reset();

	}

	// ------------------------------Mise a jour affectation
	// ---------------------------------
	public String update() {
		enseignant = (Enseignant) dataModel.getRowData();
		gestionEnseignantLocal.update(enseignant);
		return "updateEnseignant";
	}

	// -------------------------------Supression affectation
	// ---------------------------------
	public String delete() {
		enseignant = (Enseignant) dataModel.getRowData();
		gestionEnseignantLocal.deleteByMat(enseignant.getMatriculeEnseigant());
		return "deleteEnseignant";

	}

	// -------------------------------Mise a jour affectation
	// --------------------------------
	public void updateEnseignant(ActionEvent actionEvent) {

		gestionEnseignantLocal.update(enseignant);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("update with success !!! "));

	}

	// -------------------------------Supression affectation
	// ---------------------------------

	public void deleteEnseignant(ActionEvent actionEvent) {
		gestionEnseignantLocal.delete(enseignant);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Delete with success !!! "));
	}

	public void reset() {
		setNomEnseignant(null);
	}

	public String getLibelleProjet() {
		return libelleProjet;
	}

	public void setLibelleProjet(String libelleProjet) {
		this.libelleProjet = libelleProjet;
	}

}
