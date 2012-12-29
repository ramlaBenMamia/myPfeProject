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
 * Entity implementation class for Entity: Unite
 * 
 */
@Entity
public class Unite implements Serializable {

	private int RefUnite;
	private String NomUnite;
	private String nomChefProjet;
	private String description;
	private Locale locale;
	
	private List<UniteEnseignantPromotion> uniteEnseignantPromotions;

	private List<Enseignant> enseignants;

	private Enseignant enseignant;

	private static final long serialVersionUID = 1L;

	public Unite() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getRefUnite() {
		return this.RefUnite;
	}

	public void setRefUnite(int RefUnite) {
		this.RefUnite = RefUnite;
	}

	public String getNomUnite() {
		return this.NomUnite;
	}

	public void setNomUnite(String NomUnite) {
		this.NomUnite = NomUnite;
	}

	@ManyToOne
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@OneToMany(mappedBy = "unite", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(List<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNomChefProjet() {
		return nomChefProjet;
	}

	public void setNomChefProjet(String nomChefProjet) {
		this.nomChefProjet = nomChefProjet;
	}

	public Unite(int refUnite, String nomUnite, ChefProjet chefProjet,
			String nomChefProjet, String description, Locale locale,
			List<Enseignant> enseignants) {
		super();
		RefUnite = refUnite;
		NomUnite = nomUnite;

		this.nomChefProjet = nomChefProjet;
		this.description = description;
		this.locale = locale;
		this.enseignants = enseignants;
	}

	

	@ManyToOne
	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	@OneToMany(mappedBy = "unite", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<UniteEnseignantPromotion> getUniteEnseignantPromotions() {
		return uniteEnseignantPromotions;
	}

	public void setUniteEnseignantPromotions(
			List<UniteEnseignantPromotion> uniteEnseignantPromotions) {
		this.uniteEnseignantPromotions = uniteEnseignantPromotions;
	}

	
}
