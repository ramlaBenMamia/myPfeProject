package com.esprit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ActiviteEnseignant
 *
 */
@Entity
@IdClass(ActiviteEnseignantID.class)
public class ActiviteEnseignant implements Serializable {

	private String matriculeEnseigant;	
	private int refActivite;
	
	
	private int id;
	private int nbrHeure;
	private int semestre;
	private int periode;
	private String nom;
	private Date date;
	private String description;
	
	private Enseignant enseignant;
	private Activite activite;
	
	private static final long serialVersionUID = 1L;

	public ActiviteEnseignant() {
		super();
	}
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public ActiviteEnseignant(String matriculeEnseigant, int refActivite,
			int nbrHeure, int semestre, int periode, String nom, Date date,
			String description, Enseignant enseignant, Activite activite) {
		super();
		this.matriculeEnseigant = matriculeEnseigant;
		this.refActivite = refActivite;
		this.nbrHeure = nbrHeure;
		this.semestre = semestre;
		this.periode = periode;
		this.nom = nom;
		this.date = date;
		this.description = description;
		this.enseignant = enseignant;
		this.activite = activite;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activite == null) ? 0 : activite.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((enseignant == null) ? 0 : enseignant.hashCode());
		result = prime
				* result
				+ ((matriculeEnseigant == null) ? 0 : matriculeEnseigant
						.hashCode());
		result = prime * result + nbrHeure;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + periode;
		result = prime * result + refActivite;
		result = prime * result + semestre;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActiviteEnseignant other = (ActiviteEnseignant) obj;
		if (activite == null) {
			if (other.activite != null)
				return false;
		} else if (!activite.equals(other.activite))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (enseignant == null) {
			if (other.enseignant != null)
				return false;
		} else if (!enseignant.equals(other.enseignant))
			return false;
		if (matriculeEnseigant == null) {
			if (other.matriculeEnseigant != null)
				return false;
		} else if (!matriculeEnseigant.equals(other.matriculeEnseigant))
			return false;
		if (nbrHeure != other.nbrHeure)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (periode != other.periode)
			return false;
		if (refActivite != other.refActivite)
			return false;
		if (semestre != other.semestre)
			return false;
		return true;
	}



	@Id
	public String getMatriculeEnseigant() {
		return matriculeEnseigant;
	}

	public void setMatriculeEnseigant(String matriculeEnseigant) {
		this.matriculeEnseigant = matriculeEnseigant;
	}

	@Id
	public int getRefActivite() {
		return refActivite;
	}

	public void setRefActivite(int refActivite) {
		this.refActivite = refActivite;
	}

	
	public int getNbrHeure() {
		return nbrHeure;
	}
	public void setNbrHeure(int nbrHeure) {
		this.nbrHeure = nbrHeure;
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
	
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	@ManyToOne
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	
	
	@ManyToOne
	public Activite getActivite() {
		return activite;
	}
	public void setActivite(Activite activite) {
		this.activite = activite;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
   
   
}
