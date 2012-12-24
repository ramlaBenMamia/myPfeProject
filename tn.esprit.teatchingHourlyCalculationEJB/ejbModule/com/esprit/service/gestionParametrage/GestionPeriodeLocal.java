package com.esprit.service.gestionParametrage;

import java.util.List;

import javax.ejb.Local;

import com.esprit.entity.Periode;


@Local
public interface GestionPeriodeLocal {

	public void addPeriode(Periode P);
	public List<Periode> findAll();
	Periode findById(int id);
	public void update(Periode P);
}
