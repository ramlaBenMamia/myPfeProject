package com.esprit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ChargeHoraireProjet
 *
 */
@Entity

public class ChargeHoraireProjet implements Serializable {

	private int idCharge;
	private int nbrHeures;
	private int nbrHeuresSupp;
	private int seuilHeures;
	private Enseignant enseignant;
	private Date date;
    private Promotion promotion;
	private static final long serialVersionUID = 1L;

	public ChargeHoraireProjet() {
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

	public int getNbrHeures() {
		return nbrHeures;
	}

	public void setNbrHeures(int nbrHeures) {
		this.nbrHeures = nbrHeures;
	}

	public int getNbrHeuresSupp() {
		return nbrHeuresSupp;
	}

	public void setNbrHeuresSupp(int nbrHeuresSupp) {
		this.nbrHeuresSupp = nbrHeuresSupp;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public int getSeuilHeures() {
		return seuilHeures;
	}

	public void setSeuilHeures(int seuilHeures) {
		this.seuilHeures = seuilHeures;
	}

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="enseignant_matriculeEnseigant",referencedColumnName="matriculeEnseigant")
	
	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	

	// @OneToMany(mappedBy = "chargeHoraireProjet")
	// public List<Enseignant> getEnseignants() {
	// return enseignants;
	// }
	//
	// public void setEnseignants(List<Enseignant> enseignants) {
	// this.enseignants = enseignants;
	// }

   
}
