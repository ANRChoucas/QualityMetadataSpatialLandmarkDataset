package fr.ign.lastig.choucas.metadata.SpatialRepresentationInfo;

import static java.util.Collections.singleton;

import org.apache.sis.metadata.iso.spatial.DefaultGeometricObjects;
import org.apache.sis.metadata.iso.spatial.DefaultVectorSpatialRepresentation;
import org.opengis.metadata.spatial.GeometricObjectType;
import org.opengis.metadata.spatial.TopologyLevel;

public class VectorSpatialRepresentation {
	
	/** MD_VectorSpatialRepresentation. */
	public static DefaultVectorSpatialRepresentation getVectorSpatialRepresentation() {
		
		DefaultVectorSpatialRepresentation vectorSpatialInfo = new DefaultVectorSpatialRepresentation();
		
		// MD_TopologyLevelCode
		vectorSpatialInfo.setTopologyLevel(TopologyLevel.GEOMETRY_ONLY);
		
		// MD_GeometricObjectTypeCode
		vectorSpatialInfo.setGeometricObjects(singleton(new DefaultGeometricObjects(GeometricObjectType.POINT)));
		
		return vectorSpatialInfo;
	}

}
