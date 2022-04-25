package fr.ign.lastig.choucas.metadata.quality;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.apache.sis.internal.metadata.RecordSchemaSIS;
import org.apache.sis.measure.Units;
import org.apache.sis.metadata.iso.DefaultIdentifier;
import org.apache.sis.metadata.iso.quality.AbstractElement;
import org.apache.sis.metadata.iso.quality.DefaultAbsoluteExternalPositionalAccuracy;
import org.apache.sis.metadata.iso.quality.DefaultQuantitativeResult;
import org.apache.sis.util.SimpleInternationalString;
import org.apache.sis.util.iso.DefaultRecord;
import org.apache.sis.util.iso.DefaultRecordType;
import org.opengis.metadata.Identifier;

import static java.util.Collections.singleton;


/**
 * DQ_AbsoluteExternalPositionalAccuracy:
 *     - http://www.qualityml.org/1.0/metrics/MeanAbsolute2D
 *     - http://www.qualityml.org/1.0/metrics/RootMeanSquareError
 *     - Agreement Rate : http://www.qualityml.org/1.0/metrics/items/
 */
public class PositionalAccuracy {
	
	private double meanAbsolute2D;
	private double rootMeanSquareError;
	private double rateAboveGivenThreshold;
	
	public PositionalAccuracy(double meanAbsolute2D, double rootMeanSquareError, double rateAboveGivenThreshold) {
		this.meanAbsolute2D = meanAbsolute2D;
		this.rootMeanSquareError = rootMeanSquareError;
		this.rateAboveGivenThreshold = rateAboveGivenThreshold;
	}
	
	public Collection<AbstractElement> getAbsoluteExternalPositionalAccuracy() {
		Collection<AbstractElement> posAccElements = new ArrayList<AbstractElement>();
		
		// MeanAbsolute2D
        posAccElements.add(this.getMeanAbsolute2D());
        
        // RootMeanSquareError
        posAccElements.add(this.getRootMeanSquareError());
        
        // RateAboveGivenThreshold
        posAccElements.add(this.getRateAboveGivenThreshold());
        
        return posAccElements;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private AbstractElement getMeanAbsolute2D() {
		
		// 
        AbstractElement element =
                new DefaultAbsoluteExternalPositionalAccuracy();

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
        record.setAll(this.meanAbsolute2D);
        result.setValues(Collections.singletonList(record));
        // final UnitFormat f = new UnitFormat(Locale.UK);
        // f.setStyle(UnitFormat.Style.UCUM);
        result.setValueUnit(Units.METRE);
        element.setResults(singleton(result));

        // --------------------------------------------------------------------
        return element;
	}
	
	
	/**
	 * 
	 * @return
	 */
	private AbstractElement getRootMeanSquareError() {
		// 
        AbstractElement element =
                new DefaultAbsoluteExternalPositionalAccuracy();

        // --------------------------------------------------------------------
        // measureIdentification
        Identifier identifiant = new DefaultIdentifier("http://www.qualityml.org/1.0/metrics/RootMeanSquareError");
        element.setMeasureIdentification(identifiant);
        
        // --------------------------------------------------------------------
        // nameOfMeasure
        element.setNamesOfMeasure(singleton(new SimpleInternationalString("RootMeanSquareError")));
        
        
        // --------------------------------------------------------------------
        DefaultQuantitativeResult result = new DefaultQuantitativeResult();
        
        DefaultRecordType type = RecordSchemaSIS.REAL;
        DefaultRecord record = new DefaultRecord(type);
        record.setAll(this.rootMeanSquareError);
        result.setValues(Collections.singletonList(record));
        // final UnitFormat f = new UnitFormat(Locale.UK);
        // f.setStyle(UnitFormat.Style.UCUM);
        result.setValueUnit(Units.METRE);
        element.setResults(singleton(result));

        // --------------------------------------------------------------------
        return element;
	}
	
	
	private AbstractElement getRateAboveGivenThreshold() {
		// 
        AbstractElement element =
                new DefaultAbsoluteExternalPositionalAccuracy();

        // --------------------------------------------------------------------
        // measureIdentification
        Identifier identifiant = new DefaultIdentifier("http://www.qualityml.org/1.0/measure/UncertaintiesAboveGivenThreshold");
        element.setMeasureIdentification(identifiant);
        
        // --------------------------------------------------------------------
        // nameOfMeasure
        element.setNamesOfMeasure(singleton(new SimpleInternationalString("UncertaintiesAboveGivenThreshold")));
        
        
        // --------------------------------------------------------------------
        DefaultQuantitativeResult result = new DefaultQuantitativeResult();
        
        DefaultRecordType type = RecordSchemaSIS.REAL;
        DefaultRecord record = new DefaultRecord(type);
        
        record.setAll(this.rateAboveGivenThreshold);
        result.setValues(Collections.singletonList(record));
        // final UnitFormat f = new UnitFormat(Locale.UK);
        // f.setStyle(UnitFormat.Style.UCUM);
        // result.setValueUnit(Units.METRE);
        element.setResults(singleton(result));
        
        
        // --------------------------------------------------------------------
        return element;
	}
 
}
