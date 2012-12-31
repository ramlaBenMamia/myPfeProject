package com.esprit.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

//import org.hibernate.annotations.LazyCollection;
//import org.hibernate.annotations.LazyCollectionOption;

/**
 * Entity implementation class for Entity: Enseignant
 * 
 */
@Entity
public class Enseignant implements Serializable {

	private String nom;
	private String prenom;
	private int cin;
	private String email;
	private int numTelephone;
	private String nationalite;
	private Date date;

	// *********** adresse *************************
	private int codePostal;
	private String rue;
	private String ville;

	// *********** administration ******************
	private String matriculeEnseigant;
	private String login;
	private String password;
	private int privilege;

	private List<ProjetEnseignant> projetEnseignants;

	private List<UniteEnseignantPromotion> uniteEnseignantPromotions;

	private List<ActiviteEnseignant> activiteEnseignants;

	private List<Projet> projets;
	private Projet projet;

	private List<TypeProjet> typeProjets;
	private TypeProjet typeProjet;
	private List<TypeProjetProjetEnseignant> typeProjetProjetEnseignants;

	private List<Activite> activites;
	private Activite activite;

	private Unite unite;
	private List<Unite> unites;

	private static final long serialVersionUID = 1L;

	public Enseignant() {
		super();
	}

	@Id
	public String getMatriculeEnseigant() {
		return matriculeEnseigant;
	}

	public void setMatriculeEnseigant(String matriculeEnseigant) {
		this.matriculeEnseigant = matriculeEnseigant;
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

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationnalite) {
		this.nationalite = nationnalite;
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

	@OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<ProjetEnseignant> getProjetEnseignants() {
		return projetEnseignants;
	}

	public void setProjetEnseignants(List<ProjetEnseignant> projetEnseignants) {
		this.projetEnseignants = projetEnseignants;
	}

	@OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<ActiviteEnseignant> getActiviteEnseignants() {
		return activiteEnseignants;
	}

	public void setActiviteEnseignants(
			List<ActiviteEnseignant> activiteEnseignants) {
		this.activiteEnseignants = activiteEnseignants;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	// ******************* affichage par activite ********

	@OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
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

	// ********** affichage par projet **************

	@OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	@ManyToOne
	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	// ********* affichage par unite ***************

	@ManyToOne
	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	@OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Unite> getUnites() {
		return unites;
	}

	public void setUnites(List<Unite> unites) {
		this.unites = unites;
	}

	@OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<UniteEnseignantPromotion> getUniteEnseignantPromotions() {
		return uniteEnseignantPromotions;
	}

	public void setUniteEnseignantPromotions(
			List<UniteEnseignantPromotion> uniteEnseignantPromotions) {
		this.uniteEnseignantPromotions = uniteEnseignantPromotions;
	}

	@OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<TypeProjet> getTypeProjets() {
		return typeProjets;
	}

	public void setTypeProjets(List<TypeProjet> typeProjets) {
		this.typeProjets = typeProjets;
	}

	@ManyToOne
	public TypeProjet getTypeProjet() {
		return typeProjet;
	}

	public void setTypeProjet(TypeProjet typeProjet) {
		this.typeProjet = typeProjet;
	}

	@OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<TypeProjetProjetEnseignant> getTypeProjetProjetEnseignants() {
		return typeProjetProjetEnseignants;
	}

	public void setTypeProjetProjetEnseignants(
			List<TypeProjetProjetEnseignant> typeProjetProjetEnseignants) {
		this.typeProjetProjetEnseignants = typeProjetProjetEnseignants;
	}

}
