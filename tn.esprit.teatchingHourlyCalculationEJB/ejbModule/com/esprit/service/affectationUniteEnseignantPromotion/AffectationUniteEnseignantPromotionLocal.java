package com.esprit.service.affectationUniteEnseignantPromotion;

import java.util.List;

import javax.ejb.Local;

import com.esprit.entity.Enseignant;
import com.esprit.entity.Promotion;
import com.esprit.entity.Unite;
import com.esprit.entity.UniteEnseignantPromotion;

@Local
public interface AffectationUniteEnseignantPromotionLocal {
	public void createEnseignant(Enseignant enseignant);

	public void createUnite(Unite unite);

	public void createPromotion(Promotion promotion);

	public Enseignant getEnseignantByMat(String matriculeEnseigant);

	public Unite getUniteByRef(int refUnite);

	public Promotion getPromotionById(int idPromotion);

	public void createAffectationEPU(Enseignant enseignant,
			Promotion promotion, Unite unite);

	public List<UniteEnseignantPromotion> findAllByNomEnseignant(
			String nomEnseignant);

	public List<UniteEnseignantPromotion> findAllByNomUnite(String nomUnite);

	public List<UniteEnseignantPromotion> findAllByNomPromotion(
			String nomPromotion);

}
