package fr.ign.lastig.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.opengis.referencing.ReferenceSystem;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.crs.ProjectedCRS;



public class TestReadSrs {
	
public static void main(String[] args) throws Exception {
		
		//getting the xml file to read
		String filename = TestReadExtent.class.getResource("srs.xml").getFile();
	    File file = new File(filename);
	    
	    // creating the JAXB context
	    JAXBContext jContext = JAXBContext.newInstance(ProjectedCRS.class);
	    
	    //creating the unmarshall object
	    Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
	    
	    //calling the unmarshall method
	    ProjectedCRS srs = (ProjectedCRS) unmarshallerObj.unmarshal(file);
	    System.out.println(srs);
	    
	    
	}

}
