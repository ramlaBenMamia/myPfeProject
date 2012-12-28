package com.esprit.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: ActiviteEnseignant
 * 
 */
@Entity
public class ActiviteEnseignant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ActiviteEnseignantPK activiteEnseignantPK;

	private int semestre;
	private int periode;
	private String nom;
	private int volumeHoraire;
	private Enseignant enseignant;
	private Activite activite;

	public ActiviteEnseignant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActiviteEnseignant(int semestre, int periode, int volumeHoraire,
			Enseignant enseignant, Activite activite) {
		super();
		this.semestre = semestre;
		this.periode = periode;
		this.volumeHoraire = volumeHoraire;
		this.enseignant = enseignant;
		this.activite = activite;
		this.activiteEnseignantPK = new ActiviteEnseignantPK(
				enseignant.getMatriculeEnseigant(), activite.getRefActivite());
	}

	@EmbeddedId
	public ActiviteEnseignantPK getActiviteEnseignantPK() {
		return activiteEnseignantPK;
	}

	public void setActiviteEnseignantPK(
			ActiviteEnseignantPK activiteEnseignantPK) {
		this.activiteEnseignantPK = activiteEnseignantPK;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getPeriode() {
		return periode;
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

	@ManyToOne
	@JoinColumn(name = "matriculeEnseigant", referencedColumnName = "matriculeEnseigant", insertable = false, updatable = false)
	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	@ManyToOne
	@JoinColumn(name = "refActivite", referencedColumnName = "refActivite", insertable = false, updatable = false)
	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

}
