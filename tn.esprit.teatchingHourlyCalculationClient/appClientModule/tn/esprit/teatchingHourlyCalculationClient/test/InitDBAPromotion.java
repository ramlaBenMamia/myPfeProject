package tn.esprit.teatchingHourlyCalculationClient.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.esprit.entity.Activite;
import com.esprit.entity.Promotion;
import com.esprit.service.gestionActivite.GestionActiviteRemote;
import com.esprit.service.gestionPromotion.GestionPromotion;
import com.esprit.service.gestionPromotion.GestionPromotionRemote;

public class InitDBAPromotion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			GestionPromotionRemote gestionPromotionRemote = (GestionPromotionRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionPromotion!com.esprit.service.gestionPromotion.GestionPromotionRemote");

			Promotion promotion = new Promotion();
			promotion.setPromotion("2012/2013");

			gestionPromotionRemote.addPromotion(promotion);
			
			Promotion promotion1 = new Promotion();
			promotion1.setPromotion("2013/2014");

			gestionPromotionRemote.addPromotion(promotion1);
			
			Promotion promotion2 = new Promotion();
			promotion2.setPromotion("2013/2014");

			gestionPromotionRemote.addPromotion(promotion2);
			
			Promotion promotion3 = new Promotion();
			promotion3.setPromotion("2014/2015");

			gestionPromotionRemote.addPromotion(promotion3);
			
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
