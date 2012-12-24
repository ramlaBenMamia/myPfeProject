package com.esprit.service.gestionParametrage;

import java.util.List;

import javax.ejb.Local;

import com.esprit.entity.SeuilCharge;

@Local
public interface SeuilChargeImplementationLocal {


	public void addSeuilCharge(SeuilCharge S);
	public List<SeuilCharge> findAll();
	SeuilCharge findById(int id);
	public void update(SeuilCharge S);
}
