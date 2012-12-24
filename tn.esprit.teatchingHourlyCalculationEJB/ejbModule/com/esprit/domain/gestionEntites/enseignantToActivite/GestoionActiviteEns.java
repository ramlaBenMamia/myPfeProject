package com.esprit.domain.gestionEntites.enseignantToActivite;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.entity.ActiviteEnseignant;

/**
 * Session Bean implementation class GestoionPrEns
 */
@Stateless
public class GestoionActiviteEns implements GestoionActiviteEnsRemote,
		GestoionActiviteEnsLocal {

	@PersistenceContext
	EntityManager entityManager;

	public GestoionActiviteEns() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(ActiviteEnseignant activiteEnseignant) {
		entityManager.persist(activiteEnseignant);

	}

	@Override
	public void deleteByRef(int ref) {
		entityManager.remove(entityManager.find(ActiviteEnseignant.class, ref));

	}

	@Override
	public void delete(ActiviteEnseignant t) {
		entityManager.remove(entityManager.find(ActiviteEnseignant.class,
				t.getId()));

	}

	@Override
	public void update(ActiviteEnseignant t) {
		entityManager.merge(t);

	}

	@Override
	public ActiviteEnseignant findByRef(int ref) {
		return entityManager.find(ActiviteEnseignant.class, ref);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActiviteEnseignant> findAll() {

		return entityManager.createQuery("SELECT a from ActiviteEnseignant a")
				.getResultList();
	}

}
