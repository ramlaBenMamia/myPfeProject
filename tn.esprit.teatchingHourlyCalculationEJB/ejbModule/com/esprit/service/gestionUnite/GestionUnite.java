package com.esprit.service.gestionUnite;

import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.esprit.entity.Unite;
import com.log.LogUtil;

@Stateless
public class GestionUnite implements GestionUniteLocal,
		GestionUniteRemote {

	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public void save(Unite entity) {
		LogUtil.log("saving Unite instance", Level.INFO, null);
		try {
			entityManager.persist(entity);
			LogUtil.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			LogUtil.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	
	@Override
	public void delete(Unite entity) {
		LogUtil.log("deleting Unite instance", Level.INFO, null);
		try {
			entity = entityManager.getReference(Unite.class,
					entity.getRefUnite());
			entityManager.remove(entity);
			LogUtil.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			LogUtil.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	
	@Override
	public Unite update(Unite entity) {
		LogUtil.log("updating Unite instance", Level.INFO, null);
		try {
			Unite result = entityManager.merge(entity);
			LogUtil.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			LogUtil.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllUnite() {
		// TODO Auto-generated method stub
		String query = "select libelleUnite from Unite";
		return entityManager.createQuery(query).getResultList();
	}
	

	@Override
	@SuppressWarnings("unchecked")
	public List<Unite> findAll() {
		LogUtil.log("finding all Unite instances", Level.INFO, null);
		try {
			final String queryString = "select model from Unite model";
			Query query = entityManager.createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			LogUtil.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

	

	@Override
	public void removeUnite(Unite e) {
		entityManager.remove(entityManager.merge(e));
	}
	
	
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Unite> findByLibelle(String libelleUnite) {
		return entityManager
				.createQuery(
						"select p from Unite p where p.libelleUnite like :plibelleUnite ")
				.setParameter("plibelleUnite", libelleUnite).getResultList();

	}

	



	@Override
	@SuppressWarnings("unchecked")
	public List<Unite> findByDescription(String description) {
		return entityManager
				.createQuery(
						"select p from Unite p where p.description like :pdescription ")
				.setParameter("pdescription", description).getResultList();
	}



	@Override
	@SuppressWarnings("unchecked")
	public List<Unite> findByMatEnseignant(String matriculeEnseigant) {
		 return entityManager
				 .createQuery(
				 "select e from Unite e where e.enseignant.matriculeEnseigant = :matriculeEnseigant ")
				 .setParameter("matriculeEnseigant", matriculeEnseigant).getResultList();

	}


	@Override
	public Unite findByRef(int ref) {
		return entityManager.find(Unite.class, ref);

		
	}


	@Override
	public void deleteByRef(int ref) {
		entityManager.remove(entityManager.find(Unite.class,ref));
		System.out.println("ok");
		
	}


	

}