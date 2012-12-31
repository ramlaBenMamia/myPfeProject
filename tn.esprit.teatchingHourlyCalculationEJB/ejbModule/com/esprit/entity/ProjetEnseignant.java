package com.esprit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: ProjetEnseignant
 * 
 */
@Entity
public class ProjetEnseignant implements Serializable {

	private ProjetEnseignantPK projetEnseignantPK;

	private int semestre;
	private int periode;
	private String nom;
	private int volumeHoraire;
	private int volumeHoraireMaximal;
	private int volumeHoraireSupp = volumeHoraireMaximal-volumeHoraire;
	private Date dateAffectation;
	
	private Enseignant enseignant;
	private Projet projet;
	private ProjetEnseignant projetEnseignant;

	private static final long serialVersionUID = 1L;

	public ProjetEnseignant() {
		super();
	}

	@ManyToOne
	@JoinColumn(name = "matriculeEnseigant", referencedColumnName = "matriculeEnseigant", insertable = false, updatable = false)
	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	@ManyToOne
	@JoinColumn(name = "refProjet", referencedColumnName = "refProjet", insertable = false, updatable = false)
	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public int getSemestre() {
		return this.semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getPeriode() {
		return this.periode;
	}

	public void setPeriode(int periode) {
		this.periode = periode;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getVolumeHoraire() {
		return volumeHoraire;
	}

	public void setVolumeHoraire(int volumeHoraire) {
		this.volumeHoraire = volumeHoraire;
	}

	@EmbeddedId
	public ProjetEnseignantPK getProjetEnseignantPK() {
		return projetEnseignantPK;
	}

	public void setProjetEnseignantPK(ProjetEnseignantPK projetEnseignantPK) {
		this.projetEnseignantPK = projetEnseignantPK;
	}

	public ProjetEnseignant(int semestre, int periode, int volumeHoraire,Date dateAffectation,
			Enseignant enseignant, Projet projet) {
		super();
		this.semestre = semestre;
		this.periode = periode;
		this.volumeHoraire = volumeHoraire;
		this.enseignant = enseignant;
		this.projet = projet;
		this.dateAffectation=dateAffectation;
		this.projetEnseignantPK = new ProjetEnseignantPK(projet.getRefProjet(),
				enseignant.getMatriculeEnseigant());
	}

	public Date getDateAffectation() {
		return dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	public int getVolumeHoraireMaximal() {
		return volumeHoraireMaximal;
	}

	public void setVolumeHoraireMaximal(int volumeHoraireMaximal) {
		this.volumeHoraireMaximal = volumeHoraireMaximal;
	}

	public int getVolumeHoraireSupp() {
		return volumeHoraireSupp;
	}

	public void setVolumeHoraireSupp(int volumeHoraireSupp) {
		this.volumeHoraireSupp = volumeHoraireSupp;
	}

	public ProjetEnseignant getProjetEnseignant() {
		return projetEnseignant;
	}

	public void setProjetEnseignant(ProjetEnseignant projetEnseignant) {
		this.projetEnseignant = projetEnseignant;
	}



}
