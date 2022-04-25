package fr.ign.lastig.choucas.metadata.quality;

import static java.util.Collections.singleton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.apache.sis.internal.metadata.RecordSchemaSIS;
import org.apache.sis.measure.Units;
import org.apache.sis.metadata.iso.DefaultIdentifier;
import org.apache.sis.metadata.iso.quality.AbstractElement;
import org.apache.sis.metadata.iso.quality.DefaultQuantitativeResult;
import org.apache.sis.metadata.iso.quality.DefaultThematicClassificationCorrectness;
import org.apache.sis.util.SimpleInternationalString;
import org.apache.sis.util.iso.DefaultRecord;
import org.apache.sis.util.iso.DefaultRecordType;
import org.opengis.metadata.Identifier;

/**
 * 
 *
 */
public class ThematicClassification {
	
	private double overallAccuracy;
	
	public ThematicClassification(double overallAccuracy) {
		this.overallAccuracy = overallAccuracy;
	}
	
	
	public Collection<AbstractElement> getNonQuantitativeAttributeAccuracy() {
		Collection<AbstractElement> typeCorrElements = new ArrayList<AbstractElement>();
		
		// OverallAccuracy
		typeCorrElements.add(this.getOverallAccuracy());
		
		// ConfusionMatrix
		typeCorrElements.add(this.getConfusionMatrix());
		
		
		return typeCorrElements;
	}
	
	
	/**
	 * The overall accuracy is computed as the total
                            number of correctly classified features divided by the total
                            number of features. Only matched features (1:1) are taken into
                            account for the computation.
	 * @return
	 */
	private AbstractElement getOverallAccuracy() {
		
		// 
        AbstractElement element =
                new DefaultThematicClassificationCorrectness();
        
        
        // --------------------------------------------------------------------
        // measureIdentification
        Identifier identifiant = new DefaultIdentifier("http://www.qualityml.org/1.0/metrics/OverallAccuracy");
        element.setMeasureIdentification(identifiant);
        
        
        // --------------------------------------------------------------------
        // nameOfMeasure
        element.setNamesOfMeasure(singleton(new SimpleInternationalString("OverallAccuracy")));
        
        
        // --------------------------------------------------------------------
        DefaultQuantitativeResult result = new DefaultQuantitativeResult();
        
        DefaultRecordType type = RecordSchemaSIS.REAL;
        
        //
        /*
           <qml:OverallAccuracy>
		       <qml:values>0.69</qml:values>
           </qml:OverallAccuracy>
           
         */
        DefaultRecord record = new DefaultRecord(type);
        record.setAll(this.overallAccuracy);
        result.setValues(Collections.singletonList(record));
        
        // <gmd:valueUnit xlink:href="http://www.opengis.net/def/uom/OGC/1.0/unit" />
        result.setValueUnit(Units.UNITY);
        element.setResults(singleton(result));
        
        
        
        return element;
	}
	
	
	
	private AbstractElement getConfusionMatrix() {
		// 
        AbstractElement element =
                new DefaultThematicClassificationCorrectness();
        
        // --------------------------------------------------------------------
        // measureIdentification
        
        
        
        
        // --------------------------------------------------------------------
		return element;
	}
}
