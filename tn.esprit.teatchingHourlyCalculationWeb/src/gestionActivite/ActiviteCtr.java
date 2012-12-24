package gestionActivite;

import javax.ejb.EJB;

import com.esprit.domain.gestionEntites.gestionActivite.GestionActiviteLocal;
import com.esprit.entity.Activite;

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
