package org.primefaces.beans.gestionActivite;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.esprit.service.gestionActivite.GestionActiviteLocal;
import com.esprit.entity.Activite;
@ManagedBean
@SessionScoped
public class ActiviteCtr {
	private Activite activite = new Activite();
	private String libelleActivite;

	@EJB
	GestionActiviteLocal gestionActiviteLocal;

	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}
	
	public String doAddActivite() {
		gestionActiviteLocal.add(activite);
		return "";
	}

	public String getLibelleActivite() {
		return libelleActivite;
	}

	public void setLibelleActivite(String libelleActivite) {
		this.libelleActivite = libelleActivite;
	}
}
