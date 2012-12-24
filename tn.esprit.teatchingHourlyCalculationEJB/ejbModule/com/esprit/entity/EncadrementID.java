package com.esprit.entity;

import java.io.Serializable;

/**
 * Entity implementation class for Entity: Encadrement
 *
 */


public class EncadrementID implements Serializable {
	
	private String matriculeEnseigant;	
	private String matricule;
	
	private static final long serialVersionUID = 1L;

	public EncadrementID() {
		super();
	}

	
	public EncadrementID(String matriculeEnseigant, String matricule) {
		super();
		this.matriculeEnseigant = matriculeEnseigant;
		this.matricule = matricule;
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricule == null) ? 0 : matricule.hashCode());
		result = prime
				* result
				+ ((matriculeEnseigant == null) ? 0 : matriculeEnseigant
						.hashCode());
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
		EncadrementID other = (EncadrementID) obj;
		if (matricule == null) {
			if (other.matricule != null)
				return false;
		} else if (!matricule.equals(other.matricule))
			return false;
		if (matriculeEnseigant == null) {
			if (other.matriculeEnseigant != null)
				return false;
		} else if (!matriculeEnseigant.equals(other.matriculeEnseigant))
			return false;
		return true;
	}


	public String getMatriculeEnseigant() {
		return matriculeEnseigant;
	}

	public void setMatriculeEnseigant(String matriculeEnseigant) {
		this.matriculeEnseigant = matriculeEnseigant;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	
   
}
