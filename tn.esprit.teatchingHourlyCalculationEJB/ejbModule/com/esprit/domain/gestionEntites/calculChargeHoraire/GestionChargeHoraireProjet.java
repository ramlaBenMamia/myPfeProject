package com.esprit.domain.gestionEntites.calculChargeHoraire;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.entity.ChargeHoraireProjet;

/**
 * Session Bean implementation class GestionProjet
 */
@Stateless
public class GestionChargeHoraireProjet implements
		GestionChargeHoraireProjetLocal, GestionChargeHoraireProjetRemote {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void add(ChargeHoraireProjet t) {
		entityManager.persist(t);
	}

	@Override
	public void deleteByRef(int ref) {
		entityManager
				.remove(entityManager.find(ChargeHoraireProjet.class, ref));
	}

	@Override
	public void delete(ChargeHoraireProjet t) {
		entityManager.remove(entityManager.find(ChargeHoraireProjet.class,
				t.getIdCharge()));

	}

	@Override
	public void update(ChargeHoraireProjet t) {
		entityManager.merge(t);

	}

	@Override
	public ChargeHoraireProjet findByRef(int ref) {
		return entityManager.find(ChargeHoraireProjet.class, ref);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChargeHoraireProjet> findAll() {
		return entityManager.createQuery("SELECT a from ChargeHoraireProjet a")
				.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ChargeHoraireProjet> findByMatEnseignant(
			String matriculeEnseigant) {
		return entityManager
				.createQuery(
						"select e from ChargeHoraireProjet e where e.enseignant.matriculeEnseigant = :matriculeEnseigant ")
				.setParameter("matriculeEnseigant", matriculeEnseigant)
				.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ChargeHoraireProjet> findByRefProjet(int refProjet) {
		return entityManager
				.createQuery(
						"select e from ChargeHoraireProjet e where e.projet.refProjet = :refProjet ")
				.setParameter("refProjet", refProjet).getResultList();
	}

	// @Override
	// public List<Projet> findByLibelle(String libelleProjet) {
	// return entityManager
	// .createQuery(
	// "select p from Projet p where p.libelleProjet like :plibelleProjet ")
	// .setParameter("plibelleProjet", libelleProjet).getResultList();
	//
	// }

	//
	// @Override
	// public List<Projet> findByDescription(String description) {
	// return entityManager
	// .createQuery(
	// "select p from Projet p where p.description like :pdescription ")
	// .setParameter("pdescription", description).getResultList();
	// }
	//
	//
	//
	// @Override
	// public List<Projet> findByMatEnseignant(String matriculeEnseigant) {
	// return entityManager
	// .createQuery(
	// "select e from Projet e where e.enseignant.matriculeEnseigant = :matriculeEnseigant ")
	// .setParameter("matriculeEnseigant", matriculeEnseigant).getResultList();
	//
	// }

}
