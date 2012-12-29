package com.esprit.service.gestionPromotion;

import java.util.List;

import javax.ejb.Local;

import com.esprit.entity.Promotion;

@Local
public interface GestionPromotionLocal {

	public void addPromotion(Promotion P);

	public List<Promotion> findAll();

	Promotion findById(int id);

	public List<Promotion> findByAnnee(String anneeUniv);

	public void update(Promotion P);
}
