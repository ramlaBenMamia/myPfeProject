package tn.esprit.teatchingHourlyCalculationClient.test;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.esprit.entity.Activite;
import com.esprit.entity.Enseignant;
import com.esprit.entity.Projet;
import com.esprit.service.gestionActivite.GestionActiviteRemote;
import com.esprit.service.gestionAffectationActivite.GestionAffectationActiviteEnseignantRemote;
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

			GestionAffectationActiviteEnseignantRemote gestionAffActiviteEnseigRemote = (GestionAffectationActiviteEnseignantRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionAffectationActiviteEnseignant!com.esprit.service.gestionAffectationActivite.GestionAffectationActiviteEnseignantRemote");
			
			GestionActiviteRemote gestionActiviteRemote = (GestionActiviteRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionChargeHoraireActivite!com.esprit.domain.gestionEntites.calculChargeHoraire.GestionChargeHoraireActiviteRemote");
			
			Enseignant enseignant = gestionEnseignantRemote.findByMat("mat02");
			Projet projet = gestionProjetRemote.findByRef(1);
			
			Activite activite=gestionActiviteRemote.findByRef(1);
			
			gestionAffActiviteEnseigRemote.createAffectationActivite(1, 11, 24, enseignant, activite);
			gestionAffProjEnseigRemote.createAffectation(1, 11, 22,null,enseignant,
					projet);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
