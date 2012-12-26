package com.esprit.service.gestionEnseignant;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.esprit.entity.ChargeHoraireProjet;
import com.esprit.entity.Enseignant;
import com.log.LogUtil;

@Stateless
public class GestionEnseignant implements GestionEnseignantLocal,
		GestionEnseignantRemote {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Enseignant entity) {
		LogUtil.log("saving Enseignant instance", Level.INFO, null);
		try {
			entityManager.persist(entity);
			LogUtil.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			LogUtil.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	public void delete(Enseignant entity) {
		LogUtil.log("deleting Enseignant instance", Level.INFO, null);
		try {
			entity = entityManager.getReference(Enseignant.class,
					entity.getCin());
			entityManager.remove(entity);
			LogUtil.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			LogUtil.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	public Enseignant update(Enseignant entity) {
		LogUtil.log("updating Enseignant instance", Level.INFO, null);
		try {
			Enseignant result = entityManager.merge(entity);
			LogUtil.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			LogUtil.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	public Enseignant findByMat(String mat) {
		LogUtil.log("finding Enseignant instance with matricule: " + mat,
				Level.INFO, null);
		try {
			Enseignant instance = entityManager.find(Enseignant.class, mat);
			return instance;
		} catch (RuntimeException re) {
			LogUtil.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enseignant> findByProperty(String propertyName,
			final Object value) {
		LogUtil.log("finding Enseignant instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Enseignant model where model."
					+ propertyName + "= :propertyValue";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			LogUtil.log("find by property name failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enseignant> findAll() {
		LogUtil.log("finding all Enseignant instances", Level.INFO, null);
		try {
			final String queryString = "select model from Enseignant model";
			Query query = entityManager.createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			LogUtil.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

	@Override
	public Enseignant findByUser(String login, String pwd) {
		String query = "select u from User u where u.login='" + login
				+ "' and u.password='" + pwd + "'";
		System.out.println(query);
		Enseignant u = new Enseignant();
		u = (Enseignant) entityManager.createQuery(query).getResultList()
				.get(0);
		return u;
	}

	@Override
	public void removeEnseignant(Enseignant e) {
		entityManager.remove(entityManager.merge(e));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enseignant> findByNomPrenom(String nom, String prenom) {
		return entityManager
				.createQuery(
						"select e from Enseignant e where e.nom like :enom and e.prenom like :eprenom ")
				.setParameter("enom", nom).setParameter("eprenom", prenom)
				.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enseignant> findByLoginPwd(String login, String password) {
		return entityManager
				.createQuery(
						"select e from Enseignant e where e.login like :elogin and e.password like :epassword ")
				.setParameter("elogin", login)
				.setParameter("epassword", password).getResultList();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enseignant> findByNom(String nom) {
		return entityManager
				.createQuery(
						"select e from Enseignant e where e.nom like :enom ")
				.setParameter("enom", nom).getResultList();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enseignant> findByRefProjet(int refProjet) {
		return entityManager
				.createQuery(
						"select e from Enseignant e where e.projet.refProjet = :refProjet ")
				.setParameter("refProjet", refProjet).getResultList();

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enseignant> findByNomProjet(String libelleProjet) {
		return entityManager
				.createQuery(
						"select e from Enseignant e where e.projet.libelleProjet = :libelleProjet ")
				.setParameter("libelleProjet", libelleProjet).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enseignant> findByRefActivite(int refActivite) {
		return entityManager
				.createQuery(
						"select e from Enseignant e where e.activite.refActivite = :refActivite ")
				.setParameter("refActivite", refActivite).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enseignant> findByNomActivite(String nomActivite) {
		return entityManager
				.createQuery(
						"select e from Enseignant e where e.activite.nomActivite = :nomActivite ")
				.setParameter("nomActivite", nomActivite).getResultList();
	}

	@Override
	public void deleteByMat(String mat) {
		entityManager.remove(entityManager.find(Enseignant.class, mat));

	}

	@Override
	public List<String> findAllEnseignant() {
		String query = "select nom from Enseignant";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public int volumeHoraireTotalParEnseignant(String matEnseignant) {
		int total = 0;
		List<ChargeHoraireProjet> chargeHoraireProjets = new ArrayList<ChargeHoraireProjet>();
		String jpql = "select c from ChargeHoraireProjet c where c.enseignant.matriculeEnseigant=:param1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", matEnseignant);
		chargeHoraireProjets = query.getResultList();

		for (ChargeHoraireProjet ch : chargeHoraireProjets) {
			total += ch.getNbrHeures();
		}

		return total;

	}

}