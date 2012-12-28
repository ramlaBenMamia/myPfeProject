package tn.esprit.teatchingHourlyCalculationClient.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.esprit.entity.Activite;
import com.esprit.service.gestionActivite.GestionActiviteRemote;

public class InitDBActivite {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			GestionActiviteRemote gestionActiviteRemote = (GestionActiviteRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionActivite!com.esprit.service.gestionActivite.GestionActiviteRemote");

			Activite activite = new Activite();
			activite.setLibelleActivite("activite01");
			activite.setDescription("desc");

			gestionActiviteRemote.addActivite(activite);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
