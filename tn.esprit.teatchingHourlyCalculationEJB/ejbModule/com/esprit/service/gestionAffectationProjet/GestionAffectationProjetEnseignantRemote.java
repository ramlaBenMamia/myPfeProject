package com.esprit.service.gestionAffectationProjet;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import com.esprit.entity.Enseignant;
import com.esprit.entity.Projet;
import com.esprit.entity.ProjetEnseignant;
import com.esprit.entity.ProjetEnseignantPOJO;

@Remote
public interface GestionAffectationProjetEnseignantRemote {
	public List<ProjetEnseignant> findAll();

	void delete(ProjetEnseignant A);

	void update(ProjetEnseignant A);

	public List<ProjetEnseignant> findAll1(int matriculeEnseigant);

	public List<ProjetEnseignant> findAllByYearSemestre(int semestre,
			String promotion);

	public List<ProjetEnseignant> findAllBySemestre(int semestre, String Promotion);

	public List<ProjetEnseignantPOJO> findAllByProjet(int refProjet, String promotion);


	public List<ProjetEnseignant> chargeTotal(int refProjet, String promotion);

	public List<ProjetEnseignant> findAllAffEnseig();
	
	public List<ProjetEnseignant> findAllByNomEnsei(String nom);


	
	// *********** porteuse de donné**********

		public void createEnseignant(Enseignant enseignant);

		public void createProjet(Projet projet);

		public Enseignant getEnseignantByMat(String matriculeEnseigant);

		public Projet getProjetByRef(int refProjet);

		public void createAffectation(int semestre, int periode, int volumeHoraire,Date dateAffectation,
				Enseignant enseignant, Projet projet);

}
