package fr.ign.lastig.choucas.metadata;

import org.apache.sis.internal.jaxb.gml.Measure;
import org.apache.sis.measure.Units;
import org.apache.sis.metadata.MetadataStandard;
import org.apache.sis.metadata.iso.DefaultIdentifier;
import org.apache.sis.metadata.iso.DefaultMetadata;
import org.apache.sis.metadata.iso.DefaultMetadataScope;
import org.apache.sis.metadata.iso.identification.DefaultDataIdentification;
import org.apache.sis.metadata.iso.quality.DefaultDataQuality;
import org.apache.sis.metadata.iso.spatial.DefaultGeometricObjects;
import org.apache.sis.metadata.iso.spatial.DefaultVectorSpatialRepresentation;
import org.apache.sis.xml.IdentifierSpace;
import org.apache.sis.xml.XML;
import org.opengis.metadata.Identifier;
import org.opengis.metadata.identification.CharacterSet;
import org.opengis.metadata.identification.Identification;
import org.opengis.metadata.maintenance.ScopeCode;
import org.opengis.metadata.spatial.GeometricObjectType;
import org.opengis.metadata.spatial.TopologyLevel;

import fr.ign.lastig.choucas.metadata.IdentificationInfo.DataIdentification;
import fr.ign.lastig.choucas.metadata.IdentificationInfo.Head;
import fr.ign.lastig.choucas.metadata.ReferenceSystem.ReferenceSystemInfo;
import fr.ign.lastig.choucas.metadata.SpatialRepresentationInfo.VectorSpatialRepresentation;
import fr.ign.lastig.choucas.metadata.quality.DataQuality;
import fr.ign.lastig.choucas.metadata.quality.PositionalAccuracy;

import static java.util.Collections.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class Metadata {
	
	public static DefaultMetadata createMetadata(String nomtable) throws Exception {
		
		try {
			
			UUID identifier = UUID.randomUUID();
			DefaultMetadata metadata = new DefaultMetadata();
			
			// OK
			metadata.getIdentifierMap().putSpecialized(IdentifierSpace.UUID, identifier);
			
			// System.out.println(metadata.getIdentifiers().iterator().next().toString());
			// System.out.println("");
			
			// md.setIdentificationInfo(singleton());
        
			// md.setMetadataStandards(Arrays.asList(MetadataStandard.ISO_19115));
			// md.getIdentifierMap().putSpecialized(IdentifierSpace.UUID, identifier);
		
			// Projection
			// 
			// metadata.setReferenceSystemInfo(singleton(ReferenceSystemInfo.getReferenceSystem()));
			
			// DataIdentification
			// OK
			// metadata.setIdentificationInfo(singleton(DataIdentification.getDataIdentification()));
			
			// SpatialRepresentationInfo
			// metadata.setSpatialRepresentationInfo(singleton(VectorSpatialRepresentation.getVectorSpatialRepresentation()));
			
			
			// Quality
			metadata.setDataQualityInfo(singleton(DataQuality.getDataQuality(nomtable)));
			
			
			// metadata.setLanguages(Locale.ENGLISH);
			// metadata.setCharacterSet(CharacterSet.UTF_8);
		    // List scopeCodes = new ArrayList<ScopeCode>();
		    // scopeCodes.add(ScopeCode.DATASET);
		    // metadata.setHierarchyLevels(scopeCodes);
		
			// 
			return metadata;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
