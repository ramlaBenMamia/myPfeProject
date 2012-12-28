package com.esprit.domain.gestionEntites.calculChargeHoraire;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.entity.ChargeHoraireActivite;

/**
 * Session Bean implementation class GestionActivite
 */
@Stateless
public class GestionChargeHoraireActivite implements
		GestionChargeHoraireActiviteLocal, GestionChargeHoraireActiviteRemote {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void add(ChargeHoraireActivite t) {
		entityManager.persist(t);
	}

	@Override
	public void deleteByRef(int ref) {
		entityManager
				.remove(entityManager.find(ChargeHoraireActivite.class, ref));
	}

	@Override
	public void delete(ChargeHoraireActivite t) {
		entityManager.remove(entityManager.find(ChargeHoraireActivite.class,
				t.getIdCharge()));

	}

	@Override
	public void update(ChargeHoraireActivite t) {
		entityManager.merge(t);

	}

	@Override
	public ChargeHoraireActivite findByRef(int ref) {
		return entityManager.find(ChargeHoraireActivite.class, ref);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChargeHoraireActivite> findAll() {
		return entityManager.createQuery("SELECT a from ChargeHoraireActivite a")
				.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ChargeHoraireActivite> findByMatEnseignant(
			String matriculeEnseigant) {
		return entityManager
				.createQuery(
						"select e from ChargeHoraireActivite e where e.enseignant.matriculeEnseigant = :matriculeEnseigant ")
				.setParameter("matriculeEnseigant", matriculeEnseigant)
				.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ChargeHoraireActivite> findByRefActivite(int refActivite) {
		return entityManager
				.createQuery(
						"select e from ChargeHoraireActivite e where e.activite.refActivite = :refActivite ")
				.setParameter("refActivite", refActivite).getResultList();
	}

}
