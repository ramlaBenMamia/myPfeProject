package com.esprit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Promotion
 *
 */
@Entity

public class Promotion implements Serializable {

	   

	private int idPromotion;
	private String promotion;
	private static final long serialVersionUID = 1L;
    private List<Semestre> semestres;
    
    private List<ChargeHoraireActivite> chargeHoraireActivites;
	private List<ChargeHoraireEncadrement> chargeHoraireEncadrements;
    private List<ChargeHoraireProjet> chargeHoraireProjets;
    
    
    
    
//    private List<ChargeEnseignement> chargeEnseignements ;
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
   
	
	public void setSemestres(List<Semestre> semestres) {
		this.semestres = semestres;
	}
	@OneToMany(mappedBy="promotion",cascade=CascadeType.ALL)
	public List<Semestre> getSemestres() {
		return semestres;
	
	}
//	@OneToMany(mappedBy="promotion",cascade=CascadeType.ALL)
//	public List<ChargeEnseignement> getChargeEnseignements() {
//	return chargeEnseignements;
//	}
//	public void setChargeEnseignements(List<ChargeEnseignement> chargeEnseignements) {
//		this.chargeEnseignements = chargeEnseignements;
//	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	
	
	
	
	@OneToMany(mappedBy = "promotion")
	public List<ChargeHoraireActivite> getChargeHoraireActivites() {
		return chargeHoraireActivites;
	}

	public void setChargeHoraireActivites(
			List<ChargeHoraireActivite> chargeHoraireActivites) {
		this.chargeHoraireActivites = chargeHoraireActivites;
	}

	@OneToMany(mappedBy = "promotion")
	public List<ChargeHoraireEncadrement> getChargeHoraireEncadrements() {
		return chargeHoraireEncadrements;
	}

	public void setChargeHoraireEncadrements(
			List<ChargeHoraireEncadrement> chargeHoraireEncadrements) {
		this.chargeHoraireEncadrements = chargeHoraireEncadrements;
	}

	@OneToMany(mappedBy = "promotion")
	public List<ChargeHoraireProjet> getChargeHoraireProjets() {
		return chargeHoraireProjets;
	}

	public void setChargeHoraireProjets(
			List<ChargeHoraireProjet> chargeHoraireProjets) {
		this.chargeHoraireProjets = chargeHoraireProjets;
	}

	
	
}

