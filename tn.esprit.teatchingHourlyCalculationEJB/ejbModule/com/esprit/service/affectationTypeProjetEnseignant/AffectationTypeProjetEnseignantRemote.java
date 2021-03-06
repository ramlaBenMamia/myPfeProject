package com.esprit.service.affectationTypeProjetEnseignant;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.entity.Enseignant;
import com.esprit.entity.Projet;
import com.esprit.entity.TypeProjet;
import com.esprit.entity.TypeProjetProjetEnseignant;

@Remote
public interface AffectationTypeProjetEnseignantRemote {
	public void createEnseignant(Enseignant enseignant);

	public void createTypeProjet(TypeProjet typeProjet);

	public void createProjet(Projet projet);

	public Enseignant getEnseignantByMat(String matriculeEnseigant);

	public TypeProjet getTypeProjetById(int id);

	public Projet getProjetById(int idProjet);

	public void createAffectationETPP(Enseignant enseignant,
			TypeProjet typeProjet, Projet projet, int semestre,
			int volumeHoraire, boolean statut, int periode);

	public List<TypeProjetProjetEnseignant> findAllByNomEnseignant(
			String nomEnseignant);

	public List<TypeProjetProjetEnseignant> findAllByNomType(String nomType);

	public List<TypeProjetProjetEnseignant> findAllByNomProjet(String nomProjet);

}
