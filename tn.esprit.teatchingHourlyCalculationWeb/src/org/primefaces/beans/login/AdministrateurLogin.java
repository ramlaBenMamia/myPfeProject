package org.primefaces.beans.login;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.esprit.domain.gestionEntites.login.LoginServicesLocal;
import com.esprit.entity.Enseignant;

@ManagedBean
@SessionScoped
public class AdministrateurLogin {

	private String login;
	private String pwd;
	private Enseignant userSession;

	@EJB
	private LoginServicesLocal loginServicesLocal;

	public boolean isLoggedIn() {
		return userSession != null;
	}

	public String doLogin() {
		String retour = "";
		if (loginServicesLocal.signIn(login, pwd) == 1) {
			retour = "ok";
		} else {
			retour = "ko";
		}
		System.out.println(retour);
		return retour;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public static final String AUTH_KEY = "app.enseignant.nom";

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.remove(AUTH_KEY);
		return "logout";
	}

}
