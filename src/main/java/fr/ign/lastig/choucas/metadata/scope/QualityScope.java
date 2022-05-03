package fr.ign.lastig.choucas.metadata.scope;

// import org.apache.sis.metadata.iso.DefaultMetadataScope;
import org.apache.sis.metadata.iso.maintenance.DefaultScope;
import org.opengis.metadata.maintenance.ScopeCode;
import org.opengis.metadata.maintenance.ScopeDescription;

import fr.ign.lastig.choucas.metadata.IdentificationInfo.Head;

import static java.util.Collections.singleton;


public class QualityScope {
	
	
	public static DefaultScope getScopeAllZE() throws Exception {
		
		DefaultScope scope = new DefaultScope();
		
		scope.setExtents(singleton(Head.getExtent()));
		// scope.setLevel(ScopeCode.DATASET);
		
		//ScopeDescription scopeDesc = new ScopeDescription();
		
		scope.setLevelDescription(null);
		return scope;
		
	}

}
