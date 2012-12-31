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

//import org.hibernate.annotations.LazyCollection;
//import org.hibernate.annotations.LazyCollectionOption;

/**
 * Entity implementation class for Entity: Projet
 * 
 */
@Entity
public class Projet implements Serializable {

	private int refProjet;
	private String libelleProjet;
	private String description;
	private List<ProjetEnseignant> projetEnseignants;
	
	private List<Enseignant> enseignants;
	private Enseignant enseignant;

	private List<TypeProjet> typeProjets;
	private TypeProjet typeProjet;
	private List<TypeProjetProjetEnseignant> typeProjetProjetEnseignants;
	
	private static final long serialVersionUID = 1L;

	public Projet() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getRefProjet() {
		return refProjet;
	}

	public void setRefProjet(int refProjet) {
		this.refProjet = refProjet;
	}

	public String getLibelleProjet() {
		return libelleProjet;
	}

	public void setLibelleProjet(String libelleProjet) {
		this.libelleProjet = libelleProjet;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<ProjetEnseignant> getProjetEnseignants() {
		return projetEnseignants;
	}

	public void setProjetEnseignants(List<ProjetEnseignant> projetEnseignants) {
		this.projetEnseignants = projetEnseignants;
	}

	
	//********************* affichage par projet ******************
	
	@OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
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

	@OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<TypeProjet> getTypeProjets() {
		return typeProjets;
	}

	public void setTypeProjets(List<TypeProjet> typeProjets) {
		this.typeProjets = typeProjets;
	}

	@ManyToOne
	public TypeProjet getTypeProjet() {
		return typeProjet;
	}

	public void setTypeProjet(TypeProjet typeProjet) {
		this.typeProjet = typeProjet;
	}

	@OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<TypeProjetProjetEnseignant> getTypeProjetProjetEnseignants() {
		return typeProjetProjetEnseignants;
	}

	public void setTypeProjetProjetEnseignants(
			List<TypeProjetProjetEnseignant> typeProjetProjetEnseignants) {
		this.typeProjetProjetEnseignants = typeProjetProjetEnseignants;
	}

	
	
}
