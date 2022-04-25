package fr.ign.lastig.choucas.metadata.quality.record;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;



public class Test {

	public static void main(String[] args) {

		try {
			ChoucasQuantitativeResult metadata = new ChoucasQuantitativeResult("java", 2);
			
			JAXBContext context = JAXBContext.newInstance(ChoucasQuantitativeResult.class);
			
			Marshaller marshaller = context.createMarshaller();
	        marshaller.marshal(metadata, System.out);

	        //Unmarshaller unmarshaller = this.context.createUnmarshaller();
	        //Object unmarshalled = unmarshaller.unmarshal(new File("duke.xml"));
	        
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
