package fr.ign.lastig.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.sis.metadata.iso.quality.DefaultDataQuality;
import org.opengis.metadata.quality.Element;
import org.opengis.metadata.quality.Result;

public class TestReadQuality2 {

	public static void main(String[] args) throws Exception {
		String filename = TestReadExtent.class.getResource("quality2.xml").getFile();
	    File file = new File(filename);
	    
	    // creating the JAXB context
	    JAXBContext jContext = JAXBContext.newInstance(DefaultDataQuality.class);
	    
	    // creating the unmarshall object
	    Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
	    
	    //calling the unmarshall method
	    DefaultDataQuality quality = (DefaultDataQuality) unmarshallerObj.unmarshal(file);

	    System.out.println(quality.getReports().size());
	    Element elt = quality.getReports().iterator().next();
	    if (elt.getResults().size() > 0) {
	    	
	    	System.out.println("ici");
	    	Result res = elt.getResults().iterator().next();
	    }
	    // System.out.println(res.)
	}

}
