package com.esprit.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Entity implementation class for Entity: ActiviteEnseignant
 *
 */

@Embeddable
public class ActiviteEnseignantPK implements Serializable {

	private String matriculeEnseigant;	
	private int refActivite;

	private static final long serialVersionUID = 1L;

	public ActiviteEnseignantPK() {
	}
	
	

	public ActiviteEnseignantPK(String matriculeEnseigant, int refActivite) {
		super();
		this.matriculeEnseigant = matriculeEnseigant;
		this.refActivite = refActivite;
	}



	public String getMatriculeEnseigant() {
		return matriculeEnseigant;
	}

	public void setMatriculeEnseigant(String matriculeEnseigant) {
		this.matriculeEnseigant = matriculeEnseigant;
	}

	public int getRefActivite() {
		return refActivite;
	}

	public void setRefActivite(int refActivite) {
		this.refActivite = refActivite;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((matriculeEnseigant == null) ? 0 : matriculeEnseigant
						.hashCode());
		result = prime * result + refActivite;
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
		ActiviteEnseignantPK other = (ActiviteEnseignantPK) obj;
		if (matriculeEnseigant == null) {
			if (other.matriculeEnseigant != null)
				return false;
		} else if (!matriculeEnseigant.equals(other.matriculeEnseigant))
			return false;
		if (refActivite != other.refActivite)
			return false;
		return true;
	}
	
	
	
}
