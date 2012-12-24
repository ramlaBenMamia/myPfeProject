package com.esprit.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Administrateur
 *
 */
@Entity

public class Administrateur implements Serializable {

	private String login;
	private String password;

	private static final long serialVersionUID = 1L;

	public Administrateur() {
		super();
	}
	
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;

	
	public Administrateur(String matricule, int cin, String nom, String prenom,
			String email, int numTelephone, String nationnalite, String login,
			String password) {
		super();
		
		
		this.login = login;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrateur [ login=" + login + ", password=" + password
				+ "]";
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

	
   
}
