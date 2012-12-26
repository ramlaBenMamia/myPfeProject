package tn.esprit.teatchingHourlyCalculationClient.test;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.esprit.entity.Enseignant;
import com.esprit.service.gestionEnseignant.GestionEnseignantRemote;

public class InitDBEnseignant {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			GestionEnseignantRemote gestionEnseignantRemote = (GestionEnseignantRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionEnseignant!com.esprit.service.gestionEnseignant.GestionEnseignantRemote");

			

			Enseignant enseignant2 = new Enseignant();
			enseignant2.setMatriculeEnseigant("mat06");
			enseignant2.setNom("rourou");
			enseignant2.setCin(0123456);
			enseignant2.setCodePostal(2011);
			enseignant2.setPrivilege(2);
			enseignant2.setNumTelephone(98989887);
			enseignant2.setLogin("a");
			enseignant2.setPassword("a");

			gestionEnseignantRemote.save(enseignant2);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
