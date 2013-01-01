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
	private Date dateSiminaire;
	private Date dateClub;
	private Date dateConference;

	private Date dateFin;
	private String local;
	private boolean siminaire;
	private boolean conference;
	private boolean club;

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

	//
	@Temporal(TemporalType.DATE)
	public Date getDateSiminaire() {
		return dateSiminaire;
	}

	public void setDateSiminaire(Date dateSiminaire) {
		this.dateSiminaire = dateSiminaire;
	}
	@Temporal(TemporalType.DATE)
	public Date getDateClub() {
		return dateClub;
	}

	public void setDateClub(Date dateClub) {
		this.dateClub = dateClub;
	}
	@Temporal(TemporalType.DATE)
	public Date getDateConference() {
		return dateConference;
	}

	public void setDateConference(Date dateConference) {
		this.dateConference = dateConference;
	}

	public boolean isSiminaire() {
		return siminaire;
	}

	public void setSiminaire(boolean siminaire) {
		this.siminaire = siminaire;
	}

	public boolean isConference() {
		return conference;
	}

	public void setConference(boolean conference) {
		this.conference = conference;
	}

	public boolean isClub() {
		return club;
	}

	public void setClub(boolean club) {
		this.club = club;
	}

	
}
