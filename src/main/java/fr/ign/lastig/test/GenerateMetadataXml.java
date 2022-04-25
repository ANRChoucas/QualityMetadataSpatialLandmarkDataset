package fr.ign.lastig.test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.sis.internal.jaxb.gmi.MI_Metadata;
import org.apache.sis.internal.jaxb.metadata.MD_Metadata;
import org.apache.sis.internal.system.DefaultFactories;
import org.apache.sis.internal.xml.LegacyNamespaces;
import org.apache.sis.metadata.iso.DefaultMetadata;
import org.apache.sis.referencing.factory.sql.EPSGFactory;
import org.apache.sis.xml.Namespaces;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.util.LocalName;
import org.opengis.util.NameFactory;

import fr.ign.lastig.choucas.metadata.Metadata;

import static java.util.Collections.singleton;

/*import org.apache.sis.internal.jaxb.gmi.MI_Metadata;
import org.apache.sis.metadata.iso.citation.DefaultContact;
import org.apache.sis.metadata.iso.citation.DefaultResponsibleParty;
import org.opengis.metadata.Metadata;
import org.opengis.metadata.citation.Contact;
import org.opengis.metadata.identification.CharacterSet;
import org.opengis.metadata.maintenance.ScopeCode;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
*/
 
public class GenerateMetadataXml {
  /*public static void main(String[] args) {
    MI_Metadata mi_Metadata = new MI_Metadata();
    mi_Metadata.setLanguage(Locale.ENGLISH);
    mi_Metadata.setCharacterSet(CharacterSet.UTF_8);
    List scopeCodes = new ArrayList<ScopeCode>();
    scopeCodes.add(ScopeCode.DATASET);
    mi_Metadata.setHierarchyLevels(scopeCodes);
     
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(MI_Metadata.class);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(mi_Metadata, System.out);
      
    } 
    catch (JAXBException e) {
    
    }
  }*/
	
	public static void main(String[] args) {
	    
	    try {
	    	
	    	/*MI_Metadata mi_Metadata = new MI_Metadata();
		    EPSGFactory factory = new EPSGFactory(null);
		    CoordinateReferenceSystem crs = factory.createCoordinateReferenceSystem("3857");
		    mi_Metadata.setReferenceSystemInfo(singleton(crs));*/
	    	
	    	
	    	DefaultMetadata md = Metadata.createMetadata(null);
	    	
	    	
	      // JAXBContext jaxbContext = JAXBContext.newInstance(MI_Metadata.class);
	      JAXBContext jaxbContext = JAXBContext.newInstance(DefaultMetadata.class);
	      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	      jaxbMarshaller.marshal(md, System.out);
	      
	    } catch (Exception e) {
	    }
	  }
	
	/*public static void main(String[] args) {
		  final NameFactory factory = DefaultFactories.forBuildin(NameFactory.class);
	      final LocalName name = factory.createLocalName(null, "A name with & and > and <.");
	      // assertEquals("A name with & and > and <.", name.toString());
	      final String expected =
	              "<gml:IO_IdentifiedObject xmlns:gml=\"" + Namespaces.GML + '"' +
	                                      " xmlns:gco=\"" + LegacyNamespaces.GCO + "\">\n" +
	              "  <gml:alias>\n" +
	              "    <gco:LocalName>A name with &amp; and &gt; and &lt;.</gco:LocalName>\n" +
	              "  </gml:alias>\n" +
	              "</gml:IO_IdentifiedObject>\n";
	      
	      final String actual = marshal(name);
	      // assertXmlEquals(expected, actual, "xmlns:*");
	      // assertEquals(name, unmarshal(expected));
	  }*/
	
	
	/*
	 * 
	 MI_Metadata mi_Metadata = new MI_Metadata();
		    mi_Metadata.setLanguage(Locale.ENGLISH);
		    mi_Metadata.setCharacterSet(CharacterSet.UTF_8);
		    List scopeCodes = new ArrayList<ScopeCode>();
		    scopeCodes.add(ScopeCode.DATASET);
		    mi_Metadata.setHierarchyLevels(scopeCodes);
			
			
			JAXBContext jaxbContext = JAXBContext.newInstance(MI_Metadata.class);
		      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		      jaxbMarshaller.marshal(mi_Metadata, System.out);
	
	 */
}
