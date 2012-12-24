package com.esprit.service.gestionParametrage;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.entity.Semestre;

/**
 * Session Bean implementation class GestionSemestre
 */
@Stateless
public class GestionSemestre implements GestionSemestreRemote,
		GestionSemestreLocal {

	/**
	 * Default constructor.
	 */

	@PersistenceContext
	EntityManager em;

	public GestionSemestre() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addSemestre(Semestre S) {
		em.persist(S);

	}

	public void update(Semestre S)

	{
		em.merge(S);
	}

	@SuppressWarnings("unchecked")
	public List<Semestre> findAll() {
		return em.createQuery("from Semestre ").getResultList();
	}

	public Semestre findById(int id) {
		return em.find(Semestre.class, id);
	}

}
