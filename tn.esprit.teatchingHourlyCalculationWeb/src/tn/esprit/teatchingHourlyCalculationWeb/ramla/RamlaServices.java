package tn.esprit.teatchingHourlyCalculationWeb.ramla;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.esprit.entity.Enseignant;
import com.esprit.entity.Projet;
import com.esprit.service.gestionAffectationProjet.GestionAffectationProjetEnseignantLocal;
import com.esprit.service.gestionEnseignant.GestionEnseignantLocal;
import com.esprit.service.gestionProjet.GestionProjetLocal;

@ManagedBean
@SessionScoped
public class RamlaServices {
	// the model
	private List<Projet> projets = new ArrayList<Projet>();
	private List<Enseignant> enseignants = new ArrayList<Enseignant>();
	private int hour;
	private int semester;
	private String nameEnseignant;

	private List<SelectItem> selectItemsProjects;
	private int idSelectedProject;

	private List<SelectItem> selectItemsEnseignant;
	private String matSelectedEnseignant;

	// injection of the proxy
	@EJB
	private GestionEnseignantLocal gestionEnseignantLocal;
	@EJB
	private GestionProjetLocal gestionProjetLocal;
	@EJB
	private GestionAffectationProjetEnseignantLocal gestionAffectationProjetEnseignantLocal;

	
	public String doAdd() {
		Projet projetTMP = gestionProjetLocal.findByRef(idSelectedProject);
		Enseignant enseignantTMP = gestionEnseignantLocal
				.findByMat(matSelectedEnseignant);
		System.out.println("good luck ramla ...");
		gestionAffectationProjetEnseignantLocal.createAffectation(semester, 1, hour,
				enseignantTMP, projetTMP);
		nameEnseignant=enseignantTMP.getNom();
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

	
}
