package fr.ign.lastig.choucas.metadata.quality;

import static java.util.Collections.singleton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.apache.sis.internal.metadata.RecordSchemaSIS;
import org.apache.sis.measure.Units;
import org.apache.sis.metadata.iso.DefaultIdentifier;
import org.apache.sis.metadata.iso.quality.AbstractElement;
import org.apache.sis.metadata.iso.quality.DefaultNonQuantitativeAttributeAccuracy;
import org.apache.sis.metadata.iso.quality.DefaultQuantitativeResult;
import org.apache.sis.util.SimpleInternationalString;
import org.apache.sis.util.iso.DefaultRecord;
import org.apache.sis.util.iso.DefaultRecordType;
import org.opengis.metadata.Identifier;

public class ThematicNonQuantitativeAttribute {
	
	private double meanNomSamal;
	private double varNomSamal;
	private double txAccordNomSamal;

	public ThematicNonQuantitativeAttribute(double meanNomSamal, double varNomSamal, double txAccordNomSamal) {
		this.meanNomSamal = meanNomSamal;
		this.varNomSamal = varNomSamal;
		this.txAccordNomSamal = txAccordNomSamal;
	}
	
	public Collection<AbstractElement> getNonQuantitativeAttributeAccuracy() {
		Collection<AbstractElement> nomAccElements = new ArrayList<AbstractElement>();
		
		// MeanAbsolute2D
		nomAccElements.add(this.getMeanDistanceSamal());
		
		return nomAccElements;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private AbstractElement getMeanDistanceSamal() {
		
		// 
        AbstractElement element =
                new DefaultNonQuantitativeAttributeAccuracy();
        
        // --------------------------------------------------------------------
        // measureIdentification
        Identifier identifiant = new DefaultIdentifier("http://www.qualityml.org/1.0/metrics/MeanAbsolute2D");
        element.setMeasureIdentification(identifiant);
        
        // --------------------------------------------------------------------
        // nameOfMeasure
        element.setNamesOfMeasure(singleton(new SimpleInternationalString("MeanAbsolute2D")));
        
        
        // --------------------------------------------------------------------
        DefaultQuantitativeResult result = new DefaultQuantitativeResult();
        
        DefaultRecordType type = RecordSchemaSIS.REAL;
        DefaultRecord record = new DefaultRecord(type);
        record.setAll(this.meanNomSamal);
        result.setValues(Collections.singletonList(record));
        // final UnitFormat f = new UnitFormat(Locale.UK);
        // f.setStyle(UnitFormat.Style.UCUM);
        result.setValueUnit(Units.METRE);
        element.setResults(singleton(result));
        
        // --------------------------------------------------------------------
        return element;
	}
}
