package com.esprit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * Entity implementation class for Entity: Semestre
 *
 */
@Entity

public class Semestre implements Serializable {

	   
	
	private int idSemestre;
	private static final long serialVersionUID = 1L;
	private Promotion promotion;
    private Date dateDebut;
    private Date dateFin;
    private int semestreLib;
	public Semestre() {
		super();
	}   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdSemestre() {
		return this.idSemestre;
	}

	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	@ManyToOne
	public Promotion getPromotion() {
		return promotion;
	}
	
//	@OneToMany(mappedBy="semestre",cascade=CascadeType.ALL)
//	public List<Periode> getPeriodes() {
//		return periodes;
//	}
//	public void setPeriodes(List<Periode> periodes) {
//		this.periodes = periodes;
//	}
	 @Temporal(TemporalType.DATE)
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	 @Temporal(TemporalType.DATE)
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	public int getSemestreLib() {
		return semestreLib;
	}
	public void setSemestreLib(int semestreLib) {
		this.semestreLib = semestreLib;
	}
   
}
