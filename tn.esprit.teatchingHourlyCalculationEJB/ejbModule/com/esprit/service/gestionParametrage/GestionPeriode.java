package com.esprit.service.gestionParametrage;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.entity.Periode;

/**
 * Session Bean implementation class GestionPeriode
 */
@Stateless
public class GestionPeriode implements GestionPeriodeRemote,
		GestionPeriodeLocal {

	/**
	 * Default constructor.
	 */

	@PersistenceContext
	EntityManager em;

	public GestionPeriode() {
	}

	public void addPeriode(Periode P) {
		em.persist(P);

	}

	@SuppressWarnings("unchecked")
	public List<Periode> findAll() {
		return em.createQuery("from Periode ").getResultList();
	}

	public Periode findById(int id) {
		return em.find(Periode.class, id);
	}

	public void update(Periode P)

	{
		em.merge(P);
	}

}
