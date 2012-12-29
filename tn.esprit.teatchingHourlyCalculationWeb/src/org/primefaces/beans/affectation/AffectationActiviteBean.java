package org.primefaces.beans.affectation;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.esprit.domain.gestionEntites.calculChargeHoraire.GestionChargeHoraireActiviteLocal;
import com.esprit.domain.gestionEntites.calculChargeHoraire.GestionChargeHoraireProjetLocal;
import com.esprit.entity.Activite;
import com.esprit.entity.ActiviteEnseignant;
import com.esprit.entity.Enseignant;
import com.esprit.entity.Projet;
import com.esprit.entity.ProjetEnseignant;
import com.esprit.entity.Promotion;
import com.esprit.service.gestionActivite.GestionActiviteLocal;
import com.esprit.service.gestionAffectationActivite.GestionAffectationActiviteEnseignantLocal;
import com.esprit.service.gestionAffectationProjet.GestionAffectationProjetEnseignantLocal;
import com.esprit.service.gestionEnseignant.GestionEnseignantLocal;
import com.esprit.service.gestionProjet.GestionProjetLocal;
import com.esprit.service.gestionPromotion.GestionPromotionLocal;

@ManagedBean
@SessionScoped
public class AffectationActiviteBean {
	private List<Activite> activites = new ArrayList<Activite>();
	private List<Enseignant> enseignants = new ArrayList<Enseignant>();
	private int hour;
	private int semester;
	private int periode;
	private String nameEnseignant;
	private String nomEnseignantSelect;

	private List<SelectItem> selectItemsActivites;
	private int idSelectedActivite;

	private List<SelectItem> selectItemsEnseignant;
	private String matSelectedEnseignant;
	private int chargeHoraireParEnseignant;

	private List<SelectItem> itemsPromotions;
	private int selectedPromotionId;
	private Promotion promotion = new Promotion();
	private List<Promotion> promotions = new ArrayList<Promotion>();

	// ************************ affichage par enseignant ********************
	private List<ActiviteEnseignant> listeParEnseignantActivites;

	// injection of the proxy
	@EJB
	private GestionEnseignantLocal gestionEnseignantLocal;
	@EJB
	private GestionActiviteLocal gestionActiviteLocal;
	@EJB
	private GestionAffectationActiviteEnseignantLocal gestionAffectationActiviteEnseignantLocal;
	@EJB
	private GestionChargeHoraireProjetLocal gestionChargeHoraireProjetLocal;
	@EJB
	private GestionPromotionLocal gestionPromotionLocal;

	public String doAdd() {
		Activite activiteTMP = gestionActiviteLocal
				.findByRef(idSelectedActivite);
		Enseignant enseignantTMP = gestionEnseignantLocal
				.findByMat(matSelectedEnseignant);
		System.out.println("good luck ramla ...");
		gestionAffectationActiviteEnseignantLocal.createAffectationActivite(
				semester, periode, hour, enseignantTMP, activiteTMP);
		nameEnseignant = enseignantTMP.getNom();

		return "ok";
	}

	public String updateDataTable() {
		nomEnseignantSelect = gestionEnseignantLocal.findByMat(nameEnseignant)
				.getNom();
		listeParEnseignantActivites = gestionAffectationActiviteEnseignantLocal
				.findAllByNomEnsei(nomEnseignantSelect);

		return "";
	}

	public String doCalculChargeHoraire() {
		int chargeHoraireParEnseignantActivite = gestionEnseignantLocal
				.volumeHoraireTotalParEnseignantActivite(nameEnseignant);
		System.out.println(chargeHoraireParEnseignantActivite);
		return "";
	}

	public String TotalChargeHoraire() {

		return "";
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

	public List<Activite> getActivites() {

		return gestionActiviteLocal.findAll();
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}

	public List<Enseignant> getEnseignants() {
		return gestionEnseignantLocal.findAll();
	}

	public void setEnseignants(List<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	public List<SelectItem> getSelectItemsActivites() {
		selectItemsActivites = new ArrayList<SelectItem>();
		activites = gestionActiviteLocal.findAll();
		selectItemsActivites.add(new SelectItem(-1, "please select one ..."));
		for (Activite p : activites) {
			selectItemsActivites.add(new SelectItem(p.getRefActivite(), p
					.getLibelleActivite()));
		}

		return selectItemsActivites;
	}

	public void setSelectItemsActivites(List<SelectItem> selectItemsActivites) {
		this.selectItemsActivites = selectItemsActivites;
	}

	public int getIdSelectedActivite() {
		return idSelectedActivite;
	}

	public void setIdSelectedActivite(int idSelectedActivite) {
		this.idSelectedActivite = idSelectedActivite;
	}

	public List<SelectItem> getSelectItemsEnseignant() {
		selectItemsEnseignant = new ArrayList<SelectItem>();
		enseignants = gestionEnseignantLocal.findAll();
		selectItemsEnseignant.add(new SelectItem(-1, "please select one.."));
		for (Enseignant e : enseignants) {
			selectItemsEnseignant.add(new SelectItem(e.getMatriculeEnseigant(),
					e.getNom()));
		}
		return selectItemsEnseignant;
	}

	public void setSelectItemsEnseignant(List<SelectItem> selectItemsEnseignant) {
		this.selectItemsEnseignant = selectItemsEnseignant;
	}

	public String getMatSelectedEnseignant() {

		return matSelectedEnseignant;
	}

	public void setMatSelectedEnseignant(String matSelectedEnseignant) {
		this.matSelectedEnseignant = matSelectedEnseignant;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getNameEnseignant() {
		return nameEnseignant;
	}

	public void setNameEnseignant(String nameEnseignant) {
		this.nameEnseignant = nameEnseignant;
	}

	// ************* affichage par enseignant************
	public List<ActiviteEnseignant> getListeParEnseignantActivites() {

		return listeParEnseignantActivites;
	}

	public void setListeParEnseignantActivites(
			List<ActiviteEnseignant> listeParEnseignantActivites) {
		this.listeParEnseignantActivites = listeParEnseignantActivites;
	}

	public void recupererdataModelActivite() {
		List<Enseignant> listEnseignants;
		listEnseignants = gestionEnseignantLocal.findByNom(getNameEnseignant());

		String matriculeEnseigant = listEnseignants.get(0)
				.getMatriculeEnseigant();

		List<Activite> activites = gestionActiviteLocal
				.findByMatEnseignant(matriculeEnseigant);

		if (selectItemsActivites == null) {
			selectItemsActivites = new ArrayList<SelectItem>();
		} else
			selectItemsActivites.clear();
		for (Activite c : activites) {
			selectItemsActivites.add(new SelectItem(c.getLibelleActivite()));
		}

	}

	public String getNomEnseignantSelect() {
		return nomEnseignantSelect;
	}

	public void setNomEnseignantSelect(String nomEnseignantSelect) {
		this.nomEnseignantSelect = nomEnseignantSelect;
	}

	public int getChargeHoraireParEnseignant() {
		int chargeHoraireParEnseignant = gestionEnseignantLocal
				.volumeHoraireTotalParEnseignantActivite(nameEnseignant);
		return chargeHoraireParEnseignant;
	}

	public void setChargeHoraireParEnseignant(int chargeHoraireParEnseignant) {
		this.chargeHoraireParEnseignant = chargeHoraireParEnseignant;
	}

	public int getSelectedPromotionId() {
		return selectedPromotionId;
	}

	public void setSelectedPromotionId(int selectedPromotionId) {
		this.selectedPromotionId = selectedPromotionId;
	}

	public int getPeriode() {
		return periode;
	}

	public void setPeriode(int periode) {
		this.periode = periode;
	}

}
