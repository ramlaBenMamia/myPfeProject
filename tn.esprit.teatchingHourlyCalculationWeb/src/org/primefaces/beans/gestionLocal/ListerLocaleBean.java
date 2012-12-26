package org.primefaces.beans.gestionLocal;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.esprit.entity.Locale;
import com.esprit.service.gestionLocal.GestionLocaleLocal;
@ManagedBean
@SessionScoped
public class ListerLocaleBean {

	@EJB
	GestionLocaleLocal bean;
	List<String> locals;
	private Locale selectedLocale;
	private Locale modifierLocal = new Locale();

	List<Locale> listeLocales;
	Locale locale;

	String newLibelle;
	int newNombre;

	/**
	 * @return the newLibelle
	 */
	public String getNewLibelle() {
		return newLibelle;
	}

	/**
	 * @param newLibelle
	 *            the newLibelle to set
	 */
	public void setNewLibelle(String newLibelle) {
		this.newLibelle = newLibelle;
	}

	/**
	 * @return the newNombre
	 */
	public int getNewNombre() {
		return newNombre;
	}

	/**
	 * @param newNombre
	 *            the newNombre to set
	 */
	public void setNewNombre(int newNombre) {
		this.newNombre = newNombre;
	}

	/**
	 * @return the locals
	 */
	public List<String> getLocals() {
		locals = bean.findAllLocal();
		return locals;
	}

	/**
	 * @param locals
	 *            the locals to set
	 */
	public void setLocals(List<String> locals) {
		this.locals = locals;
	}

	/**
	 * @return the selectedLocale
	 */
	public Locale getSelectedLocale() {
		return selectedLocale;
	}

	/**
	 * @param selectedLocale
	 *            the selectedLocale to set
	 */
	public void setSelectedLocale(Locale selectedLocale) {
		this.selectedLocale = selectedLocale;
	}

	public Locale getModifierLocale() {
		return modifierLocal;
	}

	public void setModifierLocale(Locale modifierLocal) {
		this.modifierLocal = modifierLocal;
	}

	/**
	 * @return the listeLocales
	 */
	public List<Locale> getListeLocales() {
		listeLocales = bean.findAll();
		return listeLocales;
	}

	/**
	 * @param listeLocales
	 *            the listeLocales to set
	 */
	public void setListeLocales(List<Locale> listeLocales) {
		this.listeLocales = listeLocales;
	}

	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @param locale
	 *            the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public void affiche() {
		modifierLocal = selectedLocale;
		System.out.println(modifierLocal);
	}

}