package fr.ign.lastig.choucas;

import java.util.ArrayList;
import java.util.List;

import fr.ign.cogit.appariement.AppariementDST;
import fr.ign.cogit.appariement.Feature;
import fr.ign.cogit.appariement.LigneResultat;
import fr.ign.cogit.appli.ExportToCSV;
import fr.ign.cogit.appli.TableauResultatFrame;
import fr.ign.cogit.criteria.Critere;
import fr.ign.cogit.criteria.CritereGeom;
import fr.ign.cogit.criteria.CritereSemantique;
import fr.ign.cogit.criteria.CritereToponymique;
import fr.ign.cogit.distance.geom.DistanceEuclidienne;
import fr.ign.cogit.distance.semantique.DistanceWuPalmer;
import fr.ign.cogit.distance.text.DistanceSamal;
import fr.ign.lastig.choucas.loader.LoaderBDTopo;
import fr.ign.lastig.choucas.loader.LoaderC2C;


/**
 * 
 * @author marie-dominique
 */
public class MainMatchingCamptocampBdtopo {
    
	private static final double DISTANCE_FILTRE_CANDIDAT = 300;
    
    public static void main(String[] args) {
        
        // ----------------------------------------------------------------
        //  Configuration de l'appariement
        AppariementDST evidenceAlgoFusionCritere = new AppariementDST();
        evidenceAlgoFusionCritere.setSeuilIndecision(0.15);

        // ----------------------------------------------------------------
        //  Configuration des critères
        List<Critere> listCritere = new ArrayList<Critere>();
    
        // Critere géométrique
        DistanceEuclidienne ddh = new DistanceEuclidienne();
        CritereGeom cg = new CritereGeom(ddh);
        // cg.setSeuil(50, 200);
        // cg.setSeuil(100, 200);
        listCritere.add(cg);
        System.out.println("Critère géométrique = " + cg.getSeuil());
        
        DistanceSamal ds = new DistanceSamal();
        // DistanceLevenshtein ds = new DistanceLevenshtein();
        CritereToponymique ct = new CritereToponymique(ds);
        ct.setSeuil(0.60);
        listCritere.add(ct);
        System.out.println("Critère toponymique = " + ct.getSeuil());
        
        // Critère sémantique
        DistanceWuPalmer dwp = new DistanceWuPalmer("/home/marie-dominique/CHOUCAS/OOR/oor_V1.0.1_01102021_MDVD.owl");
        CritereSemantique cs = new CritereSemantique(dwp);
        cs.setSeuil(0.7);
        listCritere.add(cs);
        System.out.println("Critère sémantique = " + cs.getSeuil());
        
        evidenceAlgoFusionCritere.setListCritere(listCritere);
        
        // ----------------------------------------------------------------
        //   On charge les jeux de données
    	
    	List<Feature> popComp = LoaderC2C.getToponyme();
    	System.out.println("Nb feature C2C = " + popComp.size());
    	
    	List<Feature> popRef = LoaderBDTopo.getToponyme();
    	System.out.println("Nb feature IGN = " + popRef.size());
    	
        // ----------------------------------------------------------------
        //    Appariement
        
        // Liste des résultats d'appariement:
        List<LigneResultat> listeRes = new ArrayList<LigneResultat>();
        int nbSansCandidat = 0;
        
        // Boucle sur chaque itinéraire de C2C
        int cpt = 1;
        for (Feature c2c : popComp) {
        	
        	if (!c2c.getAttribute("id").equals("144923"))
        			continue;
        	//if (!c2c.getAttribute("id").equals("144923") && !c2c.getAttribute("id").equals("43030") 
        	//		&& !c2c.getAttribute("id").equals("926012"))
        	//	continue;
        	
        	// On filtre les candidats
            List<Feature> candidatListe = new ArrayList<Feature>();
            for (Feature ign : popRef) {
                if (ign.getGeom().buffer(DISTANCE_FILTRE_CANDIDAT).intersects(c2c.getGeom())) {
                	candidatListe.add(ign);
                }
            }
            System.out.println("Nb candidat (" + cpt + ") : " + candidatListe.size());

            int nb = candidatListe.size();
            if (nb > 0) {
                try {
                    List<LigneResultat> lres = evidenceAlgoFusionCritere.appariementObjet(c2c, candidatListe);
                    listeRes.addAll(lres);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                nbSansCandidat++;
            }
            
            // break;
            cpt++;
        }
        
        TableauResultatFrame tableauPanel = new TableauResultatFrame();
        tableauPanel.displayEnsFrame("Appariement [1 - 2]", listeRes);
        int[] tab = tableauPanel.analyse();
        
        System.out.println("");
        
        System.out.println("Nb feature c2c = " + popComp.size());
        System.out.println("Nb feature ign = " + popRef.size());
        
        System.out.println("");
        
        System.out.println("NB non-app : " + tab[0]);
        System.out.println("NB app : " + tab[1]);
        System.out.println("NB d'indécis : " + tab[2]);
        System.out.println("NB sans candidat : " + nbSansCandidat);
        
        ExportToCSV.exportAppariement(listCritere, 
        		evidenceAlgoFusionCritere.getSeuilIndecision(),
        		listeRes, "./data/resultat/c2c-bdtopo-");
        
        System.out.println("");
        System.out.println("===========================    Fin    ===========================");
    }
    
}
