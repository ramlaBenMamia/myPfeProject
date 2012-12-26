package com.esprit.service.gestionLocal;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.entity.Locale;

/**
 * Session Bean implementation class GestionClasse
 */
@Stateless
public class GestionLocale implements GestionLocaleRemote, GestionLocaleLocal {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void createLocal(Locale c) {
		entityManager.persist(entityManager.merge(c));

	}

	@Override
	public List<Locale> findAll() {
		String query = "select c from Locale c";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public List<String> findAllLocal() {
		String query = "select libelleLocal from Locale";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public int findNombreUnite(int id) {
		String query = "select nombreUnites from Locale where id=" + id;
		return entityManager.createQuery(query).executeUpdate();
	}

	@Override
	public Locale findByLibelle(String libelle) {
		String query = "from Locale where libelleLocal='" + libelle + "'";
		return (Locale) entityManager.createQuery(query).getSingleResult();
	}

	@Override
	public Locale findLocaleById(int id) {
		return entityManager.find(Locale.class, id);

	}

}
