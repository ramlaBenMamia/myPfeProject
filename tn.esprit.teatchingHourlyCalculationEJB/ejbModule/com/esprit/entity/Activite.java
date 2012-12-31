package com.esprit.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Entity implementation class for Entity: Activite
 * 
 */
@Entity
public class Activite implements Serializable {

	private int refActivite;

	// ***************** siminaire , club , conference ,
	private String libelleActivite;

	// *********** theme
	private String description;
	private Date dateDebut1;
	private Date dateDebut2;
	private Date dateDebut3;

	private Date dateFin;
	private String local;
	private boolean typeActivite1;
	private boolean typeActivite2;
	private boolean typeActivite3;

	private List<ActiviteEnseignant> activiteEnseignants;

	private List<Promotion> promotions;
	private Promotion promotion;

	private Locale locale;

	// ************** affichage des enseignants par activite**************
	private List<Enseignant> enseignants;
	private Enseignant enseignant;

	private static final long serialVersionUID = 1L;

	public Activite() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getRefActivite() {
		return refActivite;
	}

	public void setRefActivite(int refActivite) {
		this.refActivite = refActivite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@OneToMany(mappedBy = "activite", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<ActiviteEnseignant> getActiviteEnseignants() {
		return activiteEnseignants;
	}

	public void setActiviteEnseignants(
			List<ActiviteEnseignant> activiteEnseignants) {
		this.activiteEnseignants = activiteEnseignants;
	}

	public String getLibelleActivite() {
		return libelleActivite;
	}

	public void setLibelleActivite(String libelleActivite) {
		this.libelleActivite = libelleActivite;
	}

	@OneToMany(mappedBy = "activite", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(List<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	@ManyToOne
	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	// ****************** affichage par activite ************************

	@OneToMany(mappedBy = "activite", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	@ManyToOne
	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	// *** local

	@ManyToOne
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public boolean getTypeActivite1() {
		return typeActivite1;
	}

	public void setTypeActivite1(boolean typeActivite1) {
		this.typeActivite1 = typeActivite1;
	}

	public boolean isTypeActivite2() {
		return typeActivite2;
	}

	public void setTypeActivite2(boolean typeActivite2) {
		this.typeActivite2 = typeActivite2;
	}

	public boolean isTypeActivite3() {
		return typeActivite3;
	}

	public void setTypeActivite3(boolean typeActivite3) {
		this.typeActivite3 = typeActivite3;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateDebut1() {
		return dateDebut1;
	}

	public void setDateDebut1(Date dateDebut1) {
		this.dateDebut1 = dateDebut1;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateDebut2() {
		return dateDebut2;
	}

	public void setDateDebut2(Date dateDebut2) {
		this.dateDebut2 = dateDebut2;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateDebut3() {
		return dateDebut3;
	}

	public void setDateDebut3(Date dateDebut3) {
		this.dateDebut3 = dateDebut3;
	}

}
