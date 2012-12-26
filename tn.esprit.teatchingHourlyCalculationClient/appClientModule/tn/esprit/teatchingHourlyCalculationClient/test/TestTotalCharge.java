package tn.esprit.teatchingHourlyCalculationClient.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.esprit.entity.ChargeHoraireProjet;
import com.esprit.entity.Enseignant;
import com.esprit.service.gestionEnseignant.GestionEnseignantRemote;

public class TestTotalCharge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Context context;
		try {
			context = new InitialContext();
			GestionEnseignantRemote gestionEnseignantRemote = (GestionEnseignantRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionEnseignant!com.esprit.service.gestionEnseignant.GestionEnseignantRemote");
			
			System.out.println(gestionEnseignantRemote.volumeHoraireTotalParEnseignant("mat02"));
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
