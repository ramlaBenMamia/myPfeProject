package tn.esprit.teatchingHourlyCalculationClient.test;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.esprit.entity.Enseignant;
import com.esprit.entity.Promotion;
import com.esprit.entity.Unite;
import com.esprit.service.affectationUniteEnseignantPromotion.AffectationUniteEnseignantPromotionRemote;
import com.esprit.service.gestionEnseignant.GestionEnseignantRemote;
import com.esprit.service.gestionPromotion.GestionPromotionRemote;
import com.esprit.service.gestionUnite.GestionUniteRemote;

public class TestAffectationUEP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Context context = new InitialContext();
			AffectationUniteEnseignantPromotionRemote affectationUniteEnseignantPromotionRemote = (AffectationUniteEnseignantPromotionRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/AffectationUniteEnseignantPromotion!com.esprit.service.affectationUniteEnseignantPromotion.AffectationUniteEnseignantPromotionRemote");
			GestionEnseignantRemote gestionEnseignantRemote = (GestionEnseignantRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionEnseignant!com.esprit.service.gestionEnseignant.GestionEnseignantRemote");

			GestionPromotionRemote gestionPromotionRemote = (GestionPromotionRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionPromotion!com.esprit.service.gestionPromotion.GestionPromotionRemote");
			GestionUniteRemote gestionUniteRemote = (GestionUniteRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionUnite!com.esprit.service.gestionUnite.GestionUniteRemote");

			Enseignant enseignant = gestionEnseignantRemote.findByMat("mat02");
			Unite unite = gestionUniteRemote.findByRef(1);
			Promotion promotion = gestionPromotionRemote.findById(2);

			affectationUniteEnseignantPromotionRemote.createAffectationEPU(
					enseignant, promotion, unite);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
