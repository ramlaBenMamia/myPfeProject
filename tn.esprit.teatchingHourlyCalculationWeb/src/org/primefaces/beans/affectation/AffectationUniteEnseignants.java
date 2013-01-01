package org.primefaces.beans.affectation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.esprit.entity.Enseignant;
import com.esprit.entity.Promotion;
import com.esprit.entity.Unite;
import com.esprit.entity.UniteEnseignantPromotion;
import com.esprit.service.affectationUniteEnseignantPromotion.AffectationUniteEnseignantPromotionLocal;
import com.esprit.service.gestionActivite.GestionActiviteLocal;
import com.esprit.service.gestionEnseignant.GestionEnseignantLocal;
import com.esprit.service.gestionProjet.GestionProjetLocal;
import com.esprit.service.gestionPromotion.GestionPromotionLocal;
import com.esprit.service.gestionTypeProjet.GestionTypeProjetLocal;
import com.esprit.service.gestionUnite.GestionUniteLocal;

@ManagedBean
@SessionScoped
public class AffectationUniteEnseignants {
	@EJB
	GestionUniteLocal gestionUniteLocal;
	@EJB
	GestionEnseignantLocal gestionEnseignantLocal;
	@EJB
	GestionPromotionLocal gestionPromotionLocal;
	@EJB
	AffectationUniteEnseignantPromotionLocal affectationUniteEnseignantPromotionLocal;
	@EJB
	GestionProjetLocal gestionProjetLocal;
	@EJB
	GestionTypeProjetLocal gestionTypeProjetLocal;
	@EJB
	GestionActiviteLocal gestionActiviteLocal;

	private List<SelectItem> itemsEnseignants;
	private String selectedEnseignantId;

	private List<SelectItem> itemsUnites;
	private int idSelectedUnite;

	private Date date;

	private List<SelectItem> itemsPromotions;
	private int selectedPromotionId;

	private Enseignant enseignant = new Enseignant();
	private List<Enseignant> enseignants = new ArrayList<Enseignant>();

	private List<Unite> unites = new ArrayList<Unite>();
	private Unite unite = new Unite();

	private String nomActivite;
	private int idActivite;
	private String nomProjet;
	private int idProjet;
	private String NomTypeProjet;
	private int idTypeProjet;

	private Promotion promotion = new Promotion();
	private List<Promotion> promotions = new ArrayList<Promotion>();

	// ************************ affichage par enseignant ********************
	private List<UniteEnseignantPromotion> listeParEnseignants;
	private String nomEnseignantSelected;
	private String nameEnseignant;

	// ************************* affichage par promotion *********************
	private List<UniteEnseignantPromotion> listeParPromotions;
	private int idPromotion;
	private String labelPromotionSelected;

	// ************************ affichage par unite **************************
	private List<UniteEnseignantPromotion> listeParUnite;
	private int idUnite;
	private String nomUniteSelected;

	public String doAdd() {

		Unite uniteTMP = gestionUniteLocal.findByRef(idSelectedUnite);
		Enseignant enseignantTMP = gestionEnseignantLocal
				.findByMat(selectedEnseignantId);
		Promotion promotionTMP = gestionPromotionLocal
				.findById(selectedPromotionId);
		System.out.println("good luck ramla ...");
		affectationUniteEnseignantPromotionLocal.createAffectationEPU(
				enseignantTMP, promotionTMP, uniteTMP, date);
		setNameEnseignant(enseignantTMP.getNom());
		nameEnseignant = enseignantTMP.getNom();

		return "";
	}

	// ************ affichage par enseignant *************************

	public String updateDataTable() {
		nomEnseignantSelected = gestionEnseignantLocal
				.findByMat(nameEnseignant).getNom();
		listeParEnseignants = affectationUniteEnseignantPromotionLocal
				.findAllByNomEnseignant(nomEnseignantSelected);
		return "";
	}

	// ******************** affichage par promotion ********************
	public String updateDataTablePromotion() {
		labelPromotionSelected = gestionPromotionLocal.findById(idPromotion)
				.getPromotion();
		listeParPromotions = affectationUniteEnseignantPromotionLocal
				.findAllByNomPromotion(labelPromotionSelected);
		return "";
	}

	// ********************* affichage par unite ***********************
	public String updateDataTableUnite() {
		System.out.println("bonjour....");
		nomUniteSelected = gestionUniteLocal.findByRef(idUnite).getNomUnite();
		System.out.println(nomUniteSelected);
		listeParUnite = affectationUniteEnseignantPromotionLocal
				.findAllByNomUnite(nomUniteSelected);
		System.out.println(listeParUnite.size());

		return "";
	}

	public GestionUniteLocal getGestionUniteLocal() {
		return gestionUniteLocal;
	}

	public void setGestionUniteLocal(GestionUniteLocal gestionUniteLocal) {
		this.gestionUniteLocal = gestionUniteLocal;
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

	public List<SelectItem> getItemsUnites() {
		itemsUnites = new ArrayList<SelectItem>();
		unites = gestionUniteLocal.findAll();
		itemsUnites.add(new SelectItem(-1, "select one..."));
		for (Unite s : unites)
			itemsUnites.add(new SelectItem(s.getRefUnite(), s.getNomUnite()));
		return itemsUnites;
	}

	public void setItemsUnites(List<SelectItem> itemsUnites) {
		this.itemsUnites = itemsUnites;
	}

	public List<SelectItem> getItemsPromotions() {
		itemsPromotions = new ArrayList<SelectItem>();
		promotions = gestionPromotionLocal.findAll();
		itemsPromotions.add(new SelectItem(-1, "select one..."));
		for (Promotion s : promotions)
			itemsPromotions.add(new SelectItem(s.getIdPromotion(), s
					.getPromotion()));
		return itemsPromotions;
	}

	public void setItemsPromotions(List<SelectItem> itemsPromotions) {
		this.itemsPromotions = itemsPromotions;
	}

	public int getSelectedPromotionId() {
		return selectedPromotionId;
	}

	public void setSelectedPromotionId(int selectedPromotionId) {
		this.selectedPromotionId = selectedPromotionId;
	}

	public int getIdSelectedUnite() {
		return idSelectedUnite;
	}

	public void setIdSelectedUnite(int idSelectedUnite) {
		this.idSelectedUnite = idSelectedUnite;
	}

	public String getSelectedEnseignantId() {
		return selectedEnseignantId;
	}

	public void setSelectedEnseignantId(String selectedEnseignantId) {
		this.selectedEnseignantId = selectedEnseignantId;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
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

	public List<Unite> getUnites() {
		unites = gestionUniteLocal.findAll();
		return unites;
	}

	public void setUnites(List<Unite> unites) {
		this.unites = unites;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public List<Promotion> getPromotions() {
		promotions = gestionPromotionLocal.findAll();

		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	public String getNameEnseignant() {
		return nameEnseignant;
	}

	public void setNameEnseignant(String nameEnseignant) {
		this.nameEnseignant = nameEnseignant;
	}

	public GestionPromotionLocal getGestionPromotionLocal() {
		return gestionPromotionLocal;
	}

	public void setGestionPromotionLocal(
			GestionPromotionLocal gestionPromotionLocal) {
		this.gestionPromotionLocal = gestionPromotionLocal;
	}

	// *********** affichage par enseignant ***********

	public List<UniteEnseignantPromotion> getListeParEnseignants() {
		return listeParEnseignants;
	}

	public void setListeParEnseignants(
			List<UniteEnseignantPromotion> listeParEnseignants) {
		this.listeParEnseignants = listeParEnseignants;
	}

	public List<UniteEnseignantPromotion> getListeParPromotions() {
		return listeParPromotions;
	}

	public void setListeParPromotions(
			List<UniteEnseignantPromotion> listeParPromotions) {
		this.listeParPromotions = listeParPromotions;
	}

	public List<UniteEnseignantPromotion> getListeParUnite() {
		return listeParUnite;
	}

	public void setListeParUnite(List<UniteEnseignantPromotion> listeParUnite) {
		this.listeParUnite = listeParUnite;
	}

	public String getNomEnseignantSelected() {
		return nomEnseignantSelected;
	}

	public void setNomEnseignantSelected(String nomEnseignantSelected) {
		this.nomEnseignantSelected = nomEnseignantSelected;
	}

	public String getLabelPromotionSelected() {
		return labelPromotionSelected;
	}

	public void setLabelPromotionSelected(String labelPromotionSelected) {
		this.labelPromotionSelected = labelPromotionSelected;
	}

	public String getNomUniteSelected() {
		return nomUniteSelected;
	}

	public void setNomUniteSelected(String nomUniteSelected) {
		this.nomUniteSelected = nomUniteSelected;
	}

	public int getIdPromotion() {
		return idPromotion;
	}

	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}

	public int getIdUnite() {
		return idUnite;
	}

	public void setIdUnite(int idUnite) {
		this.idUnite = idUnite;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNomActivite() {
		nomActivite = gestionActiviteLocal
				.findByRef(idActivite).getLibelleActivite();
		return nomActivite;
	}

	public void setNomActivite(String nomActivite) {
		this.nomActivite = nomActivite;
	}

	public int getIdActivite() {
		return idActivite;
	}

	public void setIdActivite(int idActivite) {
		this.idActivite = idActivite;
	}

	public String getNomProjet() {
		nomProjet = gestionProjetLocal
				.findByRef(idProjet).getLibelleProjet();
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public int getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}

	public String getNomTypeProjet() {
		NomTypeProjet = gestionTypeProjetLocal
				.findById(idTypeProjet).getLibelleType();
		return NomTypeProjet;
	}

	public void setNomTypeProjet(String nomTypeProjet) {
		NomTypeProjet = nomTypeProjet;
	}

	public int getIdTypeProjet() {
		return idTypeProjet;
	}

	public void setIdTypeProjet(int idTypeProjet) {
		this.idTypeProjet = idTypeProjet;
	}

	
}
