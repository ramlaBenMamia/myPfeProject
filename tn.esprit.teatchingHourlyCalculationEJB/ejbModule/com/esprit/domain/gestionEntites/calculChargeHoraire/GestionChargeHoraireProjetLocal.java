package com.esprit.domain.gestionEntites.calculChargeHoraire;

import java.util.List;

import javax.ejb.Local;

import com.esprit.domain.gestionEntites.IGestionGeneric;
import com.esprit.entity.ChargeHoraireProjet;

@Local
public interface GestionChargeHoraireProjetLocal extends
		IGestionGeneric<ChargeHoraireProjet> {
	public List<ChargeHoraireProjet> findByRefProjet(int refProjet);

	public List<ChargeHoraireProjet> findByMatEnseignant(
			String matriculeEnseigant);

}
