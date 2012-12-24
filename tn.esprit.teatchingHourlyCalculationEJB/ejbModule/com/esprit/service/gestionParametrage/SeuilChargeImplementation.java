package com.esprit.service.gestionParametrage;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.entity.SeuilCharge;

/**
 * Session Bean implementation class SeuilChargeImplementation
 */
@Stateless
public class SeuilChargeImplementation implements
		SeuilChargeImplementationRemote, SeuilChargeImplementationLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager em;

	public SeuilChargeImplementation() {
		// TODO Auto-generated constructor stub
	}

	public void update(SeuilCharge S) {
		em.merge(S);

	}

	public void addSeuilCharge(SeuilCharge S) {
		em.persist(S);
	}

	@SuppressWarnings("unchecked")
	public List<SeuilCharge> findAll() {

		return em.createQuery("from SeuilCharge").getResultList();

	}

	public SeuilCharge findById(int id) {
		return em.find(SeuilCharge.class, id);

	}

}
