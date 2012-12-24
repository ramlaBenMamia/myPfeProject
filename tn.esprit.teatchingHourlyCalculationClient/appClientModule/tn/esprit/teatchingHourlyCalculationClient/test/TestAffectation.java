package tn.esprit.teatchingHourlyCalculationClient.test;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.esprit.entity.Enseignant;
import com.esprit.entity.Projet;
import com.esprit.service.gestionAffectationProjet.GestionAffectationProjetEnseignantRemote;
import com.esprit.service.gestionEnseignant.GestionEnseignantRemote;
import com.esprit.service.gestionProjet.GestionProjetRemote;

public class TestAffectation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Context context = new InitialContext();
			GestionAffectationProjetEnseignantRemote gestionAffProjEnseigRemote = (GestionAffectationProjetEnseignantRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionAffectationProjetEnseignant!com.esprit.service.gestionAffectationProjet.GestionAffectationProjetEnseignantRemote");
			GestionEnseignantRemote gestionEnseignantRemote = (GestionEnseignantRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionEnseignant!com.esprit.service.gestionEnseignant.GestionEnseignantRemote");
			GestionProjetRemote gestionProjetRemote = (GestionProjetRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionProjet!com.esprit.service.gestionProjet.GestionProjetRemote");

			Enseignant enseignant = gestionEnseignantRemote.findByMat("mat01");
			Projet projet = gestionProjetRemote.findByRef(1);

			gestionAffProjEnseigRemote.createAffectation(1, 11, 22, enseignant,
					projet);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
