package fr.ign.lastig.choucas.metadata.IdentificationInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.sis.metadata.iso.extent.DefaultExtent;
import org.apache.sis.metadata.iso.extent.DefaultGeographicBoundingBox;
import org.apache.sis.metadata.iso.extent.DefaultTemporalExtent;
import org.apache.sis.metadata.iso.lineage.DefaultLineage;
import org.apache.sis.metadata.iso.lineage.DefaultSource;
import org.apache.sis.util.iso.SimpleInternationalString;

import static java.util.Collections.singleton;



public class Head {
	
	public static DefaultExtent getExtent() throws Exception {
		DefaultExtent scope = new DefaultExtent("CHOUCAS study Area", getGeoExtent(), null, getTempExtent());
		scope.setGeographicElements(singleton(getGeoExtent()));
		return scope;
	}
	
	private static DefaultGeographicBoundingBox getGeoExtent() {
		DefaultGeographicBoundingBox boundsZE   = new DefaultGeographicBoundingBox(5.052012623758622, 6.646212874998972, 
				44.485172355531574, 45.2721268277652);
		return boundsZE;
	}
	
	private static DefaultTemporalExtent getTempExtent() throws Exception {
		DefaultTemporalExtent temporal = new DefaultTemporalExtent();
		
		String sDate1 = "01/10/2021";
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		
		String sDate2 = "28/02/2022";
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
		
		// temporal.setBounds(date1, date2);
		return temporal;
	}
	
	
	
	public static DefaultLineage getLineage(String datasetsource) {
		DefaultLineage lineage = new DefaultLineage();
		DefaultSource source = new DefaultSource();
		if (datasetsource.contentEquals("app_refinfos_ign")) {
			
		} else if (datasetsource.contentEquals("app_c2c_ign")) {
			source.setDescription(new SimpleInternationalString("Camptocamp (C2C) est un projet collaboratif auquel\" \n" + 
					"			+ \" participe des pratiquants plutôt avertis des sports de montagne.\\n\" \n" + 
					"			+ \" La saisie des objets de repère se fait via une application web\" \n" + 
					"			+ \" par les contributeurs avec leurs propres outils de gestion de données\\n\" \n" + 
					"			+ \" et leur propre fond cartographique. L’altitude est saisie\" \n" + 
					"			+ \" par les utilisateurs."));
		}
        
        lineage.getSources().add(source);
        return lineage;
	}

}
