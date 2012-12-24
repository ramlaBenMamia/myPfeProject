package com.esprit.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: SeuilCharge
 * 
 */
@Entity
public class SeuilCharge implements Serializable {

	private int idSeuil;
	private int seuil;
	private static final long serialVersionUID = 1L;

	public SeuilCharge() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdSeuil() {
		return this.idSeuil;
	}

	public void setIdSeuil(int idSeuil) {
		this.idSeuil = idSeuil;
	}

	public int getSeuil() {
		return this.seuil;
	}

	public void setSeuil(int seuil) {
		this.seuil = seuil;
	}

}
