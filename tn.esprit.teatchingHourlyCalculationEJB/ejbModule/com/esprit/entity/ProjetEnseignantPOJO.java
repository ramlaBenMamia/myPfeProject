package com.esprit.entity;

public class ProjetEnseignantPOJO {

	private String nom ;
	private String prenom ;
	private String projetLib ;
	private int semestre ;
	private int periode ;
	private String promotion ;
	private int nbrHeures;
	public ProjetEnseignantPOJO() {
		
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getProjetLib() {
		return projetLib;
	}
	public void setProjetLib(String projetLib) {
		this.projetLib = projetLib;
	}
	
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public int getPeriode() {
		return periode;
	}
	public void setPeriode(int periode) {
		this.periode = periode;
	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public int getNbrHeures() {
		return nbrHeures;
	}

	public void setNbrHeures(int nbrHeures) {
		this.nbrHeures = nbrHeures;
	}

	
	
	
}
