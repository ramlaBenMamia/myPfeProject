package com.esprit.service.gestionParametrage;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.entity.Periode;

@Remote
public interface GestionPeriodeRemote {
	public void addPeriode(Periode P);
	public List<Periode> findAll();
	Periode findById(int id);
	public void update(Periode P);

}
