package fr.ign.lastig.choucas.loader;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
import fr.ign.lastig.choucas.alignment.AlignC2C;

public class LoaderC2C {
	
	private static final String BDD_URL = "jdbc:postgresql://localhost:5432/repere";
    private static final String BDD_USER = "test";
    private static final String BDD_PASSWD = "test";

	public static List<Feature> getToponyme() {
		
		List<Feature> bdtopoFeature = new ArrayList<Feature>();
		
		try {
			
			Class.forName("org.postgresql.Driver");
    		Connection con = DriverManager.getConnection(BDD_URL, BDD_USER, BDD_PASSWD);
    		
			File fileC2C = new File("./data/dataset/Dataset_Camptocamp_org.csv");
    		
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
					String uri = AlignC2C.getURI(type);
					if (uri == null) uri = "";
    			
					String wktGeom = csvRow.getField(3);
					Geometry g = reader.read(wktGeom);
					Point pt = factory.createPoint(new Coordinate(g.getCoordinate().x, g.getCoordinate().y));
					Feature defaultFeature = new Feature(pt);
    			
					defaultFeature.addAttribut("id", id);
					defaultFeature.addAttribut("uri", uri);
					defaultFeature.addAttribut("nom", nom.replace("\"", ""));
    			
					// System.out.println(id + "," + uri + ", " + nom);
					/*String sqlInsert = " INSERT INTO ficc2c (id, nom, type, uri, geom) VALUES ("
							+ "'" + id + "', "
							+ "'" + nom.replace("'", "''") + "', "
							+ "'" + type + "', "
							+ "'" + uri + "', "
							+ " ST_GeomFromText('" + wktGeom + "', 2154) "
							+ "); ";
					// System.out.println(sqlInsert);
					Statement stSelectG = con.createStatement();
	        		stSelectG.executeUpdate(sqlInsert);
	        		stSelectG.close();*/
	        		
					bdtopoFeature.add(defaultFeature);
				}
    		}
    		
    		con.close();
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        
        return bdtopoFeature;
	}
}
