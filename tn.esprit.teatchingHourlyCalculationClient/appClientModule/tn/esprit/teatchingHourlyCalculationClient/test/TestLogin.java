package tn.esprit.teatchingHourlyCalculationClient.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.esprit.domain.gestionEntites.login.LoginServicesRemote;

public class TestLogin {

	/**
	 * @param args
	 * @throws NamingException
	 */
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		LoginServicesRemote loginServicesRemote = (LoginServicesRemote) context
				.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/LoginServices!com.esprit.domain.gestionEntites.login.LoginServicesRemote");
		System.out.println(loginServicesRemote.signIn("a", "a"));

	}

}
