package com.esprit.service.gestionParametrage;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.entity.Promotion;

/**
 * Session Bean implementation class GestionPromotion
 */
@Stateless
public class GestionPromotion implements GestionPromotionRemote,
		GestionPromotionLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager em;

	public GestionPromotion() {
		// TODO Auto-generated constructor stub
	}

	public void addPromotion(Promotion P) {
		em.persist(P);

	}

	@SuppressWarnings("unchecked")
	public List<Promotion> findAll() {
		return em.createQuery("from Promotion").getResultList();

	}

	public Promotion findById(int id) {
		return em.find(Promotion.class, id);

	}

	public void update(Promotion P) {
		em.merge(P);

	}

	@SuppressWarnings("unchecked")
	public List<Promotion> findByAnnee(String anneeUniv) {

		return em
				.createQuery(
						"select p from Promotion p where p.promotion like :anneeUniv ")
				.setParameter("anneeUniv", anneeUniv).getResultList();
	}

}
