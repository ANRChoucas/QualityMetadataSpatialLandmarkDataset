package fr.ign.lastig.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.sis.metadata.iso.quality.DefaultAbsoluteExternalPositionalAccuracy;
import org.apache.sis.metadata.iso.quality.DefaultDataQuality;
import org.apache.sis.xml.XML;


public class TestReadQuality1 {
	
	public static void main(String[] args) throws Exception {
	
		String filename = TestReadExtent.class.getResource("quality1.xml").getFile();
	    File file = new File(filename);
	    
	    // creating the JAXB context
	    JAXBContext jContext = JAXBContext.newInstance(DefaultDataQuality.class);
	    
	    // creating the unmarshall object
	    Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
	    
	    //calling the unmarshall method
	    DefaultDataQuality quality = (DefaultDataQuality) unmarshallerObj.unmarshal(file);
	    
	    System.out.println(quality);
	    System.out.println("-----------------------------");
	    
	    DefaultAbsoluteExternalPositionalAccuracy qual = (DefaultAbsoluteExternalPositionalAccuracy) quality.getReports().iterator().next();
	    System.out.println(qual.asMap()); // .get("namesOfMeasure")
	    
	    // System.out.println("-----------------------------");
	    // System.out.println(XML.marshal(quality));
	    
	}

}
