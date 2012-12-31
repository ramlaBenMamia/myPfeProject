package com.esprit.entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Entity implementation class for Entity: TypeProjet
 *
 */
@Entity

public class TypeProjet implements Serializable {

	private Integer idType;
	private String libelleType;
	
	private Projet projet;
	private Enseignant enseignant;
	private List<TypeProjetProjetEnseignant> typeProjetProjetEnseignants;
	
	private static final long serialVersionUID = 1L;

	public TypeProjet() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdType() {
		return this.idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}   
	public String getLibelleType() {
		return this.libelleType;
	}

	public void setLibelleType(String libelleType) {
		this.libelleType = libelleType;
	}
	
	@ManyToOne
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
	@ManyToOne
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	
	@OneToMany(mappedBy = "typeProjet", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<TypeProjetProjetEnseignant> getTypeProjetProjetEnseignants() {
		return typeProjetProjetEnseignants;
	}
	public void setTypeProjetProjetEnseignants(
			List<TypeProjetProjetEnseignant> typeProjetProjetEnseignants) {
		this.typeProjetProjetEnseignants = typeProjetProjetEnseignants;
	}
	
	
   
}
