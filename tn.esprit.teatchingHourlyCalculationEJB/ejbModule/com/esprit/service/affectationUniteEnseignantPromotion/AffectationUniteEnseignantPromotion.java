package com.esprit.service.affectationUniteEnseignantPromotion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.entity.Enseignant;
import com.esprit.entity.Promotion;
import com.esprit.entity.Unite;
import com.esprit.entity.UniteEnseignantPromotion;

/**
 * Session Bean implementation class AffectationUniteEnseignantPromotion
 */
@Stateless
@LocalBean
public class AffectationUniteEnseignantPromotion implements
		AffectationUniteEnseignantPromotionRemote,
		AffectationUniteEnseignantPromotionLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public AffectationUniteEnseignantPromotion() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createEnseignant(Enseignant enseignant) {
		entityManager.persist(enseignant);

	}

	@Override
	public void createUnite(Unite unite) {
		entityManager.persist(unite);

	}

	@Override
	public void createPromotion(Promotion promotion) {
		entityManager.persist(promotion);

	}

	@Override
	public Enseignant getEnseignantByMat(String matriculeEnseigant) {
		return entityManager.find(Enseignant.class, matriculeEnseigant);

	}

	@Override
	public Unite getUniteByRef(int refUnite) {
		return entityManager.find(Unite.class, refUnite);

	}

	@Override
	public Promotion getPromotionById(int idPromotion) {
		return entityManager.find(Promotion.class, idPromotion);

	}

	@Override
	public void createAffectationEPU(Enseignant enseignant,
			Promotion promotion, Unite unite) {
		UniteEnseignantPromotion uniteEnseignantPromotion = new UniteEnseignantPromotion(
				entityManager.merge(enseignant), entityManager.merge(unite),
				entityManager.merge(promotion));
		entityManager.persist(uniteEnseignantPromotion);
		
	}
}
