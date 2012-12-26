package com.esprit.service.gestionLocal;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.entity.Locale;

@Remote
public interface GestionLocaleRemote {

	public void createLocal(Locale c);

	public List<Locale> findAll();

	public List<String> findAllLocal();

	public int findNombreUnite(int id);

	public Locale findByLibelle(String libelle);
}
