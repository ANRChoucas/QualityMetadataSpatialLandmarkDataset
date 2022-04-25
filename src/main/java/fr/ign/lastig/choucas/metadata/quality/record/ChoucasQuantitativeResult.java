package fr.ign.lastig.choucas.metadata.quality.record;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.sis.metadata.iso.quality.AbstractResult;
import org.opengis.metadata.quality.QuantitativeResult;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ChoucasQuantitativeResult { // extends AbstractResult implements QuantitativeResult {
	
	private String language;
    private int age;

    public ChoucasQuantitativeResult() {}

    public ChoucasQuantitativeResult(String language, int age) {
        this.language = language;
        this.age = age;
    }
	
	
}
