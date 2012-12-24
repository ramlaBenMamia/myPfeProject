package com.esprit.service.gestionProjet;

import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.esprit.entity.Projet;
import com.log.LogUtil;

@Stateless
public class GestionProjet implements GestionProjetLocal,
		GestionProjetRemote {

	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public void save(Projet entity) {
		LogUtil.log("saving Projet instance", Level.INFO, null);
		try {
			entityManager.persist(entity);
			LogUtil.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			LogUtil.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	
	@Override
	public void delete(Projet entity) {
		LogUtil.log("deleting Projet instance", Level.INFO, null);
		try {
			entity = entityManager.getReference(Projet.class,
					entity.getRefProjet());
			entityManager.remove(entity);
			LogUtil.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			LogUtil.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	
	@Override
	public Projet update(Projet entity) {
		LogUtil.log("updating Projet instance", Level.INFO, null);
		try {
			Projet result = entityManager.merge(entity);
			LogUtil.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			LogUtil.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	public Projet findById(int refProject) {
		LogUtil.log("finding Projet instance with id: " + refProject, Level.INFO,
				null);
		try {
			Projet instance = entityManager.find(Projet.class, refProject);
			return instance;
		} catch (RuntimeException re) {
			LogUtil.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllProjet() {
		// TODO Auto-generated method stub
		String query = "select libelleProjet from Projet";
		return entityManager.createQuery(query).getResultList();
	}
	

	@Override
	@SuppressWarnings("unchecked")
	public List<Projet> findAll() {
		LogUtil.log("finding all Projet instances", Level.INFO, null);
		try {
			final String queryString = "select model from Projet model";
			Query query = entityManager.createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			LogUtil.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

	

	@Override
	public void removeProjet(Projet e) {
		entityManager.remove(entityManager.merge(e));
	}
	
	
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Projet> findByLibelle(String libelleProjet) {
		return entityManager
				.createQuery(
						"select p from Projet p where p.libelleProjet like :plibelleProjet ")
				.setParameter("plibelleProjet", libelleProjet).getResultList();

	}

	



	@Override
	@SuppressWarnings("unchecked")
	public List<Projet> findByDescription(String description) {
		return entityManager
				.createQuery(
						"select p from Projet p where p.description like :pdescription ")
				.setParameter("pdescription", description).getResultList();
	}



	@Override
	@SuppressWarnings("unchecked")
	public List<Projet> findByMatEnseignant(String matriculeEnseigant) {
		 return entityManager
				 .createQuery(
				 "select e from Projet e where e.enseignant.matriculeEnseigant = :matriculeEnseigant ")
				 .setParameter("matriculeEnseigant", matriculeEnseigant).getResultList();

	}


	@Override
	public Projet findByRef(int ref) {
		return entityManager.find(Projet.class, ref);

		
	}


	@Override
	public void deleteByRef(int ref) {
		entityManager.remove(entityManager.find(Projet.class,ref));
		System.out.println("ok");
		
	}


	@Override
	public void addProject(Projet projet) {
		entityManager.persist(projet);
		
	}


	

}