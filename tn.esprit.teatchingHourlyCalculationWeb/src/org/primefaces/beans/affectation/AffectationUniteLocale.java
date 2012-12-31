package org.primefaces.beans.affectation;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.esprit.entity.Locale;
import com.esprit.entity.Unite;
import com.esprit.service.gestionLocal.GestionLocaleLocal;
import com.esprit.service.gestionUnite.GestionUniteLocal;

@ManagedBean
@SessionScoped
public class AffectationUniteLocale {
	@EJB
	GestionUniteLocal gestionUniteLocal;
	@EJB
	GestionLocaleLocal gestionLocaleLocal;

	private List<SelectItem> items;
	private int selectedLocalId;

	private Unite unite = new Unite();
	private Locale locale = new Locale();
	private List<Locale> locales = new ArrayList<Locale>();

	public String doAdd() {
		unite.setLocale(gestionLocaleLocal.findLocaleById(selectedLocalId));
		gestionUniteLocal.save(unite);
		reset();
		return "";
	}
	
	public void reset(){
		unite = new Unite();
		unite.setNomChefProjet("");
		unite.setNomUnite("");
		unite.setDescription("");
		unite.setLocal("");
	}

	public GestionUniteLocal getGestionUniteLocal() {
		return gestionUniteLocal;
	}

	public void setGestionUniteLocal(GestionUniteLocal gestionUniteLocal) {
		this.gestionUniteLocal = gestionUniteLocal;
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

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
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

}
