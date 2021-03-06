package fr.ign.lastig.choucas.loader;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTReader;

import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import fr.ign.cogit.appariement.Feature;
import fr.ign.lastig.choucas.alignment.AlignBDTopo;

public class LoaderBDTopo {
	
	public static List<Feature> getToponyme() {
		
		List<Feature> ignFeature = new ArrayList<Feature>();
		// int cpt = 0;
		try {
			
			File fileC2C = new File("./data/dataset/Dataset_POI_BDTopo.csv");
			File fileAltName = new File("./data/dataset/Dataset_POI_ALT_NAME_BDTopo.csv");
			
    		
    		WKTReader reader = new WKTReader();
    		GeometryFactory factory = new GeometryFactory();
    	
    		try (CsvReader csv = CsvReader.builder()
					.fieldSeparator(',')
					.quoteCharacter('"')
					.build(fileC2C.toPath(), UTF_8)) {
				for (final Iterator<CsvRow> iterator = csv.iterator(); iterator.hasNext();) {
					final CsvRow csvRow = iterator.next();
					
					if (csvRow.getFields().size() < 4)
						continue;
					
					if (csvRow.getField(0).equals("id")) 
						continue;
    		
					String id = csvRow.getField(0);
					String nom = csvRow.getField(1);
					String type = csvRow.getField(2);
					String uri = AlignBDTopo.getURI(type);
					if (uri == null) uri = ""; 

					String wktGeom = csvRow.getField(3);
					Geometry g = reader.read(wktGeom);
					Point pt = factory.createPoint(new Coordinate(g.getCoordinate().x, g.getCoordinate().y));
					Feature defaultFeature = new Feature(pt);
    			
					defaultFeature.addAttribut("id", id);
					defaultFeature.addAttribut("uri", uri);
					defaultFeature.addAttribut("nom", nom);

					// System.out.println(id + "," + uri + ", " + nom);
					
					try (CsvReader csvAN = CsvReader.builder()
							.fieldSeparator(',')
							.quoteCharacter('"')
							.build(fileAltName.toPath(), UTF_8)) {
						for (final Iterator<CsvRow> iteratorAN = csvAN.iterator(); iteratorAN.hasNext();) {
							final CsvRow csvRowAN = iteratorAN.next();
					
							String idAN = csvRowAN.getField(0);
							
							if (idAN.equals(id)) {
								// System.out.println(idAN + "--" + id);
								String graphie = csvRowAN.getField(1);
								// System.out.println("   " + graphie);
								defaultFeature.addGraphie(graphie);
							}
						}
					}
	        		
					ignFeature.add(defaultFeature);
				}
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
		
        return ignFeature;
	}
}
