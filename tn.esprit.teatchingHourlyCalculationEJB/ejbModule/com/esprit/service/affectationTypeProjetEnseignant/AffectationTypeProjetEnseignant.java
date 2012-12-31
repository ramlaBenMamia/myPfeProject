package com.esprit.service.affectationTypeProjetEnseignant;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.entity.ChargeHoraireProjet;
import com.esprit.entity.Enseignant;
import com.esprit.entity.Projet;
import com.esprit.entity.TypeProjet;
import com.esprit.entity.TypeProjetProjetEnseignant;

/**
 * Session Bean implementation class AffectationUniteEnseignantPromotion
 */
@Stateless
@LocalBean
public class AffectationTypeProjetEnseignant implements
		AffectationTypeProjetEnseignantRemote,
		AffectationTypeProjetEnseignantLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public AffectationTypeProjetEnseignant() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createEnseignant(Enseignant enseignant) {
		entityManager.persist(enseignant);

	}

	@Override
	public void createTypeProjet(TypeProjet typeProjet) {
		entityManager.persist(typeProjet);

	}

	@Override
	public void createProjet(Projet projet) {
		entityManager.persist(projet);

	}

	@Override
	public Enseignant getEnseignantByMat(String matriculeEnseigant) {
		return entityManager.find(Enseignant.class, matriculeEnseigant);

	}

	@Override
	public TypeProjet getTypeProjetById(int id) {
		return entityManager.find(TypeProjet.class, id);

	}

	@Override
	public Projet getProjetById(int id) {
		return entityManager.find(Projet.class, id);

	}

	@Override
	public void createAffectationETPP(Enseignant enseignant,
			TypeProjet typeProjet, Projet projet, int semestre,
			int volumeHoraire, boolean statut, int periode) {
		TypeProjetProjetEnseignant typeProjetProjetEnseignant = new TypeProjetProjetEnseignant(
				entityManager.merge(typeProjet),
				entityManager.merge(enseignant), entityManager.merge(projet),
				statut, volumeHoraire, semestre, periode);
		entityManager.persist(typeProjetProjetEnseignant);
		
		ChargeHoraireProjet chargeHoraireProjet = new ChargeHoraireProjet();
		chargeHoraireProjet.setNbrHeures(volumeHoraire);
		chargeHoraireProjet.setEnseignant(enseignant);
		entityManager.persist(chargeHoraireProjet);

	}

	@Override
	public List<TypeProjetProjetEnseignant> findAllByNomEnseignant(
			String nomEnseignant) {
		return entityManager
				.createQuery(
						"select p from TypeProjetProjetEnseignant p where p.enseignant.nom like :pnom ")
				.setParameter("pnom", nomEnseignant).getResultList();
	}

	@Override
	public List<TypeProjetProjetEnseignant> findAllByNomType(String nom) {
		return entityManager
				.createQuery(
						"select p from TypeProjetProjetEnseignant p where p.typeProjet.libelleType like :pnom ")
				.setParameter("pnom", nom).getResultList();
	}

	@Override
	public List<TypeProjetProjetEnseignant> findAllByNomProjet(String nom) {
		return entityManager
				.createQuery(
						"select p from TypeProjetProjetEnseignant p where p.projet.libelleProjet like :pnom ")
				.setParameter("pnom", nom).getResultList();
	}

}
