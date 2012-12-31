package com.esprit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Entity implementation class for Entity: Local
 * 
 */
@Entity
public class Locale implements Serializable {

	private Integer id;
	private String libelleLocal
	;
	private List<Unite> unites;
	private Unite unite;
	
	private List<Activite> activites;
	private Activite activite;
	private static final long serialVersionUID = 1L;

	public Locale() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public int getNombreUnites() {
//		return nombreUnites;
//	}
//
//	public void setNombreUnites(int nombreUnites) {
//		this.nombreUnites = nombreUnites;
//	}
//
//	public int getNombreActivites() {
//		return nombreActivites;
//	}
//
//	public void setNombreActivites(int nombreActivites) {
//		this.nombreActivites = nombreActivites;
//	}

	public String getLibelleLocal() {
		return libelleLocal;
	}

	public void setLibelleLocal(String libelleLocal) {
		this.libelleLocal = libelleLocal;
	}

	public Locale(Integer id, String libelleLocal, int nombreUnites,
			int nombreActivites) {
		super();
		this.id = id;
		this.libelleLocal = libelleLocal;
	
	}

	

	@Override
	public String toString() {
		return "Locale [id=" + id + ", libelleLocal=" + libelleLocal
				+ ", unites=" + unites + "]";
	}

	@OneToMany(mappedBy = "locale", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Unite> getUnites() {
		return unites;
	}

	public void setUnites(List<Unite> unites) {
		this.unites = unites;
	}

	@ManyToOne
	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	@OneToMany(mappedBy = "locale", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Activite> getActivites() {
		return activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}

	@ManyToOne
	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}
	
	

}
