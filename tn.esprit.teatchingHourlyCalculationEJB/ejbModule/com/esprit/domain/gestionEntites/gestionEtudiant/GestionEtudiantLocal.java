package com.esprit.domain.gestionEntites.gestionEtudiant;

import javax.ejb.Local;

import com.esprit.domain.gestionEntites.IGestionGenerique;
import com.esprit.entity.Etudiant;

@Local
public interface GestionEtudiantLocal extends IGestionGenerique<Etudiant>{

}
