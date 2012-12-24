package com.esprit.entity;
import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Entity implementation class for Entity: ProjetEnseignant
 *
 */

@Embeddable
public class ProjetEnseignantPK implements Serializable {
	
	private int refProjet;
	private String matriculeEnseigant;	


	public ProjetEnseignantPK() {
	}
	
	
	
	public ProjetEnseignantPK(int refProjet, String matriculeEnseigant) {
		this.refProjet = refProjet;
		this.matriculeEnseigant = matriculeEnseigant;
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		ProjetEnseignantPK other = (ProjetEnseignantPK) obj;
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
