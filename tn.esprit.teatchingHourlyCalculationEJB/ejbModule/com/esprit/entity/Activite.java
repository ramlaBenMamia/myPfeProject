package com.esprit.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Entity implementation class for Entity: Activite
 * 
 */
@Entity
public class Activite implements Serializable {

	private int refActivite;
	
	//***************** siminaire , club , conference , 
	private String libelleActivite;
	
	//*********** theme
	private String description;
	private Date dateDebut;
	private Date dateFin;
	private String local;

	private List<ActiviteEnseignant> activiteEnseignants;
	// private List<Enseignant> enseignants;

	private static final long serialVersionUID = 1L;

	public Activite() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getRefActivite() {
		return refActivite;
	}

	public void setRefActivite(int refActivite) {
		this.refActivite = refActivite;
	}

	
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@OneToMany(mappedBy = "activite", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<ActiviteEnseignant> getActiviteEnseignants() {
		return activiteEnseignants;
	}

	public void setActiviteEnseignants(
			List<ActiviteEnseignant> activiteEnseignants) {
		this.activiteEnseignants = activiteEnseignants;
	}

	public String getLibelleActivite() {
		return libelleActivite;
	}

	public void setLibelleActivite(String libelleActivite) {
		this.libelleActivite = libelleActivite;
	}

	// public List<Enseignant> getEnseignants() {
	// return enseignants;
	// }
	//
	// public void setEnseignants(List<Enseignant> enseignants) {
	// this.enseignants = enseignants;
	// }

}
