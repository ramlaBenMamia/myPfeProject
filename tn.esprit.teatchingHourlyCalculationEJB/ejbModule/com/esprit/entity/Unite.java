package com.esprit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

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
	private ChefProjet chefProjet;
	private String description;

	private List<Enseignant> enseignants;

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

	@OneToOne(cascade = CascadeType.PERSIST)
	public ChefProjet getChefProjet() {
		return chefProjet;
	}

	public void setChefProjet(ChefProjet chefProjet) {
		this.chefProjet = chefProjet;
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

}
