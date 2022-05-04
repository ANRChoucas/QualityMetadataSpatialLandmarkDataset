package fr.ign.lastig.choucas.alignment;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.File;
import java.util.Iterator;

import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;

public class AlignBDTopo {

	public static String getURI(String typeBDTopo) {
		
		if (typeBDTopo.contentEquals("Passage à niveau")) return "http";
		if (typeBDTopo.contentEquals("Espace public")) return "http";
		if (typeBDTopo.contentEquals("Point d'eau")) return "http";
		if (typeBDTopo.contentEquals("Point de vue")) return "http";
		if (typeBDTopo.contentEquals("")) return "http";
		if (typeBDTopo.contentEquals("http")) return "http";
		
		try {
			File fileC2C = new File("./data/alignment/Alignment_POI_BDTOPO_OOR.csv");
			try (CsvReader csv = CsvReader.builder()
					.fieldSeparator(',')
					.quoteCharacter('"')
					.build(fileC2C.toPath(), UTF_8)) {
				
				for (final Iterator<CsvRow> iterator = csv.iterator(); iterator.hasNext();) {
					final CsvRow csvRow = iterator.next();
				
					if (csvRow.getFields().size() < 2)
						continue;
				
					if (csvRow.getField(0).equals("type"))
						continue;
					
					String type= csvRow.getField(0);
					String uri = csvRow.getField(1);
					
					if (type.equals(typeBDTopo)) {
						return uri;
					}
				}
				
			}
		
		} catch (Exception e) {
    		e.printStackTrace();
    	}
			
		return null;
	}
}
