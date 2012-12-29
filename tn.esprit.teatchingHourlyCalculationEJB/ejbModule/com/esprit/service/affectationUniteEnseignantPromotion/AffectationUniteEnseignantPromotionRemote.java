package com.esprit.service.affectationUniteEnseignantPromotion;

import javax.ejb.Remote;

import com.esprit.entity.Enseignant;
import com.esprit.entity.Promotion;
import com.esprit.entity.Unite;

@Remote
public interface AffectationUniteEnseignantPromotionRemote {
	public void createEnseignant(Enseignant enseignant);

	public void createUnite(Unite unite);

	public void createPromotion(Promotion promotion);

	public Enseignant getEnseignantByMat(String matriculeEnseigant);

	public Unite getUniteByRef(int refUnite);

	public Promotion getPromotionById(int idPromotion);

	public void createAffectationEPU(Enseignant enseignant,
			Promotion promotion, Unite unite);

}
