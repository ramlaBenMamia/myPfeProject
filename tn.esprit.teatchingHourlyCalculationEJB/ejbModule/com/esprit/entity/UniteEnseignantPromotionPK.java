package com.esprit.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UniteEnseignantPromotionPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String matriculeEnseigant;
	private int idPromotion;
	private int RefUnite;

	public UniteEnseignantPromotionPK() {

	}

	public UniteEnseignantPromotionPK(String matriculeEnseigant,
			int idPromotion, int refUnite) {
		super();
		this.matriculeEnseigant = matriculeEnseigant;
		this.idPromotion = idPromotion;
		this.RefUnite = refUnite;
	}

	public int getRefUnite() {
		return RefUnite;
	}

	public void setRefUnite(int RefUnite) {
		this.RefUnite = RefUnite;
	}

	public String getMatriculeEnseigant() {
		return matriculeEnseigant;
	}

	public void setMatriculeEnseigant(String matriculeEnseigant) {
		this.matriculeEnseigant = matriculeEnseigant;
	}

	public int getIdPromotion() {
		return idPromotion;
	}

	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPromotion;
		result = prime
				* result
				+ ((matriculeEnseigant == null) ? 0 : matriculeEnseigant
						.hashCode());
		result = prime * result + RefUnite;
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
		UniteEnseignantPromotionPK other = (UniteEnseignantPromotionPK) obj;
		if (idPromotion != other.idPromotion)
			return false;
		if (matriculeEnseigant == null) {
			if (other.matriculeEnseigant != null)
				return false;
		} else if (!matriculeEnseigant.equals(other.matriculeEnseigant))
			return false;
		if (RefUnite != other.RefUnite)
			return false;
		return true;
	}

}
