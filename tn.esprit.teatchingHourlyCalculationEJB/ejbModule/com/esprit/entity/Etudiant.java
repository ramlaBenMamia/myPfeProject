package com.esprit.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Etudiant
 *
 */
@Entity

public class Etudiant implements Serializable {

	private String matricule;
	private int cin;
	private String nom;
	private String prenom;
	private String email;
	private int numTelephone;
	private String nationnalite;
//	private AnneeUniversitaire anneeUniversitaire;
//	private List<Encadrement> enseignant;
	private static final long serialVersionUID = 1L;

	public Etudiant() {
		super();
	}

	@Id
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumTelephone() {
		return numTelephone;
	}

	public void setNumTelephone(int numTelephone) {
		this.numTelephone = numTelephone;
	}

	public String getNationnalite() {
		return nationnalite;
	}

	public void setNationnalite(String nationnalite) {
		this.nationnalite = nationnalite;
	}
	
	
	
//	@ManyToOne
//	public AnneeUniversitaire getAnneeUniversitaire() {
//		return anneeUniversitaire;
//	}
//
//	public void setAnneeUniversitaire(AnneeUniversitaire anneeUniversitaire) {
//		this.anneeUniversitaire = anneeUniversitaire;
//	}
//
//	@OneToMany(mappedBy = "etudiant")
//	public List<Encadrement> getEnseignant() {
//		return enseignant;
//	}
//
//	public void setEnseignant(List<Encadrement> enseignant) {
//		this.enseignant = enseignant;
//	}

   
}
