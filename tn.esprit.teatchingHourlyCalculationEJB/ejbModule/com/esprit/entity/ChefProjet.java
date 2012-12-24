package com.esprit.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ChefProjet
 *
 */
@Entity

public class ChefProjet implements Serializable {

	private String MatriculeChef;
	private int cin;
	private String nom;
	private String prenom;
	private String email;
	private int numTelephone;
	private String nationnalite;
	private String login;
	private String password;
	private int privilege;
	private Unite unite;
	private static final long serialVersionUID = 1L;

	public ChefProjet() {
		super();
	}
	
	@Id
	public String getMatriculeChef() {
		return MatriculeChef;
	}

	public void setMatriculeChef(String matriculeChef) {
		MatriculeChef = matriculeChef;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumTelephone() {
		return numTelephone;
	}

	public void setNumTelephone(int numTelephone) {
		this.numTelephone = numTelephone;
	}

	public String getNationnalite() {
		return nationnalite;
	}

	public void setNationnalite(String nationnalite) {
		this.nationnalite = nationnalite;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPrivilege() {
		return privilege;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	@OneToOne
	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}
   
}
