package com.esprit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Entity implementation class for Entity: Promotion
 * 
 */
@Entity
public class Promotion implements Serializable {

	private int idPromotion;
	private String promotion;
	
	private Unite unite;
	private List<Unite> unites;
	private Activite activite;
	private List<Activite> activites;
	private List<UniteEnseignantPromotion> uniteEnseignantPromotions;
	private List<ChargeHoraireActivite> chargeHoraireActivites;
	private List<ChargeHoraireProjet> chargeHoraireProjets;
	
	private static final long serialVersionUID = 1L;

	public Promotion() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdPromotion() {
		return this.idPromotion;
	}

	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	@OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<ChargeHoraireActivite> getChargeHoraireActivites() {
		return chargeHoraireActivites;
	}

	public void setChargeHoraireActivites(
			List<ChargeHoraireActivite> chargeHoraireActivites) {
		this.chargeHoraireActivites = chargeHoraireActivites;
	}

	@OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<ChargeHoraireProjet> getChargeHoraireProjets() {
		return chargeHoraireProjets;
	}

	public void setChargeHoraireProjets(
			List<ChargeHoraireProjet> chargeHoraireProjets) {
		this.chargeHoraireProjets = chargeHoraireProjets;
	}

	@OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<UniteEnseignantPromotion> getUniteEnseignantPromotions() {
		return uniteEnseignantPromotions;
	}

	public void setUniteEnseignantPromotions(
			List<UniteEnseignantPromotion> uniteEnseignantPromotions) {
		this.uniteEnseignantPromotions = uniteEnseignantPromotions;
	}

	@ManyToOne
	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	@OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Unite> getUnites() {
		return unites;
	}

	public void setUnites(List<Unite> unites) {
		this.unites = unites;
	}

	
	
	//**************** affichage par activite ************************
	

	@ManyToOne
	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	@OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Activite> getActivites() {
		return activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}
	
	

}
