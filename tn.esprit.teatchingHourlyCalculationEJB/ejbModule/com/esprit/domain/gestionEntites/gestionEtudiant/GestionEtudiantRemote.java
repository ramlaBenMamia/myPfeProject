package com.esprit.domain.gestionEntites.gestionEtudiant;

import javax.ejb.Remote;

import com.esprit.domain.gestionEntites.IGestionGenerique;
import com.esprit.entity.Etudiant;

@Remote
public interface GestionEtudiantRemote extends IGestionGenerique<Etudiant>{

}
