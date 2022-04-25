package fr.ign.lastig.choucas;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.sis.metadata.iso.DefaultMetadata;
// import org.apache.sis.xml.MarshallerPool;
// import org.apache.sis.xml.XML;

import fr.ign.lastig.choucas.metadata.Metadata;


public class MainMetadataChoucas {
	public static void main(String[] args) {
		try {
		
			// ALL - C2C
			DefaultMetadata metadata = Metadata.createMetadata("app_refinfos_ign");
			
			// System.out.println(XML.marshal(metadata));
			/*
			final MarshallerPool pool = getMarshallerPool();
	        final Marshaller marshaller = pool.acquireMarshaller();
	        marshaller.setProperty(XML.METADATA_VERSION, metadataVersion);
	        final String xml = marshal(marshaller, object);
	        pool.recycle(marshaller);
	        */
			
			JAXBContext jaxbContext = JAXBContext.newInstance(DefaultMetadata.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    jaxbMarshaller.marshal(metadata, System.out);
		    
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
