package com.esprit.entity;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TypeProjetProjetEnseignant
 * 
 */
@Entity
public class TypeProjetProjetEnseignant implements Serializable {

	private TypeProjetProjetEnseignantPK typeProjetProjetEnseignantPK;
	private TypeProjet typeProjet;
	private Enseignant enseignant;
	private Projet projet;

	private boolean statut;
	private Integer volumeHoraire;
	private int semsestre;
	private Integer periode;

	private static final long serialVersionUID = 1L;

	public TypeProjetProjetEnseignant(TypeProjet typeProjet,
			Enseignant enseignant, Projet projet, boolean statut,
			Integer volumeHoraire, int semsestre, Integer periode) {
		super();
		this.typeProjet = typeProjet;
		this.enseignant = enseignant;
		this.projet = projet;
		this.statut = statut;
		this.volumeHoraire = volumeHoraire;
		this.semsestre = semsestre;
		this.periode = periode;
		this.typeProjetProjetEnseignantPK = new TypeProjetProjetEnseignantPK(
				projet.getRefProjet(), enseignant.getMatriculeEnseigant(),
				typeProjet.getIdType());
	}

	public TypeProjetProjetEnseignant() {
		super();
	}

	public boolean getStatut() {
		return this.statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public Integer getVolumeHoraire() {
		return this.volumeHoraire;
	}

	public void setVolumeHoraire(Integer volumeHoraire) {
		this.volumeHoraire = volumeHoraire;
	}

	public int getSemsestre() {
		return this.semsestre;
	}

	public void setSemsestre(int semsestre) {
		this.semsestre = semsestre;
	}

	public Integer getPeriode() {
		return this.periode;
	}

	public void setPeriode(Integer periode) {
		this.periode = periode;
	}

	@EmbeddedId
	public TypeProjetProjetEnseignantPK getTypeProjetProjetEnseignantPK() {
		return typeProjetProjetEnseignantPK;
	}

	public void setTypeProjetProjetEnseignantPK(
			TypeProjetProjetEnseignantPK typeProjetProjetEnseignantPK) {
		this.typeProjetProjetEnseignantPK = typeProjetProjetEnseignantPK;
	}

	@ManyToOne
	@JoinColumn(name = "idType", referencedColumnName = "idType", insertable = false, updatable = false)
	public TypeProjet getTypeProjet() {
		return typeProjet;
	}

	public void setTypeProjet(TypeProjet typeProjet) {
		this.typeProjet = typeProjet;
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

}
