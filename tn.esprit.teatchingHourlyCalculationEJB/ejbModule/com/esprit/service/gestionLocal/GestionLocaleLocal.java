package com.esprit.service.gestionLocal;

import java.util.List;

import javax.ejb.Local;

import com.esprit.entity.Locale;

@Local
public interface GestionLocaleLocal {

	public void createLocal(Locale c);

	public List<Locale> findAll();

	public List<String> findAllLocal();

	public int findNombreUnite(int id);

	public Locale findByLibelle(String libelle);

	public Locale findLocaleById(int id);

}
