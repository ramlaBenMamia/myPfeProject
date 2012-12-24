package org.primefaces.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.esprit.entity.Periode;
import com.esprit.entity.Promotion;
import com.esprit.entity.Semestre;
import com.esprit.entity.SeuilCharge;
import com.esprit.service.gestionParametrage.GestionPeriodeLocal;
import com.esprit.service.gestionParametrage.GestionPromotionLocal;
import com.esprit.service.gestionParametrage.GestionSemestreLocal;
import com.esprit.service.gestionParametrage.SeuilChargeImplementationLocal;

@ManagedBean(name = "parametrageControlleur")
@SessionScoped
public class ParametrageControlleur {
private Periode periode = new Periode();
private Semestre semestre = new Semestre();
private Promotion promo =  new Promotion();
private int semestreLibelle;
private SeuilCharge seuilCharge =  new SeuilCharge();
public SeuilCharge getSeuilCharge() {
	return seuilCharge;
}

public void setSeuilCharge(SeuilCharge seuilCharge) {
	this.seuilCharge = seuilCharge;
}
private String anneeUniv ;
private int idSemes;
private List<SelectItem>  promotionElements;
public ParametrageControlleur(){}
@EJB 
GestionPeriodeLocal gestionPeriodeLocal;
@EJB 
GestionSemestreLocal gestionSemestreLocal;
@EJB 
GestionPromotionLocal gestionPromotionLocal;
@EJB
SeuilChargeImplementationLocal chargeImplementationLocal;

public void addPeriode(ActionEvent actionEvent) 
{
	

gestionPeriodeLocal.addPeriode(periode);
FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"add", "with success !"));					

}

public void addSemestre(ActionEvent actionEvent)
{
	
	promo.setIdPromotion(1);
	semestre.setPromotion(promo);
	gestionSemestreLocal.addSemestre(semestre);
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"add", "with success !"));					

	
}

public void addPromotion(ActionEvent actionEvent) 
{

	
	gestionPromotionLocal.addPromotion(promo);
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"add", "with success !"));					
	
	
}
public void addSeuil(ActionEvent actionEvent) 
{

	
	chargeImplementationLocal.addSeuilCharge(seuilCharge); 
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"add", "with success !"));					

	
}

public void updateSeuil(ActionEvent actionEvent) 
{

	seuilCharge.setIdSeuil(1);
	chargeImplementationLocal.update(seuilCharge); 
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"add", "with success !"));					

	
}



public Periode getPeriode() {
	return periode;
}


public void setPeriode(Periode periode) {
	this.periode = periode;
}


public Semestre getSemestre() {
	return semestre;
}


public void setSemestre(Semestre semestre) {
	this.semestre = semestre;
}

public int getIdSemes() {
	return idSemes;
}

public void setIdSemes(int idSemes) {
	this.idSemes = idSemes;
}

public Promotion getPromo() {
	return promo;
}

public void setPromo(Promotion promotion) {
	this.promo = promotion;
}

public String getAnneeUniv() {
	return anneeUniv;
}

public void setAnneeUniv(String anneeUniv) {
	this.anneeUniv = anneeUniv;
}

public List<SelectItem> getPromotionElements() {
	List<Promotion> promotions = gestionPromotionLocal.findAll();

	if (promotionElements == null) {
		promotionElements = new ArrayList<SelectItem>();
		for (Promotion p : promotions) {
			promotionElements.add(new SelectItem(p.getPromotion()));
		}
	}
	return promotionElements;
}

public void setPromotionElements(List<SelectItem> promotionElements) {
	this.promotionElements = promotionElements;
}

public int getSemestreLibelle() {
	return semestreLibelle;
}

private int numeroPeriode ;
public int getNumeroPeriode() {
	return numeroPeriode;
}

private int idSemestre ;

public void setNumeroPeriode(int numeroPeriode) {
	this.numeroPeriode = numeroPeriode;
}

public void setSemestreLibelle(int semestreLibelle) {
	this.semestreLibelle = semestreLibelle;
}

public int getIdSemestre() {
	return idSemestre;
}

public void setIdSemestre(int idSemestre) {
	this.idSemestre = idSemestre;
}

}
