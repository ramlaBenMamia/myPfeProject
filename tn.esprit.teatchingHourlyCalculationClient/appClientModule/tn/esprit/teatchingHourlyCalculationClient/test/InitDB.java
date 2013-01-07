package tn.esprit.teatchingHourlyCalculationClient.test;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.esprit.entity.Activite;
import com.esprit.entity.Enseignant;
import com.esprit.entity.Locale;
import com.esprit.entity.Projet;
import com.esprit.entity.TypeProjet;
import com.esprit.entity.Unite;
import com.esprit.service.gestionActivite.GestionActiviteRemote;
import com.esprit.service.gestionEnseignant.GestionEnseignantRemote;
import com.esprit.service.gestionLocal.GestionLocaleRemote;
import com.esprit.service.gestionProjet.GestionProjetRemote;
import com.esprit.service.gestionTypeProjet.GestionTypeProjetRemote;
import com.esprit.service.gestionUnite.GestionUniteRemote;

public class InitDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			GestionEnseignantRemote gestionEnseignantRemote = (GestionEnseignantRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionEnseignant!com.esprit.service.gestionEnseignant.GestionEnseignantRemote");
			GestionProjetRemote gestionProjetRemote = (GestionProjetRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionProjet!com.esprit.service.gestionProjet.GestionProjetRemote");
			GestionLocaleRemote gestionLocaleRemote = (GestionLocaleRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionLocale!com.esprit.service.gestionLocal.GestionLocaleRemote");

			GestionActiviteRemote gestionActiviteRemote = (GestionActiviteRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionActivite!com.esprit.service.gestionActivite.GestionActiviteRemote");

			GestionUniteRemote gestionUniteRemote = (GestionUniteRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionUnite!com.esprit.service.gestionUnite.GestionUniteRemote");

			GestionTypeProjetRemote gestionTypeProjetRemote = (GestionTypeProjetRemote) context
					.lookup("tn.esprit.teatchingHourlyCalculation/tn.esprit.teatchingHourlyCalculationEJB/GestionTypeProjet!com.esprit.service.gestionTypeProjet.GestionTypeProjetRemote");

			Unite unite = new Unite();
			unite.setNomUnite("mobile");
			unite.setNomChefProjet("ramla");
			gestionUniteRemote.save(unite);

			Unite unite1 = new Unite();
			unite1.setNomUnite("EspritOnLine");
			unite.setNomChefProjet("ihsen");
			gestionUniteRemote.save(unite1);

			Enseignant enseignant = new Enseignant();
			enseignant.setMatriculeEnseigant("mat02");
			enseignant.setNom("Ramla");
			enseignant.setPrenom("Ben Mamia");
			enseignant.setCin(0123456);
			enseignant.setCodePostal(2013);
			enseignant.setPrivilege(1);
			enseignant.setNumTelephone(98989898);
			enseignant.setLogin("ramla");
			enseignant.setPassword("ramla");
			enseignant.setEmail("ramla.benmamia@gmail.com");
			enseignant.setRue("avenue habib bourguiba");

			gestionEnseignantRemote.save(enseignant);
			
			Enseignant enseignant1 = new Enseignant();
			enseignant1.setMatriculeEnseigant("mat03");
			enseignant1.setNom("Ihsen");
			enseignant1.setPrenom("Ben Mamia");
			enseignant1.setEmail("ihsen.benmamia@gmail.com");
			enseignant1.setCin(0123457);
			enseignant1.setCodePostal(2013);
			enseignant1.setPrivilege(1);
			enseignant1.setNumTelephone(98989898);
			enseignant1.setLogin("ihsen");
			enseignant1.setPassword("ihsen");
			enseignant1.setRue("avenue habib bourguiba");

			gestionEnseignantRemote.save(enseignant1);
			
			Enseignant enseignant2 = new Enseignant();
			enseignant2.setMatriculeEnseigant("mat04");
			enseignant2.setNom("Ahmed");
			enseignant2.setPrenom("Ben Mamia");
			enseignant2.setEmail("ahmed.benmamia@gmail.com");
			enseignant2.setCin(0123455);
			enseignant2.setCodePostal(2013);
			enseignant2.setPrivilege(1);
			enseignant2.setNumTelephone(98989898);
			enseignant2.setLogin("ahmed");
			enseignant2.setPassword("ahmed");
			enseignant2.setRue("avenue habib bourguiba");


			gestionEnseignantRemote.save(enseignant2);

			Enseignant enseignant3 = new Enseignant();
			enseignant3.setMatriculeEnseigant("mat05");
			enseignant3.setPrenom("Med ali");
			enseignant3.setNom("Bettaieb");
			enseignant3.setEmail("dali.bettaieb@gmail.com");
			enseignant3.setCin(0123457);
			enseignant3.setCodePostal(2013);
			enseignant3.setPrivilege(1);
			enseignant3.setNumTelephone(98989898);
			enseignant3.setLogin("dali");
			enseignant3.setPassword("dali");
			enseignant3.setRue("avenue habib bourguiba");
			
			gestionEnseignantRemote.save(enseignant3);

			
			
			Projet projet = new Projet();
			projet.setLibelleProjet("proj02");
			projet.setDescription("description");

			gestionProjetRemote.addProject(projet);

			Projet projet1 = new Projet();
			projet1.setLibelleProjet("proj03");
			projet1.setDescription("description");

			gestionProjetRemote.addProject(projet1);
			
			Projet projet2 = new Projet();
			projet2.setLibelleProjet("proj04");
			projet2.setDescription("description");

			gestionProjetRemote.addProject(projet2);
			
			Activite activite = new Activite();
			activite.setLibelleActivite("activite1");
			activite.setDescription("description");

			gestionActiviteRemote.addActivite(activite);

			Activite activite1 = new Activite();
			activite1.setLibelleActivite("activite2");
			activite1.setDescription("description2");

			gestionActiviteRemote.addActivite(activite1);

			Locale locale = new Locale();
			locale.setLibelleLocal("D12");

			gestionLocaleRemote.createLocal(locale);
			Locale locale2 = new Locale();
			locale2.setLibelleLocal("D13");

			gestionLocaleRemote.createLocal(locale2);
			
			
			TypeProjet typeProjet= new TypeProjet();
			typeProjet.setLibelleType("PFE");
			
			gestionTypeProjetRemote.save(typeProjet);
			
			TypeProjet typeProjet1= new TypeProjet();
			typeProjet1.setLibelleType("PFA");
			
			gestionTypeProjetRemote.save(typeProjet1);
			
			TypeProjet typeProjet2= new TypeProjet();
			typeProjet2.setLibelleType("Projet");
			
			gestionTypeProjetRemote.save(typeProjet2);
			
			TypeProjet typeProjet3= new TypeProjet();
			typeProjet3.setLibelleType("Mini Projet");
			
			gestionTypeProjetRemote.save(typeProjet3);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
