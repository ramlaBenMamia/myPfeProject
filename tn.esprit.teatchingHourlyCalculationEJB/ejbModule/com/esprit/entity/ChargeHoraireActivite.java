package com.esprit.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ChargeHoraireActivite
 *
 */
@Entity

public class ChargeHoraireActivite implements Serializable {

	
	private int idCharge;
	private int nbrHeures;
	private int nbrHeuresSupp;
	private int seuilHeures;
//  private List<Enseignant> enseignants;
	private Promotion promotion;
	private static final long serialVersionUID = 1L;

	public ChargeHoraireActivite() {
		super();
	}
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdCharge() {
		return this.idCharge;
	}

	public void setIdCharge(int idCharge) {
		this.idCharge = idCharge;
	}

	public int getNbrHeuresSupp() {
		return nbrHeuresSupp;
	}

	public void setNbrHeuresSupp(int nbrHeuresSupp) {
		this.nbrHeuresSupp = nbrHeuresSupp;
	}

	public int getNbrHeures() {
		return nbrHeures;
	}

	public void setNbrHeures(int nbrHeures) {
		this.nbrHeures = nbrHeures;
	}

	
	@ManyToOne(cascade = CascadeType.ALL)
	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	// @OneToMany(mappedBy = "chargeHoraireActivite")
	// public List<Enseignant> getEnseignants() {
	// return enseignants;
	// }
	//
	// public void setEnseignants(List<Enseignant> enseignants) {
	// this.enseignants = enseignants;
	// }

	public int getSeuilHeures() {
		return seuilHeures;
	}

	public void setSeuilHeures(int seuilHeures) {
		this.seuilHeures = seuilHeures;
	}

	
}
