package tn.esprit.teatchingHourlyCalculationWeb.ramla;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.esprit.domain.gestionEntites.calculChargeHoraire.GestionChargeHoraireProjetLocal;
import com.esprit.entity.ChargeHoraireProjet;
import com.esprit.entity.Enseignant;
import com.esprit.entity.Projet;
import com.esprit.entity.ProjetEnseignant;
import com.esprit.service.gestionAffectationProjet.GestionAffectationProjetEnseignantLocal;
import com.esprit.service.gestionEnseignant.GestionEnseignantLocal;
import com.esprit.service.gestionProjet.GestionProjetLocal;

@ManagedBean
@SessionScoped
public class AffectationProjetBean {
	// the model
	private List<Projet> projets = new ArrayList<Projet>();
	private List<Enseignant> enseignants = new ArrayList<Enseignant>();
	private int hour;
	private int semester;
	private String nameEnseignant;	
	private String nomEnseignantSelect;

	private List<SelectItem> selectItemsProjects;
	private int idSelectedProject;

	private List<SelectItem> selectItemsEnseignant;
	private String matSelectedEnseignant;

	private int i = 0;

	// ************************ affichage par enseignant ********************
	private List<ProjetEnseignant> listeParEnseignants;

	// injection of the proxy
	@EJB
	private GestionEnseignantLocal gestionEnseignantLocal;
	@EJB
	private GestionProjetLocal gestionProjetLocal;
	@EJB
	private GestionAffectationProjetEnseignantLocal gestionAffectationProjetEnseignantLocal;
	@EJB
	private GestionChargeHoraireProjetLocal gestionChargeHoraireProjetLocal;

	public String doAdd() {
		Projet projetTMP = gestionProjetLocal.findByRef(idSelectedProject);
		Enseignant enseignantTMP = gestionEnseignantLocal
				.findByMat(matSelectedEnseignant);
		System.out.println("good luck ramla ...");
		gestionAffectationProjetEnseignantLocal.createAffectation(semester, 1,
				hour, enseignantTMP, projetTMP);
		nameEnseignant = enseignantTMP.getNom();

		// *********************** calcule de charge
		// ****************************

		int nbrHeure = 0;
		ChargeHoraireProjet chargeHoraireProjet = new ChargeHoraireProjet();

		chargeHoraireProjet.setNbrHeures(nbrHeure + getHour());
		chargeHoraireProjet.setEnseignant(enseignantTMP);
		gestionChargeHoraireProjetLocal.add(chargeHoraireProjet);
		i++;

		// int nbrHeure;
		// int nbrHeureSupp;
		// String matriculeEnseigant = listEnseignants.get(0)
		// .getMatriculeEnseigant();
		// ChargeHoraireProjet chargeHoraireProjet = new ChargeHoraireProjet();

		// List<ChargeHoraireProjet> chargeHoraireProjets = new
		// ArrayList<ChargeHoraireProjet>();

		// recherche dans la table projEns selon la matricule

		// chargeHoraireProjets = gestionChargeHoraireProjetLocal
		// .findByMatEnseignant(matriculeEnseigant);

		// if (chargeHoraireProjets.size() == 0)
		//
		// {
		//
		// nbrHeure = 0;
		// nbrHeureSupp = 0;
		//
		// // ChargeHoraireProjet chargeHoraireProjet = new
		// // ChargeHoraireProjet();
		//
		// chargeHoraireProjet.setNbrHeures(nbrHeure + getHour());
		// chargeHoraireProjet.setNbrHeuresSupp(nbrHeureSupp);
		// chargeHoraireProjet.setEnseignant(listEnseignants.get(0));
		//
		// System.out.println("aaaaaaaaaaaaa" + getHour());
		//
		// System.out.println("bbbbbbbbbbbbb"
		// + listEnseignants.get(0).getMatriculeEnseigant());
		//
		// gestionChargeHoraireProjetLocal.add(chargeHoraireProjet);
		//
		// }
		//
		// else {
		//
		// i = chargeHoraireProjets.size() - 1;
		//
		// // *************recuperer le nbr des heures deja existants dans la
		// // table chargehoraireprojet
		//
		// nbrHeure = chargeHoraireProjets.get(i).getNbrHeures();
		//
		// chargeHoraireProjet.setNbrHeures(nbrHeure + getHour());
		// System.out.println("sssssssssss" + nbrHeure + getHour());
		//
		// chargeHoraireProjet.setEnseignant(listEnseignants.get(0));
		//
		// gestionChargeHoraireProjetLocal.update(chargeHoraireProjet);
		// i++;
		//
		// }
		return "ok";
	}

	public String updateDataTable() {
		nomEnseignantSelect=gestionEnseignantLocal.findByMat(nameEnseignant).getNom();
		listeParEnseignants = gestionAffectationProjetEnseignantLocal
				.findAllByNomEnsei(nomEnseignantSelect);
		return "";
	}

	public List<Projet> getProjets() {

		return gestionProjetLocal.findAll();
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	public List<Enseignant> getEnseignants() {
		return gestionEnseignantLocal.findAll();
	}

	public void setEnseignants(List<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	public List<SelectItem> getSelectItemsProjects() {
		selectItemsProjects = new ArrayList<SelectItem>();
		projets = gestionProjetLocal.findAll();
		selectItemsProjects.add(new SelectItem(-1, "please select one ..."));
		for (Projet p : projets) {
			selectItemsProjects.add(new SelectItem(p.getRefProjet(), p
					.getLibelleProjet()));
		}

		return selectItemsProjects;
	}

	public void setSelectItemsProjects(List<SelectItem> selectItemsProjects) {
		this.selectItemsProjects = selectItemsProjects;
	}

	public int getIdSelectedProject() {
		return idSelectedProject;
	}

	public void setIdSelectedProject(int idSelectedProject) {
		this.idSelectedProject = idSelectedProject;
	}

	public List<SelectItem> getSelectItemsEnseignant() {
		selectItemsEnseignant = new ArrayList<SelectItem>();
		enseignants = gestionEnseignantLocal.findAll();
		selectItemsEnseignant.add(new SelectItem(-1, "please"));
		for (Enseignant e : enseignants) {
			selectItemsEnseignant.add(new SelectItem(e.getMatriculeEnseigant(),
					e.getNom()));
		}
		return selectItemsEnseignant;
	}

	public void setSelectItemsEnseignant(List<SelectItem> selectItemsEnseignant) {
		this.selectItemsEnseignant = selectItemsEnseignant;
	}

	public String getMatSelectedEnseignant() {

		return matSelectedEnseignant;
	}

	public void setMatSelectedEnseignant(String matSelectedEnseignant) {
		this.matSelectedEnseignant = matSelectedEnseignant;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getNameEnseignant() {
		return nameEnseignant;
	}

	public void setNameEnseignant(String nameEnseignant) {
		this.nameEnseignant = nameEnseignant;
	}

	// ************* affichage par enseignant************
	public List<ProjetEnseignant> getListeParEnseignants() {
		
		return listeParEnseignants;
	}

	public void setListeParEnseignants(
			List<ProjetEnseignant> listeParEnseignants) {
		this.listeParEnseignants = listeParEnseignants;
	}

	public void recupererdataModelProjet() {
		List<Enseignant> listEnseignants;
		listEnseignants = gestionEnseignantLocal.findByNom(getNameEnseignant());

		String matriculeEnseigant = listEnseignants.get(0)
				.getMatriculeEnseigant();

		List<Projet> projets = gestionProjetLocal
				.findByMatEnseignant(matriculeEnseigant);

		if (selectItemsProjects == null) {
			selectItemsProjects = new ArrayList<SelectItem>();
		} else
			selectItemsProjects.clear();
		for (Projet c : projets) {
			selectItemsProjects.add(new SelectItem(c.getLibelleProjet()));
		}

	}

	public String getNomEnseignantSelect() {		
		return nomEnseignantSelect;
	}

	public void setNomEnseignantSelect(String nomEnseignantSelect) {
		this.nomEnseignantSelect = nomEnseignantSelect;
	}

}
