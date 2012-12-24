package com.esprit.service.gestionAffectationProjet;

import java.util.List;
import java.util.logging.Level;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.esprit.entity.Enseignant;
import com.esprit.entity.Projet;
import com.esprit.entity.ProjetEnseignant;
import com.esprit.entity.ProjetEnseignantPOJO;
import com.log.LogUtil;

/**
 * Session Bean implementation class GestionAffModEnseig
 */
@Stateless
public class GestionAffectationProjetEnseignant implements
		GestionAffectationProjetEnseignantRemote,
		GestionAffectationProjetEnseignantLocal {

	@PersistenceContext
	EntityManager em;

	public GestionAffectationProjetEnseignant() {

	}

	@Override
	public List<ProjetEnseignant> findAll() {
		LogUtil.log("finding all ProjetEnseignant instances", Level.INFO, null);
		try {
			final String queryString = "select model from Enseignant model";
			Query query = em.createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			LogUtil.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	public void delete(ProjetEnseignant A) {
		ProjetEnseignant ch;
		ch = em.merge(A);
		em.remove(ch);
	}

	@Override
	public void update(ProjetEnseignant A) {
		em.merge(A);
	}

	@Override
	public List<ProjetEnseignant> findAll1(int matriculeEnseigant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjetEnseignant> findAllByYearSemestre(int semestre,
			String promotion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjetEnseignant> findAllBySemestre(int semestre,
			String Promotion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjetEnseignantPOJO> findAllByProjet(int refProjet,
			String promotion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjetEnseignant> chargeTotal(int refProjet, String promotion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjetEnseignant> findAllAffEnseig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createEnseignant(Enseignant enseignant) {
		em.persist(enseignant);

	}

	@Override
	public void createProjet(Projet projet) {
		em.persist(projet);

	}

	@Override
	public Enseignant getEnseignantByMat(String matriculeEnseigant) {
		return em.find(Enseignant.class, matriculeEnseigant);

	}

	@Override
	public Projet getProjetByRef(int refProjet) {
		return em.find(Projet.class, refProjet);

	}

	@Override
	public void createAffectation(int semestre, int periode, int volumeHoraire,
			Enseignant enseignant, Projet projet) {
		ProjetEnseignant projetEnseignant = new ProjetEnseignant(semestre,
				periode, volumeHoraire, em.merge(enseignant), em.merge(projet));
		em.persist(projetEnseignant);
	}

}
