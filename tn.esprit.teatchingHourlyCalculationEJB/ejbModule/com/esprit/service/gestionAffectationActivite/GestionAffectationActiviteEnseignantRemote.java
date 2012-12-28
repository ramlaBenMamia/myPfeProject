package com.esprit.service.gestionAffectationActivite;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.entity.Activite;
import com.esprit.entity.ActiviteEnseignant;
import com.esprit.entity.Enseignant;

@Remote
public interface GestionAffectationActiviteEnseignantRemote {
	public List<ActiviteEnseignant> findAll();

	void delete(ActiviteEnseignant A);

	void update(ActiviteEnseignant A);

	public List<ActiviteEnseignant> findAll1(int matriculeEnseigant);

	public List<ActiviteEnseignant> findAllByYearSemestre(int semestre,
			String promotion);

	public List<ActiviteEnseignant> findAllBySemestre(int semestre,
			String Promotion);

	public List<ActiviteEnseignant> chargeTotal(int refActivite,
			String promotion);

	public List<ActiviteEnseignant> findAllAffEnseig();

	public List<ActiviteEnseignant> findAllByNomEnsei(String nom);

	// ***************** proteuse de données ***********
	public void createEnseignant(Enseignant enseignant);

	public void createActivite(Activite activite);

	public Enseignant getEnseignantByMat(String matriculeEnseigant);

	public Activite getActiviteByRef(int refActivite);

	public void createAffectationActivite(int semestre, int periode,
			int volumeHoraire, Enseignant enseignant, Activite activite);

}
