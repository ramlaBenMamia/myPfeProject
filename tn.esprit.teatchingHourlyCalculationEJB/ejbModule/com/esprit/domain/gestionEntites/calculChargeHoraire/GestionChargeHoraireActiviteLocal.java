package com.esprit.domain.gestionEntites.calculChargeHoraire;

import java.util.List;

import javax.ejb.Local;

import com.esprit.domain.gestionEntites.IGestionGeneric;
import com.esprit.entity.ChargeHoraireActivite;

@Local
public interface GestionChargeHoraireActiviteLocal extends
		IGestionGeneric<ChargeHoraireActivite> {
	public List<ChargeHoraireActivite> findByRefActivite(int refActivite);

	public List<ChargeHoraireActivite> findByMatEnseignant(
			String matriculeEnseigant);

}
