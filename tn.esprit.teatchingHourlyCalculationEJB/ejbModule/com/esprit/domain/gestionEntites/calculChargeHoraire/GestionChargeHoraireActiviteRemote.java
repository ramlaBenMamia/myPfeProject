package com.esprit.domain.gestionEntites.calculChargeHoraire;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.domain.gestionEntites.IGestionGeneric;
import com.esprit.entity.ChargeHoraireActivite;

@Remote
public interface GestionChargeHoraireActiviteRemote extends
		IGestionGeneric<ChargeHoraireActivite> {
	public List<ChargeHoraireActivite> findByRefActivite(int refActivite);

	public List<ChargeHoraireActivite> findByMatEnseignant(
			String matriculeEnseigant);

}
