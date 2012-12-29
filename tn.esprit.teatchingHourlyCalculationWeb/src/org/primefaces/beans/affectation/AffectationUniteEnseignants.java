package org.primefaces.beans.affectation;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.esprit.entity.Enseignant;
import com.esprit.entity.Projet;
import com.esprit.entity.Promotion;
import com.esprit.entity.Unite;
import com.esprit.service.affectationUniteEnseignantPromotion.AffectationUniteEnseignantPromotionLocal;
import com.esprit.service.gestionEnseignant.GestionEnseignantLocal;
import com.esprit.service.gestionPromotion.GestionPromotionLocal;
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

	private List<SelectItem> itemsEnseignants;
	private String selectedEnseignantId;

	private List<SelectItem> itemsUnites;
	private int idSelectedUnite;

	private List<SelectItem> itemsPromotions;
	private int selectedPromotionId;

	private Enseignant enseignant = new Enseignant();
	private List<Enseignant> enseignants = new ArrayList<Enseignant>();

	private List<Unite> unites = new ArrayList<Unite>();
	private Unite unite = new Unite();

	private Promotion promotion = new Promotion();
	private List<Promotion> promotions = new ArrayList<Promotion>();
	private String nameEnseignant;

	public String doAdd() {
		
		Unite uniteTMP = gestionUniteLocal.findByRef(idSelectedUnite);
		Enseignant enseignantTMP = gestionEnseignantLocal
				.findByMat(selectedEnseignantId);
		Promotion promotionTMP=gestionPromotionLocal.findById(selectedPromotionId);
		System.out.println("good luck ramla ...");
		affectationUniteEnseignantPromotionLocal.createAffectationEPU(enseignantTMP, promotionTMP, uniteTMP);
		setNameEnseignant(enseignantTMP.getNom());

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

}
