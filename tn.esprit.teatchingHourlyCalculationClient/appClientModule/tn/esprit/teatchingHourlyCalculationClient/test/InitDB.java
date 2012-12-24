package tn.esprit.teatchingHourlyCalculationClient.test;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.esprit.entity.Enseignant;
import com.esprit.entity.Projet;
import com.esprit.service.gestionEnseignant.GestionEnseignantRemote;
import com.esprit.service.gestionProjet.GestionProjetRemote;

public class InitDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			GestionEnseignantRemote gestionEnseignantRemote = (GestionEnseignantRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionEnseignant!com.esprit.service.gestionEnseignant.GestionEnseignantRemote");
			GestionProjetRemote gestionProjetRemote = (GestionProjetRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionProjet!com.esprit.service.gestionProjet.GestionProjetRemote");

			Enseignant enseignant = new Enseignant();
			enseignant.setMatriculeEnseigant("mat02");
			enseignant.setNom("ramla");
			enseignant.setCin(0123456);
			enseignant.setCodePostal(2013);
			enseignant.setPrivilege(1);
			enseignant.setNumTelephone(98989898);

			gestionEnseignantRemote.save(enseignant);

			Projet projet = new Projet();
			projet.setLibelleProjet("proj01");
			projet.setDescription("description");

			gestionProjetRemote.addProject(projet);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
