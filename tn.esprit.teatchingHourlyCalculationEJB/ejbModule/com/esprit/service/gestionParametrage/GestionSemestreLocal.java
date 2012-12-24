package com.esprit.service.gestionParametrage;

import java.util.List;

import javax.ejb.Local;

import com.esprit.entity.Semestre;

@Local
public interface GestionSemestreLocal {
	public void addSemestre(Semestre S);
	public List<Semestre> findAll();
	Semestre findById(int id);
	public void update(Semestre S);
}
