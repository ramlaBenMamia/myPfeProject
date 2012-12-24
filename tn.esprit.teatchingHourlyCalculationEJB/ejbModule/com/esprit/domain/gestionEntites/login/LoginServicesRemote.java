package com.esprit.domain.gestionEntites.login;

import javax.ejb.Remote;

@Remote
public interface LoginServicesRemote {
	public int signIn(String login, String password);
}
