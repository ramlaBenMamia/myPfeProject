package com.esprit.domain.gestionEntites.gestionEtudiant;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.entity.Etudiant;

/**
 * Session Bean implementation class GestionEtudiant
 */
@Stateless
public class GestionEtudiant implements GestionEtudiantRemote,
		GestionEtudiantLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public GestionEtudiant() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(Etudiant t) {
		entityManager.persist(t);

	}

	@Override
	public void deleteByMat(String mat) {
		entityManager.remove(entityManager.find(Etudiant.class, mat));

	}

	@Override
	public void update(Etudiant t) {
		entityManager.merge(t);

	}

	@Override
	public Etudiant findByMat(String mat) {
		return entityManager.find(Etudiant.class, mat);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> findAll() {
		return entityManager.createQuery("SELECT e from Etudiant e")
				.getResultList();
	}

	@Override
	public void delete(Etudiant e) {
		entityManager.remove(entityManager.find(Etudiant.class,
				e.getMatricule()));

	}

}
