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
	// private String EtatProjet;
	private String description;
	// private Encadrement encadrement;
	private List<ProjetEnseignant> projetEnseignants;
	
	private List<Enseignant> enseignants;
	private Enseignant enseignant;

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

	// public String getEtatProjet() {
	// return EtatProjet;
	// }
	//
	// public void setEtatProjet(String etatProjet) {
	// EtatProjet = etatProjet;
	// }

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

	//
	// public String getEtatProjet() {
	// return EtatProjet;
	// }
	//
	// public void setEtatProjet(String etatProjet) {
	// EtatProjet = etatProjet;
	// }
	//

	// @ManyToOne
	// public AnneeUniversitaire getAnneeUniversitaire() {
	// return anneeUniversitaire;
	// }
	//
	// public void setAnneeUniversitaire(AnneeUniversitaire anneeUniversitaire)
	// {
	// this.anneeUniversitaire = anneeUniversitaire;
	// }
	//
	// @OneToOne
	// public Encadrement getEncadrement() {
	// return encadrement;
	// }
	//
	// public void setEncadrement(Encadrement encadrement) {
	// this.encadrement = encadrement;
	// }
	
	
	
	
	//********************* affichage par projet ******************
	
	@OneToMany(mappedBy = "projet")
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

}
