package com.esprit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Periode
 *
 */
@Entity

public class Periode implements Serializable {

	   

	private int idPeriode;
	private Date dateDebut;
	private Date dateFin;
	private int numeroPeriode;
	private static final long serialVersionUID = 1L;
    private int  idSemestre;
	public Periode() {
		super();
	}  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdPeriode() {
		return this.idPeriode;
	}

	public void setIdPeriode(int idPeriode) {
		this.idPeriode = idPeriode;
	}  
    @Temporal(TemporalType.DATE)
	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}   
    @Temporal(TemporalType.DATE)
	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getNumeroPeriode() {
		return numeroPeriode;
	}
	public void setNumeroPeriode(int numeroPeriode) {
		this.numeroPeriode = numeroPeriode;
	}
	public int getIdSemestre() {
		return idSemestre;
	}
	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}
   
}
