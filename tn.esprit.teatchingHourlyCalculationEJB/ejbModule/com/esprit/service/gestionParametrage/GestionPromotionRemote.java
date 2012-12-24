package com.esprit.service.gestionParametrage;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.entity.Promotion;

@Remote
public interface GestionPromotionRemote {

	public void addPromotion(Promotion P);
	public List<Promotion> findAll();
	Promotion findById(int id);
}
