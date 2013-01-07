package com.esprit.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Entity implementation class for Entity: UniteEnseignantPromotion
 * 
 */
@Entity
public class UniteEnseignantPromotion implements Serializable {

	private UniteEnseignantPromotionPK uniteEnseignantPromotionPK;

	private Enseignant enseignant;
	private Unite unite;
	private Promotion promotion;
	private Date date;

	private List<Enseignant> enseignants;
	private static final long serialVersionUID = 1L;

	public UniteEnseignantPromotion() {
		super();
	}

	@ManyToOne
	@JoinColumn(name = "matriculeEnseigant", referencedColumnName = "matriculeEnseigant", insertable = false, updatable = false)
	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	@ManyToOne
	@JoinColumn(name = "RefUnite", referencedColumnName = "RefUnite", insertable = false, updatable = false)
	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	@ManyToOne
	@JoinColumn(name = "idPromotion", referencedColumnName = "idPromotion", insertable = false, updatable = false)
	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	@EmbeddedId
	public UniteEnseignantPromotionPK getUniteEnseignantPromotionPK() {
		return uniteEnseignantPromotionPK;
	}

	public void setUniteEnseignantPromotionPK(
			UniteEnseignantPromotionPK uniteEnseignantPromotionPK) {
		this.uniteEnseignantPromotionPK = uniteEnseignantPromotionPK;
	}

	public UniteEnseignantPromotion(Enseignant enseignant, Unite unite,
			Promotion promotion,Date date) {
		super();
		this.enseignant = enseignant;
		this.unite = unite;
		this.promotion = promotion;
		this.date=date;
		this.uniteEnseignantPromotionPK = new UniteEnseignantPromotionPK(
				enseignant.getMatriculeEnseigant(), promotion.getIdPromotion(),
				unite.getRefUnite());
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(mappedBy = "uniteEnseignantPromotion", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(List<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

}
