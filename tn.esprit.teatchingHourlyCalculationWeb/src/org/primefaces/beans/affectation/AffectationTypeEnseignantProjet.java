package org.primefaces.beans.affectation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.esprit.domain.gestionEntites.calculChargeHoraire.GestionChargeHoraireProjetLocal;
import com.esprit.entity.Enseignant;
import com.esprit.entity.Projet;
import com.esprit.entity.TypeProjet;
import com.esprit.entity.TypeProjetProjetEnseignant;
import com.esprit.service.affectationTypeProjetEnseignant.AffectationTypeProjetEnseignantLocal;
import com.esprit.service.gestionEnseignant.GestionEnseignantLocal;
import com.esprit.service.gestionProjet.GestionProjetLocal;
import com.esprit.service.gestionTypeProjet.GestionTypeProjetLocal;

@ManagedBean
@SessionScoped
public class AffectationTypeEnseignantProjet {
	@EJB
	GestionTypeProjetLocal gestionTypeProjetLocal;
	@EJB
	GestionEnseignantLocal gestionEnseignantLocal;
	@EJB
	GestionProjetLocal gestionProjetLocal;
	@EJB
	AffectationTypeProjetEnseignantLocal affectationTypeProjetEnseignantLocal;
	@EJB
	private GestionChargeHoraireProjetLocal gestionChargeHoraireProjetLocal;

	private Integer hour;
	private int semester;
	private int periode;
	private Date dateAffectation;
	private boolean statut;

	private List<SelectItem> itemsEnseignants;
	private String selectedEnseignantId;

	private List<SelectItem> itemsTypes;
	private int idSelectedType;

	private List<SelectItem> itemsProjets;
	private int selectedProjetId;

	private Enseignant enseignant = new Enseignant();
	private List<Enseignant> enseignants = new ArrayList<Enseignant>();

	private List<TypeProjet> typeProjets = new ArrayList<TypeProjet>();
	private TypeProjet typeProjet = new TypeProjet();

	private Projet projet = new Projet();
	private List<Projet> projets = new ArrayList<Projet>();

	private int chargeHoraireParEnseignant;

	// ************************ affichage par enseignant ********************
	private List<TypeProjetProjetEnseignant> listeParEnseignants;
	private String nomEnseignantSelected;
	private String nameEnseignant;

	// ************************* affichage par promotion *********************
	private List<TypeProjetProjetEnseignant> listeParProjets;
	private int idProjet;
	private String labelProjetSelected;

	// ************************ affichage par unite **************************
	private List<TypeProjetProjetEnseignant> listeParTypes;
	private int idType;
	private String nomTypeSelected;

	public String doAdd() {

		TypeProjet typeTMP = gestionTypeProjetLocal.findById(idSelectedType);
		Enseignant enseignantTMP = gestionEnseignantLocal
				.findByMat(selectedEnseignantId);
		Projet projetTMP = gestionProjetLocal.findById(selectedProjetId);
		System.out.println("good luck ramla ...");
		affectationTypeProjetEnseignantLocal.createAffectationETPP(
				enseignantTMP, typeTMP, projetTMP, semester, hour, statut,
				periode);

		nameEnseignant = enseignantTMP.getNom();

		return "";
	}

	public String doCalculChargeHoraire() {
		int chargeHoraireParEnseignant = gestionEnseignantLocal
				.volumeHoraireTotalParEnseignant(nameEnseignant);
		System.out.println(chargeHoraireParEnseignant);
		return "";
	}

	// ************ affichage par enseignant *************************

	public String updateDataTable() {
		nomEnseignantSelected = gestionEnseignantLocal
				.findByMat(nameEnseignant).getNom();
		listeParEnseignants = affectationTypeProjetEnseignantLocal
				.findAllByNomEnseignant(nomEnseignantSelected);
		return "";
	}

	// ******************** affichage par projet ********************
	public String updateDataTableProjet() {
		labelProjetSelected = gestionProjetLocal.findById(idProjet)
				.getLibelleProjet();
		listeParProjets = affectationTypeProjetEnseignantLocal
				.findAllByNomProjet(labelProjetSelected);
		return "";
	}

	// ********************* affichage par type ***********************
	public String updateDataTableType() {
		// System.out.println("bonjour....");
		nomTypeSelected = gestionTypeProjetLocal.findById(idType)
				.getLibelleType();
		// System.out.println(nomUniteSelected);
		listeParTypes = affectationTypeProjetEnseignantLocal
				.findAllByNomType(nomTypeSelected);
		// System.out.println(listeParUnite.size());

		return "";
	}

	public GestionEnseignantLocal getGestionEnseignantLocal() {
		return gestionEnseignantLocal;
	}

	public void setGestionEnseignantLocal(
			GestionEnseignantLocal gestionEnseignantLocal) {
		this.gestionEnseignantLocal = gestionEnseignantLocal;
	}

	public List<SelectItem> getItemsEnseignants() {
		itemsEnseignants = new ArrayList<SelectItem>();
		enseignants = gestionEnseignantLocal.findAll();
		itemsEnseignants.add(new SelectItem(-1, "select one..."));
		for (Enseignant s : enseignants)
			itemsEnseignants.add(new SelectItem(s.getMatriculeEnseigant(), s
					.getNom()));
		return itemsEnseignants;
	}

	public void setItemsEnseignants(List<SelectItem> itemsEnseignants) {
		this.itemsEnseignants = itemsEnseignants;
	}

	public List<SelectItem> getItemsTypes() {
		itemsTypes = new ArrayList<SelectItem>();
		typeProjets = gestionTypeProjetLocal.findAll();
		itemsTypes.add(new SelectItem(-1, "select one..."));
		for (TypeProjet s : typeProjets)
			itemsTypes.add(new SelectItem(s.getIdType(), s.getLibelleType()));
		return itemsTypes;
	}

	public void setItemsTypes(List<SelectItem> itemsTypes) {
		this.itemsTypes = itemsTypes;
	}

	public List<SelectItem> getItemsProjets() {
		itemsProjets = new ArrayList<SelectItem>();
		projets = gestionProjetLocal.findAll();
		itemsProjets.add(new SelectItem(-1, "select one..."));
		for (Projet s : projets)
			itemsProjets.add(new SelectItem(s.getRefProjet(), s
					.getLibelleProjet()));
		return itemsProjets;
	}

	public void setItemsProjets(List<SelectItem> itemsProjets) {
		this.itemsProjets = itemsProjets;
	}

	public String getSelectedEnseignantId() {
		return selectedEnseignantId;
	}

	public void setSelectedEnseignantId(String selectedEnseignantId) {
		this.selectedEnseignantId = selectedEnseignantId;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public List<Enseignant> getEnseignants() {
		enseignants = gestionEnseignantLocal.findAll();
		return enseignants;
	}

	public void setEnseignants(List<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	public List<TypeProjet> getTypeProjets() {
		typeProjets = gestionTypeProjetLocal.findAll();
		return typeProjets;
	}

	public void setTypeProjets(List<TypeProjet> typeProjets) {
		this.typeProjets = typeProjets;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public List<Projet> getProjets() {
		projets = gestionProjetLocal.findAll();

		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	public String getNameEnseignant() {
		return nameEnseignant;
	}

	public void setNameEnseignant(String nameEnseignant) {
		this.nameEnseignant = nameEnseignant;
	}

	// *********** affichage par enseignant ***********

	public List<TypeProjetProjetEnseignant> getListeParEnseignants() {
		return listeParEnseignants;
	}

	public void setListeParEnseignants(
			List<TypeProjetProjetEnseignant> listeParEnseignants) {
		this.listeParEnseignants = listeParEnseignants;
	}

	public List<TypeProjetProjetEnseignant> getListeParProjets() {
		return listeParProjets;
	}

	public void setListeParProjets(
			List<TypeProjetProjetEnseignant> listeParProjets) {
		this.listeParProjets = listeParProjets;
	}

	public List<TypeProjetProjetEnseignant> getListeParType() {
		return listeParTypes;
	}

	public void setListeParType(List<TypeProjetProjetEnseignant> listeParTypes) {
		this.listeParTypes = listeParTypes;
	}

	public String getNomEnseignantSelected() {
		return nomEnseignantSelected;
	}

	public void setNomEnseignantSelected(String nomEnseignantSelected) {
		this.nomEnseignantSelected = nomEnseignantSelected;
	}

	public GestionTypeProjetLocal getGestionTypeProjetLocal() {
		return gestionTypeProjetLocal;
	}

	public void setGestionTypeProjetLocal(
			GestionTypeProjetLocal gestionTypeProjetLocal) {
		this.gestionTypeProjetLocal = gestionTypeProjetLocal;
	}

	public GestionProjetLocal getGestionProjetLocal() {
		return gestionProjetLocal;
	}

	public void setGestionProjetLocal(GestionProjetLocal gestionProjetLocal) {
		this.gestionProjetLocal = gestionProjetLocal;
	}

	public AffectationTypeProjetEnseignantLocal getAffectationTypeProjetEnseignantLocal() {
		return affectationTypeProjetEnseignantLocal;
	}

	public void setAffectationTypeProjetEnseignantLocal(
			AffectationTypeProjetEnseignantLocal affectationTypeProjetEnseignantLocal) {
		this.affectationTypeProjetEnseignantLocal = affectationTypeProjetEnseignantLocal;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getPeriode() {
		return periode;
	}

	public void setPeriode(int periode) {
		this.periode = periode;
	}

	public Date getDateAffectation() {
		return dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public int getIdSelectedType() {
		return idSelectedType;
	}

	public void setIdSelectedType(int idSelectedType) {
		this.idSelectedType = idSelectedType;
	}

	public int getSelectedProjetId() {
		return selectedProjetId;
	}

	public void setSelectedProjetId(int selectedProjetId) {
		this.selectedProjetId = selectedProjetId;
	}

	public TypeProjet getTypeProjet() {
		return typeProjet;
	}

	public void setTypeProjet(TypeProjet typeProjet) {
		this.typeProjet = typeProjet;
	}

	public int getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}

	public String getLabelProjetSelected() {
		return labelProjetSelected;
	}

	public void setLabelProjetSelected(String labelProjetSelected) {
		this.labelProjetSelected = labelProjetSelected;
	}

	public List<TypeProjetProjetEnseignant> getListeParTypes() {
		return listeParTypes;
	}

	public void setListeParTypes(List<TypeProjetProjetEnseignant> listeParTypes) {
		this.listeParTypes = listeParTypes;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getNomTypeSelected() {
		return nomTypeSelected;
	}

	public void setNomTypeSelected(String nomTypeSelected) {
		this.nomTypeSelected = nomTypeSelected;
	}

	public int getChargeHoraireParEnseignant() {
		int chargeHoraireParEnseignant = gestionEnseignantLocal
				.volumeHoraireTotalParEnseignant(nameEnseignant);
		return chargeHoraireParEnseignant;
	}

	public void setChargeHoraireParEnseignant(int chargeHoraireParEnseignant) {
		this.chargeHoraireParEnseignant = chargeHoraireParEnseignant;
	}
}
