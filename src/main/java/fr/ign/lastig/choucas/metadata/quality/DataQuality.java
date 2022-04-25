package fr.ign.lastig.choucas.metadata.quality;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.apache.sis.metadata.iso.DefaultIdentifier;
import org.apache.sis.metadata.iso.lineage.DefaultLineage;
import org.apache.sis.metadata.iso.lineage.DefaultSource;
import org.apache.sis.metadata.iso.quality.DefaultDataQuality;
import org.apache.sis.util.SimpleInternationalString;
import org.opengis.metadata.identification.CharacterSet;
import org.opengis.metadata.maintenance.ScopeCode;
import org.opengis.metadata.quality.Element;

import fr.ign.lastig.choucas.metadata.IdentificationInfo.Head;
import fr.ign.lastig.choucas.source.C2C;


public class DataQuality {

	public static DefaultDataQuality getDataQuality(String nomtable) throws Exception {
		
		DefaultDataQuality quality = new DefaultDataQuality();
		
		// Méthode d'évaluation : plus tard
		// element.setEvaluationMethodType(EvaluationMethodType.DIRECT_EXTERNAL);
		
		// confidence
		
		
		// quality.setScope(Head.getScope());
		// quality.setLineage(Head.getLineage(nomtable));
		
		
		Collection<Element> elements = new ArrayList<Element>();
		
		// ----------------------------------------------------------------
		// DQ_AbsoluteExternalPositionalAccuracy
		PositionalAccuracy posAcc = new PositionalAccuracy(47.05, 70.49, 1-0.49);
		//elements.addAll(posAcc.getAbsoluteExternalPositionalAccuracy());
		
		
		// ----------------------------------------------------------------
		// DQ_NonQuantitativeAttributeAccuracy
		ThematicNonQuantitativeAttribute nomAcc = new ThematicNonQuantitativeAttribute(0.048, 0.13, 84.64);
		// elements.addAll(nomAcc.getNonQuantitativeAttributeAccuracy());

		
		// ----------------------------------------------------------------
		// DQ_ThematicClassificationCorrectness
		ThematicClassification typeCorr = new ThematicClassification(0.69);
		elements.addAll(typeCorr.getNonQuantitativeAttributeAccuracy());
		

		// ----------------------------------------------------------------
		// DQ_ThematicClassificationCorrectness_UserAccuracy
		// DQ_ThematicClassificationCorrectness_ProducerAccuracy
		
		
		// ----------------------------------------------------------------
		// DQ_CompletenessCommission	Excedent items
		// DQ_CompletenessOmmission		Missing items
		// DQ_CompletenessCommission	“MissingClass "nom"”
		// DQ_ThematicClassificationCorrectness 	KappaCoefficient

		
		// ----------------------------------------------------------------
		// Duplicate

		
		// ----------------------------------------------------------------
		quality.setReports(elements);
		
		
		
		
		
		return quality;
	}
}
