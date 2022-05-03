package fr.ign.lastig.choucas.metadata.IdentificationInfo;

import static java.util.Collections.singleton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.opengis.metadata.spatial.SpatialRepresentationType;
import org.apache.sis.metadata.iso.DefaultIdentifier;
import org.apache.sis.metadata.iso.citation.DefaultCitation;
import org.apache.sis.metadata.iso.citation.DefaultCitationDate;
import org.apache.sis.metadata.iso.constraint.DefaultConstraints;


import org.apache.sis.metadata.iso.constraint.DefaultLegalConstraints;
import org.apache.sis.metadata.iso.constraint.DefaultSecurityConstraints;
import org.apache.sis.metadata.iso.extent.DefaultExtent;
import org.apache.sis.metadata.iso.extent.DefaultGeographicDescription;
import org.apache.sis.metadata.iso.identification.DefaultDataIdentification;
import org.apache.sis.metadata.iso.identification.DefaultRepresentativeFraction;
import org.apache.sis.metadata.iso.identification.DefaultResolution;
import org.opengis.metadata.citation.DateType;
import org.opengis.metadata.constraint.Classification;
import org.opengis.metadata.constraint.Restriction;
import org.opengis.metadata.identification.TopicCategory;


public class DataIdentification {
	
	/** IDENTIFICATION. */
	public static DefaultDataIdentification getDataIdentification() throws Exception {
		
		final DefaultCitation citation = new DefaultCitation("Sea Surface Temperature Analysis Model");
		// String sDate1 = "01/10/2021";
		// Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        // citation.setDates(singleton(new DefaultCitationDate(date1, DateType.CREATION)));
        citation.setIdentifiers(singleton(new DefaultIdentifier("SST_Global.nc")));
		
        DefaultDataIdentification info = new DefaultDataIdentification(citation,
                "Global 5.0 x 2.5 degree model data", null, TopicCategory.LOCATION);
        
        
        // spatialRepresentationType
        // info.setSpatialRepresentationTypes(singleton(SpatialRepresentationType.VECTOR));
        
        
        // Extent
        info.setExtents(singleton(Head.getExtent()));
        
		
		
		// MD_LegalConstraints
//		DefaultLegalConstraints lc = new DefaultLegalConstraints();
//		lc.setUseLimitations(Arrays.asList(new SimpleInternationalString("CC by-sa"), new SimpleInternationalString("odbl")));
//		lc.setAccessConstraints(singleton(Restriction.LICENSE));
//		lc.setUseConstraints(singleton(Restriction.OTHER_RESTRICTIONS));
//		lc.setOtherConstraints(singleton(new SimpleInternationalString("Le contenu collaboratif coordonnées géographiques est sous double licence "
//				+ " CC by-sa et Open Database Licence.")));
		// https://opendatacommons.org/licenses/odbl/
		// https://creativecommons.org/licenses/by-sa/3.0/fr/

		
		// MD_SecurityConstraints
		// DefaultSecurityConstraints sc = new DefaultSecurityConstraints();
		// sc.setClassification(Classification.UNCLASSIFIED);
		
		
		// Contraintes
		// di.setResourceConstraints(Arrays.asList(lc, sc));
		
		
		
		

		
		// spatialResolution
//		DefaultRepresentativeFraction fraction = new DefaultRepresentativeFraction(1000);
//		DefaultResolution resolution = new DefaultResolution();
//		resolution.setEquivalentScale(fraction);
//		di.setSpatialResolutions(singleton(resolution));
		
		
		
		
		return info;
	}
	
	
	/** EXTENT */
	/*public static DefaultExtent getExtent() {
		
		// France
		DefaultGeographicDescription descFrance = new DefaultGeographicDescription();
		DefaultIdentifier giFrance = new DefaultIdentifier();
		giFrance.setCode("France");
		descFrance.setGeographicIdentifier(giFrance);
		
		// Suisse
		DefaultGeographicDescription descSuisse = new DefaultGeographicDescription();
		DefaultIdentifier giSuisse = new DefaultIdentifier();
		giSuisse.setCode("Suisse");
		descSuisse.setGeographicIdentifier(giSuisse);
		
		// Espagne
		DefaultGeographicDescription descEspagne = new DefaultGeographicDescription();
		DefaultIdentifier giEspagne = new DefaultIdentifier();
		giEspagne.setCode("Suisse");
		descEspagne.setGeographicIdentifier(giEspagne);
		
		// Italie
		DefaultGeographicDescription descItalie = new DefaultGeographicDescription();
		DefaultIdentifier giItalie = new DefaultIdentifier();
		giItalie.setCode("Italie");
		descItalie.setGeographicIdentifier(giItalie);
		
		DefaultExtent ex = new DefaultExtent();
		ex.setGeographicElements(Arrays.asList(descFrance, descSuisse, descEspagne, descItalie));
		
		return ex;
	}*/

}
