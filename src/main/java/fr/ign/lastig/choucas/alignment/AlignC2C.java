package fr.ign.lastig.choucas.alignment;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.File;
import java.util.Iterator;

import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;

public class AlignC2C {

	public static String getURI(String typeC2C) {
		
		if (typeC2C.contentEquals("access")) return "http";
		if (typeC2C.contentEquals("waterpoint")) return "http";
		if (typeC2C.contentEquals("webcam")) return "";
		
		
		try {
			File fileC2C = new File("./data/alignment/Alignment_Camptocamp_OOR.csv");
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
					
					if (type.equals(typeC2C)) {
						return uri;
					}
				}
				
			}
		} catch (Exception e) {
    		e.printStackTrace();
    	}
			
		return "http";
	}
}
