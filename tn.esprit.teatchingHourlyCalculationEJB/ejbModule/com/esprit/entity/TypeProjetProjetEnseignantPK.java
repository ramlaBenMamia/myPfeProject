package com.esprit.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TypeProjetProjetEnseignantPK implements Serializable{
	
	private int refProjet;
	private String matriculeEnseigant;
	private Integer idType;

	private static final long serialVersionUID = 1L;

	public TypeProjetProjetEnseignantPK(int refProjet,
			String matriculeEnseigant, Integer idType) {
		super();
		this.refProjet = refProjet;
		this.matriculeEnseigant = matriculeEnseigant;
		this.idType = idType;
	}

	public TypeProjetProjetEnseignantPK() {
	}

	public int getRefProjet() {
		return refProjet;
	}

	public void setRefProjet(int refProjet) {
		this.refProjet = refProjet;
	}

	public String getMatriculeEnseigant() {
		return matriculeEnseigant;
	}

	public void setMatriculeEnseigant(String matriculeEnseigant) {
		this.matriculeEnseigant = matriculeEnseigant;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idType == null) ? 0 : idType.hashCode());
		result = prime
				* result
				+ ((matriculeEnseigant == null) ? 0 : matriculeEnseigant
						.hashCode());
		result = prime * result + refProjet;
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
		TypeProjetProjetEnseignantPK other = (TypeProjetProjetEnseignantPK) obj;
		if (idType == null) {
			if (other.idType != null)
				return false;
		} else if (!idType.equals(other.idType))
			return false;
		if (matriculeEnseigant == null) {
			if (other.matriculeEnseigant != null)
				return false;
		} else if (!matriculeEnseigant.equals(other.matriculeEnseigant))
			return false;
		if (refProjet != other.refProjet)
			return false;
		return true;
	}

	

}
