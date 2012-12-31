package org.primefaces.beans.affectation;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.esprit.entity.Activite;
import com.esprit.entity.Locale;
import com.esprit.service.gestionActivite.GestionActiviteLocal;
import com.esprit.service.gestionLocal.GestionLocaleLocal;

@ManagedBean
@SessionScoped
public class AffectationActiviteLocale {
	@EJB
	GestionActiviteLocal gestionActiviteLocal;
	@EJB
	GestionLocaleLocal gestionLocaleLocal;

	private List<SelectItem> items;
	private int selectedLocalId;

	private Activite activite = new Activite();
	
	private String libelleActivite;

	private Locale locale = new Locale();
	private List<Locale> locales = new ArrayList<Locale>();

	public String doAdd() {
		activite.setLocale(gestionLocaleLocal.findLocaleById(selectedLocalId));

		gestionActiviteLocal.add(activite);
		return "";
	}

	public GestionActiviteLocal getGestionActiviteLocal() {
		return gestionActiviteLocal;
	}

	public void setGestionActiviteLocal(
			GestionActiviteLocal gestionActiviteLocal) {
		this.gestionActiviteLocal = gestionActiviteLocal;
	}

	public GestionLocaleLocal getGestionLocaleLocal() {
		return gestionLocaleLocal;
	}

	public void setGestionLocaleLocal(GestionLocaleLocal gestionLocaleLocal) {
		this.gestionLocaleLocal = gestionLocaleLocal;
	}

	public List<SelectItem> getItems() {
		items = new ArrayList<SelectItem>();
		locales = gestionLocaleLocal.findAll();
		items.add(new SelectItem(-1, "select one..."));
		for (Locale s : locales)
			items.add(new SelectItem(s.getId(), s.getLibelleLocal()));
		return items;
	}

	public void setItems(List<SelectItem> items) {
		this.items = items;
	}

	public int getSelectedLocalId() {
		return selectedLocalId;
	}

	public void setSelectedLocalId(int selectedLocalId) {
		this.selectedLocalId = selectedLocalId;
	}

	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public List<Locale> getLocales() {
		locales = gestionLocaleLocal.findAll();
		return locales;
	}

	public void setLocales(List<Locale> locales) {
		this.locales = locales;
	}
	
	public String getLibelleActivite() {
		return libelleActivite;
	}

	public void setLibelleActivite(String libelleActivite) {
		this.libelleActivite = libelleActivite;
	}

}
