package fr.ign.lastig.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.sis.metadata.iso.quality.DefaultDataQuality;

public class TestWriteQuality1 {

	public static void main(String[] args) {
		try {
			
			
			String filename = TestReadExtent.class.getResource("quality1.xml").getFile();
		    File file = new File(filename);
		    
		    // creating the JAXB context
		    JAXBContext jContext = JAXBContext.newInstance(DefaultDataQuality.class);
		    
		    // creating the unmarshall object
		    Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
		    
		 // ====================================================================================
		    
		    //calling the unmarshall method
		    DefaultDataQuality quality = (DefaultDataQuality) unmarshallerObj.unmarshal(file);
		    
		    // ====================================================================================
		    
		    
		    JAXBContext jaxbContext = JAXBContext.newInstance(DefaultDataQuality.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    jaxbMarshaller.marshal(quality, System.out);
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
