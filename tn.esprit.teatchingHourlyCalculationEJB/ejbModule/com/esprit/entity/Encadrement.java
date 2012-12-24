package com.esprit.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Encadrement
 * 
 */
@Entity
@IdClass(EncadrementID.class)
public class Encadrement implements Serializable {

	private String matriculeEnseigant;
	private String matricule;

	private int IdEncadrement;
	private Projet projet;
	private Etudiant etudiant;
	private Enseignant enseignant;
	private static final long serialVersionUID = 1L;

	public Encadrement() {
		super();
	}

	public int getIdEncadrement() {
		return this.IdEncadrement;
	}

	public void setIdEncadrement(int IdEncadrement) {
		this.IdEncadrement = IdEncadrement;
	}

	@OneToOne
	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	@ManyToOne
	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	@ManyToOne
	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	@Id
	public String getMatriculeEnseigant() {
		return matriculeEnseigant;
	}

	public void setMatriculeEnseigant(String matriculeEnseigant) {
		this.matriculeEnseigant = matriculeEnseigant;
	}

	@Id
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

}
