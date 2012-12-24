package affectationProjEnseignant;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;

import com.esprit.entity.Enseignant;
import com.esprit.entity.Projet;
import com.esprit.entity.ProjetEnseignant;
import com.esprit.service.gestionAffectationProjet.GestionAffectationProjetEnseignantLocal;
import com.esprit.service.gestionEnseignant.GestionEnseignantLocal;
import com.esprit.service.gestionProjet.GestionProjetLocal;

public class AffectationProjetEnseignant {

	private int volumehoraire;

	private int Periode;

	private String projetLib;

	private String matriculeEnseigant;

	private int refProjet;

	private int Semestre;

	private String promotion;

	private Projet projet = new Projet();

	private Enseignant enseignant = new Enseignant();

	private ProjetEnseignant projetEnseignant = new ProjetEnseignant();

	@EJB
	GestionProjetLocal gestionProjetLocal;
	@EJB
	GestionEnseignantLocal gestionEnseignantLocal;
	@EJB
	GestionAffectationProjetEnseignantLocal gestionAffectationProjetEnseignantLocal;

	public AffectationProjetEnseignant() {
	}

	// --------------------------- Ajout Affectation Module
	// --------------------------

	public String ajouterAffectation() {

		return "ok";
	}

	// --------------------------------------------------------------------------------------------------

	// ------------------------------- Suppression row Data affectation module
	// ----------------------------

	public int getVolumehoraire() {
		return volumehoraire;
	}

	public void setVolumehoraire(int volumehoraire) {
		this.volumehoraire = volumehoraire;
	}

	// ------------------------------- -------------------------------------

	// -------------------------------list de
	// projet-------------------------------------

	// ---------------------------- Fonction Reset : initialiser le formulaire

	public String getMatriculeEnseigant() {
		return matriculeEnseigant;
	}

	public void setMatriculeEnseigant(String matriculeEnseigant) {
		this.matriculeEnseigant = matriculeEnseigant;
	}

	public int getRefProjet() {
		return refProjet;
	}

	public void setRefProjet(int refProjet) {
		this.refProjet = refProjet;
	}

	public void reset() {

	}

	// ---------------------------------------------------------------------------------

	public String getCurrentDat() {

		Date maDateAvecFormat = new Date();
		SimpleDateFormat dateStandard = new SimpleDateFormat("dd/MM/yyyy");
		dateStandard.applyPattern("yyyy/MM/dd");
		return dateStandard.format(maDateAvecFormat);

	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public int getPeriode() {
		return Periode;
	}

	public void setPeriode(int periode) {
		Periode = periode;
	}

	public String getProjetLib() {
		return projetLib;
	}

	public void setProjetLib(String projetLib) {
		this.projetLib = projetLib;
	}

	public int getSemestre() {
		return Semestre;
	}

	public void setSemestre(int semestre) {
		Semestre = semestre;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public ProjetEnseignant getProjetEnseignant() {
		return projetEnseignant;
	}

	public void setProjetEnseignant(ProjetEnseignant projetEnseignant) {
		this.projetEnseignant = projetEnseignant;
	}

	public GestionProjetLocal getGestionProjetLocal() {
		return gestionProjetLocal;
	}

	public void setGestionProjetLocal(GestionProjetLocal gestionProjetLocal) {
		this.gestionProjetLocal = gestionProjetLocal;
	}

	public GestionEnseignantLocal getGestionEnseignantLocal() {
		return gestionEnseignantLocal;
	}

	public void setGestionEnseignantLocal(
			GestionEnseignantLocal gestionEnseignantLocal) {
		this.gestionEnseignantLocal = gestionEnseignantLocal;
	}

	public GestionAffectationProjetEnseignantLocal getGestionAffectationProjetEnseignantLocal() {
		return gestionAffectationProjetEnseignantLocal;
	}

	public void setGestionAffectationProjetEnseignantLocal(
			GestionAffectationProjetEnseignantLocal gestionAffectationProjetEnseignantLocal) {
		this.gestionAffectationProjetEnseignantLocal = gestionAffectationProjetEnseignantLocal;
	}

}