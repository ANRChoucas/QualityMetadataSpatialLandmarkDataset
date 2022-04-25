package fr.ign.lastig.choucas.metadata.ReferenceSystem;

import org.apache.sis.referencing.factory.sql.EPSGFactory;
import org.opengis.referencing.crs.CoordinateReferenceSystem;


public class ReferenceSystemInfo {
	
	public static CoordinateReferenceSystem getReferenceSystem() {
		try {
			// TODO : anchor : http://www.opengis.net/def/crs/EPSG/0/3857
			EPSGFactory factory = new EPSGFactory(null);
			CoordinateReferenceSystem crs = factory.createCoordinateReferenceSystem("3857");
			factory.close();
			return crs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
