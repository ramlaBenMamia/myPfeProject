package com.esprit.domain.gestionEntites.login;

import javax.ejb.Local;

@Local
public interface LoginServicesLocal {
	public int signIn(String login, String password);
}
