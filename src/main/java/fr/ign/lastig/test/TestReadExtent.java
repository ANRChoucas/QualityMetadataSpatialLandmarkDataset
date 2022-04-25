package fr.ign.lastig.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.sis.metadata.iso.extent.DefaultExtent;
import org.apache.sis.metadata.iso.extent.DefaultGeographicDescription;
import org.opengis.metadata.extent.Extent;
import org.opengis.metadata.extent.GeographicExtent;

public class TestReadExtent {

	public static void main(String[] args) throws Exception {
		
		//getting the xml file to read
		String filename = TestReadExtent.class.getResource("extent.xml").getFile();
	    File file = new File(filename);
	    
	    // creating the JAXB context
	    JAXBContext jContext = JAXBContext.newInstance(DefaultExtent.class);
	    
	    //creating the unmarshall object
	    Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
	    
	    //calling the unmarshall method
	    Extent extent = (Extent) unmarshallerObj.unmarshal(file);
	    
	    System.out.println(extent);
	    
	    GeographicExtent ex = extent.getGeographicElements().iterator().next();
	    DefaultGeographicDescription desc = (DefaultGeographicDescription) ex;
	    System.out.println(desc.getGeographicIdentifier());
	}

}
