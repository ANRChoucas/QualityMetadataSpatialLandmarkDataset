package fr.ign.lastig.choucas.loader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTReader;

import fr.ign.cogit.appariement.Feature;

public class LoaderOSM {
	
	private static final String BDD_URL = "jdbc:postgresql://localhost:5432/repere";
    private static final String BDD_USER = "test";
    private static final String BDD_PASSWD = "test";
	
	public static List<Feature> getToponyme() {
		
		List<Feature> c2cFeature = new ArrayList<Feature>();
		
		try {
    		Class.forName("org.postgresql.Driver");
    		Connection con = DriverManager.getConnection(BDD_URL, BDD_USER, BDD_PASSWD);
    		
    		WKTReader reader = new WKTReader();
    		GeometryFactory factory = new GeometryFactory();
    		
    		String sql = " Select id, nom, uri, ST_AsText(geom) as geom " 
    				+ " From osm "; 
    				// + " Where uri = 'http://purl.org/choucas.ign.fr/oor#sommet' "
    				// + " Limit 10 ";
    		Statement stSelect = con.createStatement();
    		ResultSet rs = stSelect.executeQuery(sql);
    		while (rs.next()) {
    			String id = rs.getString("id");
    			String nom = rs.getString("nom");
    			String uri = rs.getString("uri");
    			
    			Geometry g = reader.read(rs.getString("geom"));
    			Point pt = factory.createPoint(new Coordinate(g.getCoordinate().x, g.getCoordinate().y));
    			Feature defaultFeature = new Feature(pt);
    			
    			defaultFeature.addAttribut("id", id);
    			defaultFeature.addAttribut("uri", uri);
    			defaultFeature.addAttribut("nom", nom);
    			
    			c2cFeature.add(defaultFeature);
    		}
    		rs.close();
    		stSelect.close();
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        
        return c2cFeature;
	}
}
