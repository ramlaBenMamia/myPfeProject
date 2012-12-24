package com.esprit.entity;

import java.io.Serializable;

/**
 * Entity implementation class for Entity: ActiviteEnseignant
 *
 */


public class ActiviteEnseignantID implements Serializable {

	private String matriculeEnseigant;	
	private int refActivite;

	private static final long serialVersionUID = 1L;

	public ActiviteEnseignantID() {
		super();
	}
	
	

	public ActiviteEnseignantID(String matriculeEnseigant, int refActivite) {
		super();
		this.matriculeEnseigant = matriculeEnseigant;
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
		ActiviteEnseignantID other = (ActiviteEnseignantID) obj;
		if (matriculeEnseigant == null) {
			if (other.matriculeEnseigant != null)
				return false;
		} else if (!matriculeEnseigant.equals(other.matriculeEnseigant))
			return false;
		if (refActivite != other.refActivite)
			return false;
		return true;
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
	
	
   
   
}
