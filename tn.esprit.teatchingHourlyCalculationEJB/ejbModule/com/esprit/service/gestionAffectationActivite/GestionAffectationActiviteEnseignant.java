package com.esprit.service.gestionAffectationActivite;

import java.util.List;
import java.util.logging.Level;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.esprit.entity.Activite;
import com.esprit.entity.ActiviteEnseignant;
import com.esprit.entity.ChargeHoraireActivite;
import com.esprit.entity.Enseignant;
import com.log.LogUtil;

/**
 * Session Bean implementation class GestoionPrEns
 */
@Stateless
public class GestionAffectationActiviteEnseignant implements
		GestionAffectationActiviteEnseignantRemote,
		GestionAffectationActiviteEnseignantLocal {

	@PersistenceContext
	EntityManager entityManager;

	public GestionAffectationActiviteEnseignant() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ActiviteEnseignant> findAll() {
		LogUtil.log("finding all ActiviteEnseignant instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Enseignant model";
			Query query = entityManager.createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			LogUtil.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	public void delete(ActiviteEnseignant A) {
		ActiviteEnseignant ch;
		ch = entityManager.merge(A);
		entityManager.remove(ch);

	}

	@Override
	public void update(ActiviteEnseignant A) {
		entityManager.merge(A);

	}

	@Override
	public List<ActiviteEnseignant> findAll1(int matriculeEnseigant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActiviteEnseignant> findAllByYearSemestre(int semestre,
			String promotion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActiviteEnseignant> findAllBySemestre(int semestre,
			String Promotion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActiviteEnseignant> chargeTotal(int refActivite,
			String promotion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActiviteEnseignant> findAllAffEnseig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActiviteEnseignant> findAllByNomEnsei(String nom) {
		return entityManager
				.createQuery(
						"select p from ActiviteEnseignant p where p.enseignant.nom like :pnom ")
				.setParameter("pnom", nom).getResultList();
	}

	@Override
	public void createEnseignant(Enseignant enseignant) {
		entityManager.persist(enseignant);

	}

	@Override
	public void createActivite(Activite activite) {
		entityManager.persist(activite);

	}

	@Override
	public Enseignant getEnseignantByMat(String matriculeEnseigant) {
		return entityManager.find(Enseignant.class, matriculeEnseigant);

	}

	@Override
	public Activite getActiviteByRef(int refActivite) {
		return entityManager.find(Activite.class, refActivite);

	}

	@Override
	public void createAffectationActivite(int semestre, int periode,
			int volumeHoraire, Enseignant enseignant, Activite activite) {
		ActiviteEnseignant activiteEnseignant = new ActiviteEnseignant(
				semestre, periode, volumeHoraire,
				entityManager.merge(enseignant), entityManager.merge(activite));
		entityManager.persist(activiteEnseignant);

		ChargeHoraireActivite chargeHoraireActivite = new ChargeHoraireActivite();
		chargeHoraireActivite.setNbrHeures(volumeHoraire);
		chargeHoraireActivite.setEnseignant(enseignant);
		entityManager.persist(chargeHoraireActivite);

	}

	@Override
	public List<ActiviteEnseignant> findAllByNomActivite(String libelleActivite) {
		return entityManager
				.createQuery(
						"select p from ActiviteEnseignant p where p.activite.libelleActivite like :pnom ")
				.setParameter("pnom", libelleActivite).getResultList();
	}

}
