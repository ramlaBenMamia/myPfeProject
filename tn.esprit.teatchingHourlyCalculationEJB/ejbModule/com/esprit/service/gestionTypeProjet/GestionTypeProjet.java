package com.esprit.service.gestionTypeProjet;

import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.esprit.entity.TypeProjet;
import com.log.LogUtil;

@Stateless
public class GestionTypeProjet implements GestionTypeProjetLocal,
		GestionTypeProjetRemote {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(TypeProjet entity) {
		LogUtil.log("saving TypeProjet instance", Level.INFO, null);
		try {
			entityManager.persist(entity);
			LogUtil.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			LogUtil.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	public void delete(TypeProjet entity) {
		LogUtil.log("deleting TypeProjet instance", Level.INFO, null);
		try {
			entity = entityManager.getReference(TypeProjet.class,
					entity.getIdType());
			entityManager.remove(entity);
			LogUtil.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			LogUtil.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	public TypeProjet update(TypeProjet entity) {
		LogUtil.log("updating TypeProjet instance", Level.INFO, null);
		try {
			TypeProjet result = entityManager.merge(entity);
			LogUtil.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			LogUtil.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllTypeProjet() {
		// TODO Auto-generated method stub
		String query = "select libelleType from TypeProjet";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TypeProjet> findAll() {
		LogUtil.log("finding all TypeProjet instances", Level.INFO, null);
		try {
			final String queryString = "select model from TypeProjet model";
			Query query = entityManager.createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			LogUtil.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	public void removeTypeProjet(TypeProjet e) {
		entityManager.remove(entityManager.merge(e));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TypeProjet> findByLibelle(String libelleTypeProjet) {
		return entityManager
				.createQuery(
						"select p from TypeProjet p where p.libelleType like :plibelleTypeProjet ")
				.setParameter("plibelleTypeProjet", libelleTypeProjet)
				.getResultList();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TypeProjet> findByMatEnseignant(String matriculeEnseigant) {
		return entityManager
				.createQuery(
						"select e from TypeProjet e where e.enseignant.matriculeEnseigant = :matriculeEnseigant ")
				.setParameter("matriculeEnseigant", matriculeEnseigant)
				.getResultList();

	}

	@Override
	public TypeProjet findById(int id) {
		return entityManager.find(TypeProjet.class, id);

	}

	@Override
	public void deleteById(int id) {
		entityManager.remove(entityManager.find(TypeProjet.class, id));
		System.out.println("ok");

	}

}