package com.esprit.domain.gestionEntites.login;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class LoginServices
 */
@Stateless
public class LoginServices implements LoginServicesRemote, LoginServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public LoginServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int signIn(String login, String password) {
		int retour = 0;
		String jpql = "select e from Enseignant e where e.login=:param1 and e.password=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try {
			Object object = query.getSingleResult();
			retour = 1;
		} catch (Exception e) {
			retour = 0;
		}

		return retour;
	}

}
